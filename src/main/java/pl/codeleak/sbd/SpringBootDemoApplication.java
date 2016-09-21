package pl.codeleak.sbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;

// TODO Exclude some configurations
@SpringBootApplication
public class SpringBootDemoApplication {

    // TODO Inject a custom property from application.properties

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return container -> {
            container.setSessionTimeout(60);
            // TODO Set server header from injected property value and demonstrate
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }


}
