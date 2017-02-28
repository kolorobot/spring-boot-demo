package pl.codeleak.sbd.config;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties
@Data
public class ApplicationProperties {

    @NotNull
    private Application application;

    @Data
    public static class Application {
        @NotBlank
        private String name;
        @NotBlank
        private String url;
        @NotBlank
        private String version;
    }
}
