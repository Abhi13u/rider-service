package com.innocito.riderservice.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
  @Autowired
  RiderServiceConfig riderServiceConfig;

  @Bean
  public GroupedOpenApi getAllApis() {
    String[] paths = {"/**"};
    String[] packagesToScan = {"com.innocito.riderservice"};
    return GroupedOpenApi.builder()
      .group("Innocito")
      .pathsToMatch(paths)
      .packagesToScan(packagesToScan)
      .build();
  }

  @Bean
  public OpenAPI customOpenApi() {
    RiderServiceConfig.Contact contact = riderServiceConfig.getContact();
    return new OpenAPI()
      .info(new Info().title(contact.getTitle())
        .description(contact.getDescription())
        .contact(new Contact().name(contact.getTeam())
          .url(contact.getUrl())
          .email(contact.getEmail()))
        .termsOfService(contact.getTerms())
        .license(new License().name(contact.getLicense()))
        .version(contact.getVersion()));
  }
}