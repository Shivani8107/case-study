package com.casestudy.emailservice;

import com.casestudy.basedomain.dto.OrderEvent;
import com.casestudy.emailservice.kafka.OrderConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailServiceApplication {

	@Autowired
	private OrderConsumer orderConsumer;
	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail(){
//		orderConsumer.simpleEmail("shivanii2607@gmail.com",new OrderEvent(),"Spring mail");
//	}
}
