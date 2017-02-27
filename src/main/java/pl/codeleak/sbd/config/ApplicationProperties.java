package pl.codeleak.sbd.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.net.URL;

@Configuration
@ConfigurationProperties(prefix = "application")
@Getter
@Setter
@ToString(exclude = "env")
@Slf4j
public class ApplicationProperties {

    @Autowired
    private Environment env;

    @NotBlank
    private String name;

    @NotBlank
    private String version;

    @NotNull
    private URL url;

    @PostConstruct
    public void postConstruct() {
        log.info("\n\n\t{}\n", this.toString());
    }

}
