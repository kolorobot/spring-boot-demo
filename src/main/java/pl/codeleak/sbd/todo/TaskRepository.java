package pl.codeleak.sbd.todo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    @Query("select t from Task t where t.done = :done")
    List<Task> findByDone(@Param("done") boolean done);

}
