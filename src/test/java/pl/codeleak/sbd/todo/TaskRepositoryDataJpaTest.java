package pl.codeleak.sbd.todo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// @TODO Data Jpa tests
public class TaskRepositoryDataJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void createsTask() {
        // TODO Implement the test

        // arrange

        // act

        // assert
    }

    @Test
    public void findsByTitle() {
        // TODO Implement the test

        // arrange
        entityManager.persist(new Task("Demo 1", true));
        entityManager.persist(new Task("Demo 2", true));
        entityManager.persist(new Task("Demo 3", true));

        // act
        List<Task> tasks = null;

        // assert
        assertThat(tasks).hasSize(3);
    }

}
