package pl.codeleak.sbd.todo;

import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

// TODO Json test
public class TaskJsonTest {

    // @Autowired
    private JacksonTester<Task> json;

    @Test
    public void serializes() {
        Task task = new Task("My Task 1", true);
        // TODO Assert after serializing
    }

    @Test
    public void deserializes() throws IOException {
        String taskAsJson = "{\"title\": \"My Task 1\", \"done\": \"true\"}";
        // TODO Assert object after deserializing
    }
}
