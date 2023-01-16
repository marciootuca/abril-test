package br.com.abril.editora.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Editora Abril"
                ,description = "Api test Editora Abril"
                ,license = @License(
                name = "Apache License Version 2.0"
                )
        )

)
@Configuration
public class OpenApiConfig {


}
