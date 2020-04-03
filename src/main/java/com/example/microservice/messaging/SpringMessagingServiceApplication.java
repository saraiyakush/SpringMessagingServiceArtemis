package com.example.microservice.messaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.microservice.messaging.artemis.ConsumerMessagingService;
import com.example.microservice.messaging.artemis.ProducerMessagingService;

@SpringBootApplication
public class SpringMessagingServiceApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringMessagingServiceApplication.class, args);
		demo(ctx);
	}

	private static void demo(ConfigurableApplicationContext ctx) throws InterruptedException {
		
		ProducerMessagingService messagingService = ctx.getBean(ProducerMessagingService.class);
		ConsumerMessagingService consumerService =  ctx.getBean(ConsumerMessagingService.class);
		
		Employee employee1 = new Employee(1, "Kush");
		Employee employee2 = new Employee(2, "Saraiya");
		Employee employee3 = new Employee(3, "Developer");
		
		/*
		 * Notice that the console will show the messages are received via listeners without any call made to them
		 */
		
		messagingService.produceMessage(employee1);
		System.out.println(employee1.toString() + " sent");
		
		Thread.sleep(2000);
		messagingService.produceMessage(employee2);
		System.out.println(employee2.toString() + " sent");
		
		Thread.sleep(2000);
		messagingService.produceMessage(employee3);
		System.out.println(employee3.toString() + " sent");

	}
}
