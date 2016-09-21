package pl.codeleak.sbd.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
// TODO Disable WtfConfiguration based on wtf.enabled property
// TODO Enable configuration properties
public class WtfConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(WtfConfiguration.class);

    // TODO Inject custom configuration properties
    private WtfProperties wtfProperties;

    @PostConstruct
    public void postConstruct() {
        // TODO Use injected properties
        LOG.warn("\n\n == {} == \n\n", "WTF!?");
    }
}
