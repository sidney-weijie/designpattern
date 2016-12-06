package com.sidney.foundation.JavaFoundation;

/**
 * @author Sidney
 *
 */
public class Employee {
	private String name;
	private int salary;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public int getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	public int getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	public Employee(String name, int salary, int birthYear, int birthMonth,
			int birthDay) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
	}
	
	
}
