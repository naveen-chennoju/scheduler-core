package com.scheduler.core.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "job_instance")
public class JobInstance {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID jobId;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    private LocalDateTime scheduledTime;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;

    private int retryCount = 0;

    public enum Status {
        PENDING,
        RUNNING,
        SUCCESS,
        FAILED,
        DEAD
    }
}
