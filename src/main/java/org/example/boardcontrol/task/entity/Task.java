package org.example.boardcontrol.task.entity;


import jakarta.persistence.*;
import lombok.*;
import org.example.boardcontrol.project.entity.Project;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String title;

    @Column(length = 100,  nullable = false)
    private String description;

    @Column(  nullable = false)
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column( nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @ToString.Exclude
    private Project project;


    public enum Status {
        TODO,
        IN_PROGRESS,
        DONE
    }

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }


    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @PrePersist
    public void PrePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        if (priority == null) {
            this.priority = Priority.MEDIUM;
        }
        if (status == null) {
            this.status = Status.TODO;
        }

    }

    @PreUpdate
    public void PreUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
