package com.example.demo.controller;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	private Scheduler schedular;

	@GetMapping("/start")
	@ResponseBody
	public String Start() throws SchedulerException, InterruptedException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		schedular = schedulerFactory.getScheduler();
		JobDetail jobdetail = JobBuilder.newJob(MyJob.class).withIdentity("cronNameJobKey1", "cronGroupJobKey1")
				.build();
		// Executes after every 5 seconds 
		CronTrigger crontrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "cronGroupJobKey1")
				.withSchedule(CronScheduleBuilder.cronSchedule("1/5 * * ? * *")).build();
		schedular.scheduleJob(jobdetail, crontrigger);
		schedular.start();
		return "Cron Schedular Started!";
	}

	@GetMapping("/stop")
	@ResponseBody
	public String Stop() throws SchedulerException {
		schedular.shutdown(true);
		return "Cron Schedular Stopped!";
	}
}
