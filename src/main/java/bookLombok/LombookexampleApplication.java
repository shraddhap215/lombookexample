package bookLombok;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Currency converter",version="1.0",description="My first project using spring boot"))
public class LombookexampleApplication {

	public static void main(String[] args) {

		SpringApplication.run(LombookexampleApplication.class, args);
	}


}
