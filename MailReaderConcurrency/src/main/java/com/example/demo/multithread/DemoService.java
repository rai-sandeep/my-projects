package com.example.demo.multithread;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	
	List<String> mailBoxes = Arrays.asList("mb1", "mb2", "mb3", "mb4", "mb5", "mb6", "mb7", "mb8", "mb9", "mb10");
	
	@Autowired
	TaskExecutor mailTaskExecutor;
	
	@Autowired
	TaskExecutor queueTaskExecutor;
	
	@Autowired
	MailReader mailReader;
	
	@Autowired
	QueueSender queueSender;
	
	public void process() {
		
		for (String mb : mailBoxes) {
			mailTaskExecutor.execute( new Runnable() {
	               public void run() {
	            	   for (String email: mailReader.readMail(mb)) {
	            		   queueTaskExecutor.execute( new Runnable() {
	       		               public void run() {
	       		            	   queueSender.sendToQueue(email);
	       		               }
	       		         	});
	       			}
	               }
	          });
		}
		
		//while (mailTaskExecutor.getActiveCount()>0) {};
		//while (queueTaskExecutor.getActiveCount()>0) {};
	}

}
