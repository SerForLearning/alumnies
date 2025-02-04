package it.ser.api.alumni.rest.generated;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class SpringDocConfiguration {

    @Bean(name = "apiInfo")
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Alumni Registry Management API")
                                .description("API for handling the REST endpoints")
                                .contact(
                                        new Contact()
                                                .name("Support Team")
                                                .email("support@example.com")
                                )
                                .version("1.0.0")
                )
        ;
    }
}