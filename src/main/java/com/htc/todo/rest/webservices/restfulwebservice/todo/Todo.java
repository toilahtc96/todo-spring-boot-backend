package com.htc.todo.rest.webservices.restfulwebservice.todo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private boolean isDone;
	private Date targetDate;
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Todo(Long id, String description, boolean isDone, Date targetDate, String username) {
		super();
		this.id = id;
		this.description = description;
		this.isDone = isDone;
		this.targetDate = targetDate;
		this.username = username;
	}

	public Todo(Long id, String username, String description, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.description = description;
		this.isDone = isDone;
		this.targetDate = targetDate;
		this.username = username;
	}

	protected Todo() {}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", isDone=" + isDone + ", targetDate=" + targetDate
				+ ", username=" + username + "]";
	}

}
