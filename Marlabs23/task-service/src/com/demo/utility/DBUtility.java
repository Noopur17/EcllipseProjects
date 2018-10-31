package com.demo.utility;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

import com.demo.domain.Task;

public class DBUtility {

	SessionFactory sessionFactory;

	/**
	 * To connect to Hibernate
	 */
	public DBUtility() {

		try {
			// creating configuration object
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");// populates the data of the
												// configuration file

			// creating seession factory object
			sessionFactory = cfg.buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To add new task
	 * @param task
	 */
	public void addTask(Task task) {
		
		try{

			// creating session object
			Session session = sessionFactory.openSession();
	
			// creating transaction object
			Transaction t = session.beginTransaction();
	
			session.save(task);
			t.commit();
			session.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * To archive a completed task
	 * @param taskId
	 */
	public void archiveTask(int taskId) {
		
		try{

			// creating session object
			Session session = sessionFactory.openSession();
	
			// creating transaction object
			Transaction t = session.beginTransaction();
			Task task = (Task) session.get(Task.class, taskId);
			
			task.setArchived(1);
			
			session.merge(task);
			
			t.commit();
			session.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * To change the task properties
	 * @param task
	 */
	public void updateTask(Task task) {
		
		try{

			// creating session object
			Session session = sessionFactory.openSession();
	
			// creating transaction object
			Transaction t = session.beginTransaction();
			
			session.merge(task);
			t.commit();
			session.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * To change the task status
	 * @param taskId
	 * @param status
	 */
	public void changeTaskStatus(int taskId, String status) {
		
		try{

			// creating session object
			Session session = sessionFactory.openSession();
	
			// creating transaction object
			Transaction t = session.beginTransaction();
			Task task = (Task) session.get(Task.class, taskId);
			
			task.setStatus(status);
			
			session.merge(task);
			
			t.commit();
			session.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public List<JSONObject> getAllTasks() {
		
		
		String hql = "FROM Task T WHERE T.archived = 0";
		Query query = sessionFactory.openSession().createQuery(hql);
		
		List<Task> list = query.list();
		
		List<JSONObject> jsonList = convertToJSON(list);
		
		return jsonList;

	}
	
	public List<JSONObject> convertToJSON(List<Task> inputList) {
		
		List<JSONObject> list = new ArrayList<JSONObject>();
		
		for(Task task : inputList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("taskId", task.getTaskId());
			jsonObject.put("taskName", task.getTaskName());
			jsonObject.put("description", task.getDescription());
			jsonObject.put("priority", task.getPriority());
			jsonObject.put("status", task.getStatus());
			jsonObject.put("archived", task.getArchived());
			
			list.add(jsonObject);
		}
		
		return list;
		
	}
	
	/**
	 * To get the task details
	 * @param taskId
	 * @return
	 */
	public JSONObject getTaskById(int taskId) {
		
		Task task =  (Task) sessionFactory.openSession().get(Task.class, taskId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("taskId", task.getTaskId());
		jsonObject.put("taskName", task.getTaskName());
		jsonObject.put("description", task.getDescription());
		jsonObject.put("priority", task.getPriority());
		jsonObject.put("status", task.getStatus());
		jsonObject.put("archived", task.getArchived());
		
		return jsonObject;
	}
	
	/**
	 * To get the task details
	 * @param taskId
	 * @return
	 */
	public Task getTaskToEditById(int taskId) {
		
		Task task =  (Task) sessionFactory.openSession().get(Task.class, taskId);
		
		return task;
	}
	
	/**
	 * Delete the task
	 * @param taskId
	 * @return
	 */
	public void deleteTask(int taskId) {
		
		Task task =  (Task) sessionFactory.openSession().get(Task.class, taskId);
		sessionFactory.openSession().delete(task);
		
	}
}
