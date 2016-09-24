package pl.codeleak.sbd.todo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

// TODO Spring Boot test with web environment
// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerSpringBoot1Test {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void createsAndGetTask() {
        // arrange
        Task newTask = null;
        // act
        Task theTask = null;
        // assert
        assertThat(theTask.getId()).isEqualTo(newTask.getId());
    }
}