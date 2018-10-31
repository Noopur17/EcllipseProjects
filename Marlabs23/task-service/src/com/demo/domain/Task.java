package com.demo.domain;

public class Task {
	
	private int taskId;
	private String taskName;
	private String description;
	private String priority;
	private String status;
	private int archived;
	
	public Task() {
		
	}
	
	public Task(String taskName, String description, String priority,
			String status) {
		super();
		this.taskName = taskName;
		this.description = description;
		this.priority = priority;
		this.status = status;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getArchived() {
		return archived;
	}

	public void setArchived(int archived) {
		this.archived = archived;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + taskId + ", taskName=" + taskName
				+ ", description=" + description + ", task_priority="
				+ priority + ", status=" + status + "]";
	}

}
