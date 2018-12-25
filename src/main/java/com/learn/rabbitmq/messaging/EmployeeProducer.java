package com.learn.rabbitmq.messaging;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.learn.rabbitmq.aplikasibelajarbroker.model.Employee;

public class EmployeeProducer {
	
	
	public void send(Employee employee) throws InterruptedException {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		String message = "";
		AmqpTemplate amqpTemplate = null;
		if(employee.getDivision().equals("IT")) {
			amqpTemplate = (RabbitTemplate) applicationContext.getBean("empITTemplate");
		}else if(employee.getDivision().equals("HR")) {
			amqpTemplate = (RabbitTemplate) applicationContext.getBean("empHRTemplate");
		}
		Gson gson = new Gson();
		message = gson.toJson(employee);
		amqpTemplate.convertAndSend(message);
		Thread.sleep(1000);
		applicationContext.close();
	}

}
