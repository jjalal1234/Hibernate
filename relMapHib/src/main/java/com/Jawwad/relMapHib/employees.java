package com.Jawwad.relMapHib;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class employees {
	@Id
	private int id;
	private String last_name;
	private String first_name;
	private String email;
	private String department;
	private double salary;
	@ManyToMany(mappedBy="emp")
	private List<Laptop> lapTop = new ArrayList<Laptop>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public List<Laptop> getLapTop() {
		return lapTop;
	}
	public void setLapTop(List<Laptop> lapTop) {
		this.lapTop = lapTop;
	}
	@Override
	public String toString() {
		return "employees [id=" + id + ", last_name=" + last_name + ", first_name=" + first_name + ", email=" + email
				+ ", department=" + department + ", salary=" + salary + ", lapTop=" + lapTop + "]";
	}
}
