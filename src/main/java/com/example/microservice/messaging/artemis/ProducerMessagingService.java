package com.example.microservice.messaging.artemis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.microservice.messaging.Employee;
import com.example.microservice.messaging.ProducerService;

/**
 * This class responsible for sending messages to Artemis broker.
 * It uses Spring provided {@code JmsTemplate} to communicate with the broker.
 * 
 * @author Kush Saraiya
 *
 */
@Service
public class ProducerMessagingService implements ProducerService {

	@Autowired
	private JmsTemplate jms;

	@Override
	public void produceMessage(Employee employee) {
		
		/*
		 * In this example, we've used the convertAndSend method of the template
		 * that accepts the destination queue name and the object to be sent.
		 * 
		 * Some other common variations of the send method are
		 * 
		 * Send raw messages
			void send(MessageCreator messageCreator) throws JmsException;
			void send(Destination destination, MessageCreator messageCreator) throws JmsException;
			void send(String destinationName, MessageCreator messageCreator) throws JmsException;
		 
		 * Send messages converted from objects
			void convertAndSend(Object message) throws JmsException;
			void convertAndSend(Destination destination, Object message) throws JmsException;
			void convertAndSend(String destinationName, Object message) throws JmsException;
		 
		 * Send messages converted from objects with post-processing
			void convertAndSend(Object message, MessagePostProcessor postProcessor) throws JmsException;
			void convertAndSend(Destination destination, Object message, MessagePostProcessor postProcessor) throws JmsException;
			void convertAndSend(String destinationName, Object message, MessagePostProcessor postProcessor) throws JmsException;
		 */
		jms.convertAndSend("destination.queue", employee);

	}

}
