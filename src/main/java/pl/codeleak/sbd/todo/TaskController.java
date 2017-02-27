package pl.codeleak.sbd.todo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    @Value("${application.url}")
    private String applicationUrl;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/task/{taskId}")
    public Task getTaskById(@PathVariable long taskId) {
        return taskRepository.findOne(taskId);
    }

    @PostMapping("/task")
    // curl -i -X POST -H "Content-Type:application/json" -d "{\"title\": \"Task\"}" localhost:8080/task
    public ResponseEntity createTask(@Valid @RequestBody Task task) {

        taskRepository.save(task);

        UriComponents uriComponents =
            UriComponentsBuilder
                .fromHttpUrl(applicationUrl).path("/task/{id}")
                .buildAndExpand(task.getId());

        return ResponseEntity.created(uriComponents.toUri()).body(task);
    }

    @GetMapping("/task")
    public Page<Task> getTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }
}
