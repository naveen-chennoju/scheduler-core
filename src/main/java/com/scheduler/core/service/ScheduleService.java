package com.scheduler.core.service;

import com.scheduler.core.models.Job;
import com.scheduler.core.models.JobInstance;
import com.scheduler.core.repository.JobInstanceRepository;
import com.scheduler.core.repository.JobRepository;
import com.scheduler.core.util.CronParserUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleService {

    public JobRepository jobRepository;
    public JobInstanceRepository jobInstanceRepository;

    public ScheduleService(JobRepository jobRepository, JobInstanceRepository jobInstanceRepository) {
        this.jobRepository = jobRepository;
        this.jobInstanceRepository = jobInstanceRepository;
    }

    @Scheduled(fixedRate = 10000)
    @Transactional
    public void scheduledJobs() {
        System.out.println("running job...");
        List<Job> scheduledJobs = jobRepository.findByEnabledTrue();

        for (Job job : scheduledJobs) {
            JobInstance instance = new JobInstance();
            instance.setJobId(job.getId());
            instance.setScheduledTime(LocalDateTime.now());
            jobInstanceRepository.save(instance);

            job.setNextRunTime(CronParserUtil.getNextRunTime(job.getCronExpression(),LocalDateTime.now()));
            jobRepository.save(job);
        }
    }
}
