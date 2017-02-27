package pl.codeleak.sbd.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TaskCleaner {

    @Autowired
    private TaskRepository taskRepository;

    @Scheduled(fixedDelay = 2000)
    public void cleanCompleteTasks() {
        List<Task> completeTasks = taskRepository.findByDone(true);
        log.info("Found {} tasks marked as done", completeTasks.size());
        taskRepository.delete(completeTasks);
    }

}
