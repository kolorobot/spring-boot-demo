package pl.codeleak.sbd.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConditionalOnProperty(name = "wtf.enabled", havingValue = "true")
@EnableConfigurationProperties(WtfProperties.class)
public class WtfConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(WtfConfiguration.class);

    @Autowired
    private WtfProperties wtfProperties;

    @PostConstruct
    public void postConstruct() {
        LOG.warn("\n\n == {} == \n\n", wtfProperties.getWelcomeMessage());
    }
}
