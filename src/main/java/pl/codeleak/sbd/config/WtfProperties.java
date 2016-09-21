package pl.codeleak.sbd.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.Size;

@ConfigurationProperties(prefix = "wtf")
public class WtfProperties {

    @Size(min = 10)
    @Getter
    @Setter
    private String welcomeMessage;

}
