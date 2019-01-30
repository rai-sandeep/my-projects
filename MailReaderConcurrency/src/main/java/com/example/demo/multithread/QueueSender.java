package com.example.demo.multithread;

import org.springframework.stereotype.Component;

@Component
public class QueueSender {
	
	public void sendToQueue(String email) {
		System.out.println(Thread.currentThread().getId()+": Start queue send email: "+email);
		try {
			Thread.sleep((long) (Math.random()*10*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getId()+": End queue send email: "+email);
	}

}
