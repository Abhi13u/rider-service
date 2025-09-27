package com.innocito.riderservice.common.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.innocito.riderservice.common.util.ApiResponse;
import com.innocito.riderservice.common.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.innocito.axcl.util.Messages.BODY;
import static com.innocito.axcl.util.Messages.ERROR_MESSAGE;
import static com.innocito.axcl.util.Messages.INVALID_REQUEST_BODY_PROVIDED;
import static com.innocito.riderservice.common.constants.AppConstants.COLON_DELIMITER;
import static com.innocito.riderservice.common.constants.AppConstants.COMMA_DELIMITER;
import static com.innocito.riderservice.common.constants.AppConstants.DOT_DELIMITER;
import static com.innocito.riderservice.common.constants.AppConstants.DOT_DELIMITER_REGEX;
import static com.innocito.riderservice.common.constants.AppConstants.HYPHEN_DELIMITER;
import static com.innocito.riderservice.common.constants.AppConstants.OPEN_SQUARE_BRACKET;
import static com.innocito.riderservice.common.constants.AppConstants.SPACE_DELIMITER;
import static com.innocito.riderservice.common.exception.ErrorMessages.CUSTOM_MSG;

@Slf4j
@ResponseBody
@RequiredArgsConstructor
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  private final ResponseUtil responseUtil;

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ApiResponse<?>> handleNotFoundException(NotFoundException exception) {
    log.error(ErrorCode.NOT_FOUND + ERROR_MESSAGE + exception.getMessage(), exception);
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));

    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

  @Override
  public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
                                                             HttpHeaders httpHeaders, HttpStatusCode statusCode
    , WebRequest request) {
    String message = INVALID_REQUEST_BODY_PROVIDED;
    Throwable rootCause = exception.getMostSpecificCause();

    if (rootCause instanceof InvalidFormatException) {
      InvalidFormatException invalidFormatException = (InvalidFormatException) rootCause;
      message = String.format(ErrorMessages.INVALID_VALUE_NOT_EXPECTED_TYPE,
        invalidFormatException.getValue(),
        invalidFormatException.getPath().stream()
          .map(reference -> reference.getFieldName() != null
            ? reference.getFieldName() : String.format("[%d]", reference.getIndex()))
          .collect(Collectors.joining(DOT_DELIMITER)),
        invalidFormatException.getTargetType().getSimpleName());
    }
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(BODY, INVALID_REQUEST_BODY_PROVIDED + COLON_DELIMITER + SPACE_DELIMITER + message));
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    Map<String, String> errors = new HashMap<>();
    List<ErrorResponseDTO> errorsResponse = new ArrayList<>();
    exception.getBindingResult().getFieldErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      Object value = ((FieldError) error).getRejectedValue();
      if (fieldName.contains(OPEN_SQUARE_BRACKET)) {
        if (fieldName.contains(DOT_DELIMITER)) {
          value = fieldName.split(DOT_DELIMITER_REGEX)[1];
        }
        fieldName = fieldName.split("[\\[\\]]")[0];
        Object errorField = errors.get(fieldName);
        if (ObjectUtils.isNotEmpty(errorField)) {
          if (!errorField.toString().contains(String.valueOf(value))) {
            errors.put(fieldName, value + COMMA_DELIMITER + errors.get(fieldName));
          }
        } else {
          String separator = new StringBuilder().append(SPACE_DELIMITER).append(HYPHEN_DELIMITER)
            .append(SPACE_DELIMITER).toString();
          errors.put(fieldName, value + separator + error.getDefaultMessage());
        }
      } else {
        String message = error.getDefaultMessage();
        errors.put(fieldName, message);
        errorsResponse.add(new ErrorResponseDTO(fieldName, message));
      }
    });
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errorsResponse);
    log.error(ErrorCode.CONSTRAINT_VIOLATION.name() + CUSTOM_MSG + errors);
    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ApiResponse<?>> handleConstraintViolation(ConstraintViolationException exception,
                                                                  WebRequest request) {
    Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
    String errorMessage = StringUtils.EMPTY;
    List<ErrorResponseDTO> errors = new ArrayList<>();
    if (!violations.isEmpty()) {
      ConstraintViolation<?> error = violations.iterator().next();
      if (ObjectUtils.isNotEmpty(error)) {
        String invalidValue = error.getInvalidValue() == null || error.getInvalidValue().toString().isBlank() ?
          StringUtils.EMPTY : error.getInvalidValue().toString();
        errorMessage = invalidValue + SPACE_DELIMITER + error.getMessage();
        String fieldName = error.getPropertyPath().toString();
        errors.add(new ErrorResponseDTO(fieldName, errorMessage));
      }
    }
    log.error(ErrorCode.CONSTRAINT_VIOLATION.name() + CUSTOM_MSG + exception.getMessage(), exception);
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException exception,
                                                                        HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    String fieldName = exception.getParameterName();
    String errorMessage = exception.getMessage();
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(fieldName, errorMessage));

    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(JsonException.class)
  public ResponseEntity<ApiResponse<?>> handleJsonException(JsonException exception) {
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));

    log.error(ErrorCode.JSON_EXCEPTION.name() + CUSTOM_MSG + exception.getMessage(), exception);
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(EntityExistsException.class)
  public ResponseEntity<ApiResponse<?>> handleEntityExistsException(EntityExistsException exception) {
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));

    log.error(ErrorCode.ENTITY_EXISTS.name() + CUSTOM_MSG + exception.getMessage(), exception);
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(EnumNotFoundException.class)
  public ResponseEntity<ApiResponse<?>> handleEnumNotFoundException(EnumNotFoundException exception) {
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));

    log.error(ErrorCode.NOT_FOUND.name() + CUSTOM_MSG + exception.getMessage(), exception);
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(LimitConstraintException.class)
  public ResponseEntity<ApiResponse<?>> handleLimitConstraintException(LimitConstraintException exception) {
    log.error(ErrorCode.CONSTRAINT_VIOLATION.name() + CUSTOM_MSG + exception.getMessage(), exception);
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ConstraintFailedException.class)
  public ResponseEntity<ApiResponse<?>> handleConstraintFailedException(ConstraintFailedException exception) {
    log.error(ErrorCode.CONSTRAINT_VIOLATION.name() + CUSTOM_MSG + exception.getMessage(), exception);
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UniqueConstraintViolationException.class)
  public ResponseEntity<ApiResponse<?>> handleUniqueConstraintFailedException(UniqueConstraintViolationException exception) {
    log.error(ErrorCode.CONSTRAINT_VIOLATION.name() + CUSTOM_MSG + exception.getMessage(), exception);
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));

    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ExternalApiException.class)
  public ResponseEntity<ApiResponse<?>> handleExternalApiException(ExternalApiException exception) {
    log.error(ErrorCode.EXTERNALAPI_EXCEPTION.name() + CUSTOM_MSG + exception.getMessage(), exception);
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));

    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.SERVICE_UNAVAILABLE);
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<ApiResponse<?>> handleValidationException(final ValidationException exception, final HttpServletRequest request) {
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, exception.getErrors());
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleServletRequestBindingException(
    ServletRequestBindingException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    log.error(ErrorCode.CONSTRAINT_VIOLATION.name() + CUSTOM_MSG + exception.getMessage(), exception);

    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getBody().toString(), exception.getMessage()));
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InvalidInputException.class)
  public ResponseEntity<ApiResponse<?>> handleInvalidInputException(InvalidInputException exception) {
    log.error(ErrorCode.INVALID_INPUT.name() + CUSTOM_MSG + exception.getMessage(), exception);

    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InvalidConfigurationException.class)
  public ResponseEntity<ApiResponse<?>> handleInvalidConfigurationException(InvalidConfigurationException exception) {
    log.error(ErrorCode.INVALID_INPUT.name() + CUSTOM_MSG + exception.getMessage(), exception);

    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(SocketTimeoutException.class)
  public ResponseEntity<ApiResponse<?>> handleSocketTimeoutException(SocketTimeoutException exception) {
    log.error(ErrorCode.SOCKET_TIMEOUT.name() + CUSTOM_MSG + exception.getMessage(), exception);
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(ERROR_MESSAGE, exception.getMessage()));
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.GATEWAY_TIMEOUT);
  }

  @ExceptionHandler(TimeOutException.class)
  public ResponseEntity<ApiResponse<?>> handleTimeOutException(TimeOutException exception) {
    log.error(ErrorCode.TIMEOUT_EXCEPTION.name() + CUSTOM_MSG + exception.getMessage(), exception);

    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.GATEWAY_TIMEOUT);
  }

  @ExceptionHandler(ServerUnavailableException.class)
  public ResponseEntity<ApiResponse<?>> handleServerUnavailableException(ServerUnavailableException exception) {
    log.error(ErrorCode.SERVER_UNAVAILABLE.name() + CUSTOM_MSG + exception.getMessage(), exception);
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.SERVICE_UNAVAILABLE);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<ApiResponse<?>> handleDataIntegrityViolationException(
    DataIntegrityViolationException exception) {

    String message = "Duplicate key error";
    String field = "unknown";

    if (exception.getCause() != null && exception.getCause().getCause() != null) {
      String rootMessage = exception.getCause().getCause().getMessage();

      if (rootMessage != null && rootMessage.contains("violates unique constraint")) {
        int startIdx = rootMessage.indexOf("\"");
        int endIdx = rootMessage.indexOf("\"", startIdx + 1);
        if (startIdx > 0 && endIdx > startIdx) {
          String constraintName = rootMessage.substring(startIdx + 1, endIdx);
          if (constraintName.endsWith("_key") && constraintName.contains("_")) {
            String[] parts = constraintName.split("_");
            field = parts[parts.length - 2]; // second last part is usually field
          }
        }

        if (rootMessage.contains("Detail: Key")) {
          int valStart = rootMessage.indexOf(")=(");
          int valEnd = rootMessage.indexOf(")", valStart + 3);
          if (valStart > 0 && valEnd > valStart) {
            String value = rootMessage.substring(valStart + 3, valEnd);
            message = String.format("%s '%s' already exists.", StringUtils.capitalize(field), value);
          } else {
            message = String.format("%s already exists.", StringUtils.capitalize(field));
          }
        }
      }
    }

    log.error(ErrorCode.CONSTRAINT_VIOLATION.name() + CUSTOM_MSG + message, exception);
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(field, message));

    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(RiderServiceException.class)
  public ResponseEntity<ApiResponse<?>> handleRiderServiceException(RiderServiceException exception) {
    log.error(ErrorCode.RIDERSERVICE_EXCEPTION.name() + CUSTOM_MSG + exception.getMessage());
    List<ErrorResponseDTO> errors = new ArrayList<>();
    errors.add(new ErrorResponseDTO(exception.getKey(), exception.getMessage()));
    ApiResponse<?> exceptionResponse = responseUtil.error(ERROR_MESSAGE, errors);
    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}