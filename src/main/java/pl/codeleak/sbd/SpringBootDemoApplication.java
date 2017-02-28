package pl.codeleak.sbd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.codeleak.sbd.config.ApplicationProperties;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
@EnableScheduling
@Slf4j
public class SpringBootDemoApplication {

	@Autowired
    private ApplicationProperties properties;

	@PostConstruct
	public void init() {
		ApplicationProperties.Application application = properties.getApplication();
		log.info("{} {} {}", application.getName(), application.getVersion(), application.getUrl());
	}

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
