package pl.codeleak.sbd.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerSpringBoot1Test {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void createsAndGetTask() {
        // arrange
        Task newTask = testRestTemplate.postForObject("/task", new Task("Testing", true), Task.class);
        // act
        Task theTask = testRestTemplate.getForObject("/task/" + newTask.getId(), Task.class);
        // assert
        assertThat(theTask.getId()).isEqualTo(newTask.getId());
    }
}