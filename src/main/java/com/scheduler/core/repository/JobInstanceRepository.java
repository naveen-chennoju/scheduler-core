package com.scheduler.core.repository;

import com.scheduler.core.models.JobInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobInstanceRepository extends JpaRepository<JobInstance, UUID> {

}
