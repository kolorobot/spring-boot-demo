package pl.codeleak.sbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;
import pl.codeleak.sbd.config.WtfConfiguration;

// TODO Exclude some configurations
@SpringBootApplication
public class SpringBootDemoApplication {

    private WtfConfiguration wtfConfiguration;

    // Works as of Spring 4.3
    public SpringBootDemoApplication(WtfConfiguration wtfConfiguration) {
        Assert.notNull(wtfConfiguration);
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return container -> {
            container.setSessionTimeout(60);
            // TODO Set server header value and demonstrate
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }


}
