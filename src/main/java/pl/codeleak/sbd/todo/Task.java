package pl.codeleak.sbd.todo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

// TODO Enable task entity
// @Entity
public class Task {

    // @Id
    // @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @NotBlank
    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private boolean done = false;

    public Task() {

    }

    public Task(String title, boolean done) {
        this.title = title;
        this.done = done;
    }
}