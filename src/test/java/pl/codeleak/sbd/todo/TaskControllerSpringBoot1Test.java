package pl.codeleak.sbd.todo;

import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

// TODO Spring Boot Test with web environment
// @RunWith(SpringRunner.class)
 public class TaskControllerSpringBoot1Test {

    // @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void test() {
        testRestTemplate.getForObject("/", String.class);
    }
}