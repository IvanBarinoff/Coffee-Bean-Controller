package barinov.coffee.bean.controller.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Coffee Bean Controller",
                description = "A coffee bean controller for processing incoming information about the coffee bean",
                version = "1.0.0"
        )
)
public class OpenApiConfig {
}
