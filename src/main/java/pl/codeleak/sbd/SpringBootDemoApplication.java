package pl.codeleak.sbd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {JmxAutoConfiguration.class})
public class SpringBootDemoApplication {

    @Value("${applicationName:}")
    private String applicationName;

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return container -> {
            container.setSessionTimeout(60);
            container.setServerHeader(applicationName);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }


}
