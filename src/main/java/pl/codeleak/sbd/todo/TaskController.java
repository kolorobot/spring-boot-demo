package pl.codeleak.sbd.todo;

import org.springframework.http.ResponseEntity;

// TODO Implement endpoints
// @RestController
public class TaskController {

    public TaskController() {

    }

    // TODO GET /task/{taskId}
    public Task getTaskById(long taskId) {
        return null;
    }

    // TODO POST /task
    public ResponseEntity createTask(Task task) {
        return null;
    }

    // TODO GET /task
    // public Page<Task> getTasks(Pageable pageable) {
    //     return null;
    // }
}
