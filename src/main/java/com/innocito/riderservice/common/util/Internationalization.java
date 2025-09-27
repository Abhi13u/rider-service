package com.innocito.riderservice.common.util;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

import static com.innocito.riderservice.common.constants.AppConstants.LANGUAGE;
import static com.innocito.riderservice.common.constants.AppConstants.MESSAGES_PATH;
import static com.innocito.riderservice.common.constants.AppConstants.MESSAGE_SOURCE;
import static com.innocito.riderservice.common.constants.AppConstants.UTF_8;

@Configuration
public class Internationalization implements WebMvcConfigurer {
  @Bean
  public LocaleResolver localeResolver() {
    SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
    sessionLocaleResolver.setDefaultLocale(Locale.US);
    return sessionLocaleResolver;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    localeChangeInterceptor.setParamName(LANGUAGE);
    return localeChangeInterceptor;
  }

  @Bean(MESSAGE_SOURCE)
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames(MESSAGES_PATH);
    messageSource.setDefaultEncoding(UTF_8);
    return messageSource;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }
}