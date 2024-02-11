package com.zm.mi.component;

import org.hibernate.annotations.Comment;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OnAppStartUp {
	
	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartUp()
	{
		System.out.println("HIII");
	}
}
