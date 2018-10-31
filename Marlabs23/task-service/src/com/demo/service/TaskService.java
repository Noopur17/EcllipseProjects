package com.demo.service;

import java.text.ParseException;
import java.util.List;

import org.json.JSONObject;

import com.demo.domain.Task;
import com.demo.utility.DBUtility;

public class TaskService {
	
	private DBUtility dbUtility;

	public TaskService() {

		dbUtility = new DBUtility();

	}

	public void addTask(Task task) {

		try {


			task.setArchived(0);
/*
			Date dt = new Date();
			SimpleDateFormat sdf =
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
*/
			//task.setStartTime(currentTime);
			//task.setEndTime(currentTime);
			
			dbUtility.addTask(task);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void archiveTask(int taskId) {

		try {
			dbUtility.archiveTask(taskId);	

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void updateTask(Task task) throws ParseException {

		try {

			dbUtility.updateTask(task);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void changeTaskStatus(int taskId, String status)
			throws ParseException {

		try {

			dbUtility.changeTaskStatus(taskId, status);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<JSONObject> getAllTasks() {

		List<JSONObject> tasks = null;

		try {
			tasks = dbUtility.getAllTasks();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tasks;

	}

	public JSONObject getTaskById(int taskId) {

		JSONObject jsonObject = null;

		try {
			jsonObject = dbUtility.getTaskById(taskId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;

	}
	
	public Task getTaskToEditById(int taskId) {

		Task task = null;

		try {
			task = dbUtility.getTaskToEditById(taskId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return task;

	}
	
}
