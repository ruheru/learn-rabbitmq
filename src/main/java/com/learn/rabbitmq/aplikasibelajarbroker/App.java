package com.learn.rabbitmq.aplikasibelajarbroker;

import com.learn.rabbitmq.aplikasibelajarbroker.model.Employee;
import com.learn.rabbitmq.messaging.EmployeeProducer;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		Employee employee = new Employee();
		employee.setId(123);
		employee.setFirstName("Ahsan");
		employee.setLastName("Rangk");
		employee.setDivision("IT");
		EmployeeProducer producer = new EmployeeProducer();
		producer.send(employee);
	}

}
