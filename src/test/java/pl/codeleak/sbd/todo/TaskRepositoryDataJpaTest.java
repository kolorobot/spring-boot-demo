package pl.codeleak.sbd.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(properties = "spring.datasource.initialize=false")
public class TaskRepositoryDataJpaTest {

    @Autowired
    private ConfigurableEnvironment env;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void createsTask() {
        // arrange
        Task newTask = new Task("Demo 1", true);
        // act
        taskRepository.save(newTask);
        // assert
        assertThat(newTask.getId()).isPositive();
    }

    @Test
    public void findsByDone() {
        // arrange
        entityManager.persist(new Task("Demo 1", true));
        entityManager.persist(new Task("Demo 2", false));
        entityManager.persist(new Task("Demo 3", true));

        // act
        List<Task> tasks = taskRepository.findByDone(true);

        // assert
        assertThat(tasks).hasSize(2);
    }

}
