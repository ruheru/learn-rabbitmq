package com.learn.rabbitmq.messaging;

import com.google.gson.Gson;
import com.learn.rabbitmq.aplikasibelajarbroker.model.Employee;

public class EmployeeConsumer {
	
	public void listenQueue(String message) {
		Gson gson = new Gson();
		Employee emp = gson.fromJson(message, Employee.class);
		String alert = "";
		if("IT".equals(emp.getDivision())) {
			alert = "Listen IT queue";
		}else {
			alert = "listen HR queue";
		}
		System.out.println(alert);
		System.out.println("ID : "+emp.getId());
		System.out.println("First Name : " + emp.getFirstName());
        System.out.println("Last Name : " + emp.getLastName());
        System.out.println("Divisi : " + emp.getDivision());
	}

}
