package com.scheduler.core.util;

import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

public class CronParserUtil {

    private static final CronParser parser = new CronParser(
            CronDefinitionBuilder.instanceDefinitionFor(CronType.UNIX)
    );

    public static LocalDateTime getNextRunTime(String cronExpression, LocalDateTime fromTime) {
        Cron cron = parser.parse(cronExpression);
        ExecutionTime executionTime = ExecutionTime.forCron(cron);
        ZonedDateTime fromZoned = fromTime.atZone(ZoneId.systemDefault());
        Optional<ZonedDateTime> next = executionTime.nextExecution(fromZoned);
        return next.map(ZonedDateTime::toLocalDateTime).orElse(null);
    }
}
