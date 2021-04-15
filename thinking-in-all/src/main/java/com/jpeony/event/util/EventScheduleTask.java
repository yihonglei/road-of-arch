package com.jpeony.event.util;


import java.time.LocalDateTime;

import com.jpeony.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class EventScheduleTask {
  @Autowired
  private EventService eventService;
  
  @Scheduled(cron = "0 0/1 * * * ?")
  private void configureTasks() {
    System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    this.eventService.bagEventJob();
  }
}
