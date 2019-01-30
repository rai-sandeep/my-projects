package com.example.demo.multithread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MailReader {
	
	Map <String, List<String>> mailboxWithMails = new HashMap <String, List<String>>();
	
	List<String> mb1Mails = Arrays.asList("mb1Msg1", "mb1Msg2", "mb1Msg3");
	List<String> mb2Mails = Arrays.asList("mb2Msg1", "mb2Msg2", "mb2Msg3",
			"mb2Msg4", "mb2Msg5", "mb2Msg6");
	List<String> mb3Mails = Arrays.asList("mb3Msg1", "mb3Msg2", "mb3Msg3",
			"mb3Msg4", "mb3Msg5", "mb3Msg6");
	List<String> mb4Mails = Arrays.asList("mb4Msg1");
	List<String> mb5Mails = new ArrayList<String>();
	List<String> mb6Mails = Arrays.asList("mb6Msg1", "mb6Msg2", "mb6Msg3",
			"mb6Msg4", "mb6Msg5", "mb6Msg6", "mb6Msg7", "mb6Msg8", "mb6Msg9",
			"mb6Msg10");
	List<String> mb7Mails = Arrays.asList("mb7Msg1", "mb7Msg2", "mb7Msg3");
	List<String> mb8Mails = Arrays.asList("mb8Msg1", "mb8Msg2", "mb8Msg3",
			"mb8Msg4", "mb8Msg5", "mb8Msg6");
	List<String> mb9Mails = Arrays.asList("mb9Msg1", "mb9Msg2", "mb9Msg3",
			"mb9Msg4", "mb9Msg5", "mb9Msg6");
	List<String> mb10Mails = Arrays.asList("mb10Msg1");
	
	public MailReader() {
		mailboxWithMails.put("mb1", mb1Mails);
		mailboxWithMails.put("mb2", mb2Mails);
		mailboxWithMails.put("mb3", mb3Mails);
		mailboxWithMails.put("mb4", mb4Mails);
		mailboxWithMails.put("mb5", mb5Mails);
		mailboxWithMails.put("mb6", mb6Mails);
		mailboxWithMails.put("mb7", mb7Mails);
		mailboxWithMails.put("mb8", mb8Mails);
		mailboxWithMails.put("mb9", mb9Mails);
		mailboxWithMails.put("mb10", mb10Mails);
	}
	
	public List<String> readMail(String mbName) {
		System.out.println(Thread.currentThread().getId()+": Start mail read mailbox: "+mbName);
		try {
			Thread.sleep((long) (Math.random()*5*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getId()+": End mail read mailbox: "+mbName);
		return mailboxWithMails.get(mbName);
	}

}
