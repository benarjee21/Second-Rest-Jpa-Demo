package com.example.demo.beans;

import java.util.Date;

public class ExceptionMessage {
	
	private String messgae;
	private Date time;
	private String details;
	
	public ExceptionMessage(String messgae, Date time, String details) {
		super();
		this.messgae = messgae;
		this.time = time;
		this.details = details;
	}

	public String getMessgae() {
		return messgae;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionMessage [messgae=" + messgae + ", time=" + time + ", details=" + details + "]";
	}
	
}
