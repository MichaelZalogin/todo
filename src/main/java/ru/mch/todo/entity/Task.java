package ru.mch.todo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Type;
import org.hibernate.type.StandardBasicTypes;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task", schema = "public")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    @Type()
    private LocalDateTime created = LocalDateTime.now();

    @Column(name = "done")
    private boolean done;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}