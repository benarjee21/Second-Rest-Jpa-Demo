package com.example.demo.beans;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	
	private int Id;
	@Size(min=2,message="Name should have more than 2 chars")
	private String Name;
	@Past
	private Date date;
	
	public User(int id, String name, Date date) {
		super();
		Id = id;
		Name = name;
		this.date = date;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", date=" + date + "]";
	}
		

}
