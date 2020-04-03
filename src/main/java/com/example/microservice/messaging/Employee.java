package com.example.microservice.messaging;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empId;
	private String name;
	
	public Employee(int empId, String name) {
		this.empId = empId;
		this.name = name;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}
}
