package pl.codeleak.sbd.todo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String title;

    private boolean done = false;

    public Task() {

    }

    public Task(String title, boolean done) {
        this.title = title;
        this.done = done;
    }
}