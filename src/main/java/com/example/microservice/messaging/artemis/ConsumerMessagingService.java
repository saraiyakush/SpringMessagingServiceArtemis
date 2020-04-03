package com.example.microservice.messaging.artemis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.microservice.messaging.Employee;

/**
 * This class is responsible for receiving the messages from Artemis broker server.
 * It uses Spring provided {@code JmsTemplate} to communicate with the broker.
 * 
 * @author Kush Saraiya
 *
 */
@Service
public class ConsumerMessagingService {

	@Autowired
	JmsTemplate jms;

	/*
	 * Here, we've used the push model (listener) to consume the messages.
	 * Notice that in this case you don't need to explicitly call the broker using a JmsTemplate 
	 */
	@JmsListener(destination = "destination.queue")
	public void receiveByPush(Employee employee) {
		System.out.println(employee + " received via listener");
	}

	/*
	 * Here, we use the pull model to consume the messages.
	 * In this case, the caller will ask the broker for the message when it is ready and the thread is blocked.
	 * 
	 * The demo of this application shows just the push mechanism.
	 * Pull mechanism is added just for reference.
	 * 
	 */
	public void receiveByPull() {
		System.out.println("Requesting next message from the broker");
		Employee employee = (Employee) jms.receiveAndConvert("destination.queue");
		System.out.println(employee + " received via pull");
	}
}
