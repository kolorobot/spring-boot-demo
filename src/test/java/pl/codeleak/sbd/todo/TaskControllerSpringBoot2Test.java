package pl.codeleak.sbd.todo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

// TODO Spring Boot Test with web environment and @MockBean
// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerSpringBoot2Test {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void getsOne() {
        // arrange
        given(taskRepository.getOne(1L))
            .willReturn(new Task("Demo", false));

        // act
        ResponseEntity<Task> taskResponseEntity =
            testRestTemplate.getForEntity("/task/1", Task.class);

        // assert
        assertThat(taskResponseEntity.getBody().getTitle()).isEqualTo("Demo");
    }
}