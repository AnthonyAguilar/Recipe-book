package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@ImportResource({"classpath:/META-INF/portal/context.xml"})
@EnableJpaRepositories(basePackages = {
        "*app.datasource*"
})
@EntityScan( basePackages = {"*app.recipe.entity*"} )
public class Application extends SpringBootServletInitializer {
			
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}