package pl.codeleak.sbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO Exclude JmxAutoConfiguration
// TODO Add logging via Lombok
@SpringBootApplication
public class SpringBootDemoApplication {

    // TODO Inject ApplicationProperties

    // TODO Inject a application property e.g. spring.profiles.active

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
