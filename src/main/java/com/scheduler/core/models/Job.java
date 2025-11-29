package com.scheduler.core.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String cronExpression;

    private boolean enabled = true;

    private LocalDateTime nextRunTime;
}
