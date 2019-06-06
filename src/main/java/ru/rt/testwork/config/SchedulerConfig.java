package ru.rt.testwork.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.rt.testwork.services.ReloadService;

import java.util.TimeZone;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    final Logger logger = LoggerFactory.getLogger(SchedulerConfig.class);

    @Autowired
    ReloadService reloadService;

    @Scheduled(cron = "${cron.reload}",zone = "${cron.reload.timezone}")
    public void startReload(){
        logger.info("Start reload by cron.");
        try {
            reloadService.reload();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Error while reload by cron: " + e.getMessage());
        }

    }
}
