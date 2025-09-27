package com.innocito.riderservice.common.exception;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
  NOT_FOUND("not_found"),
  ENTITY_EXISTS("entity_exists"),
  CONSTRAINT_VIOLATION("constraint_violation"),
  JSON_EXCEPTION("json_exception"),
  SOCKET_TIMEOUT("socket_timeout"),
  TIMEOUT_EXCEPTION("timeout_exception"),
  SERVER_UNAVAILABLE("server_unavailable"),
  RIDERSERVICE_EXCEPTION("riderservice_exception"),
  EXTERNALAPI_EXCEPTION("externalapi_exception"),
  INVALID_INPUT("invalid_input");

  @JsonValue
  @Getter
  private final String code;
}
