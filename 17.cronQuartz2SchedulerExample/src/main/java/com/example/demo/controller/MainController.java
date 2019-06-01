package com.example.demo.controller;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.CronTask;
import com.example.demo.repository.CronTaskRepository;

@Controller
public class MainController {

	@Autowired
	private CronTaskRepository cronTaskRepository;
	
	private Scheduler schedular;

	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "<a href='http://localhost:8080/start'>Start Cron Job Schedular!</a><br>"
				+ "<a href='http://localhost:8080/stop'>Stop Cron Job Schedular!</a><br>";
	}

	@GetMapping("/start")
	@ResponseBody
	public String Start() throws SchedulerException, InterruptedException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		schedular = schedulerFactory.getScheduler();
		
		List<CronTask> cronJobList = (List<CronTask>) cronTaskRepository.findAll();
		cronJobList.forEach(cronJob -> {
			JobDetail jobdetail = JobBuilder.newJob(MyJob.class).withIdentity(String.valueOf(cronJob.getId()), cronJob.getTaskName())
					.build();
			CronTrigger crontrigger = TriggerBuilder.newTrigger().withIdentity(String.valueOf(cronJob.getId()), cronJob.getCronExpression())
					.withSchedule(CronScheduleBuilder.cronSchedule(cronJob.getCronExpression())).build();
			try {
				schedular.scheduleJob(jobdetail, crontrigger);
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		});
		
		schedular.start();
		return "<em>Cron Schedular Started!</em><br>"
				+ "<a href='http://localhost:8080/stop'>Stop Cron Job Schedular!</a><br>";
	}

	@GetMapping("/stop")
	@ResponseBody
	public String Stop() throws SchedulerException {
		schedular.shutdown(true);
		return "<em>Cron Schedular Stopped!</em><br>"
				+ "<a href='http://localhost:8080/start'>Start Cron Job Schedular!</a><br>";
	}
}
