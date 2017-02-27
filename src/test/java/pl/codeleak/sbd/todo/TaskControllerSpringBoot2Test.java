package pl.codeleak.sbd.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerSpringBoot2Test {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void getsOne() {
        // arrange
        given(taskRepository.findOne(1L)).willReturn(new Task("Demo", true));

        // act
        ResponseEntity<Task> taskResponseEntity =
            testRestTemplate.getForEntity("/task/1", Task.class);

        // assert
        assertThat(taskResponseEntity.getBody().getTitle()).isEqualTo("Demo");
    }
}