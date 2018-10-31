package com.demo.controller;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.demo.domain.Task;
import com.demo.service.TaskService;

@Path("/tasks")
public class TaskController {

	TaskService taskService = new TaskService();
	
	@GET
	@Produces("application/json")
	public Response getAllTasks() {
		List<JSONObject> tasks = taskService.getAllTasks();
		
		String result = "" + tasks;
		
		return Response.status(200).entity(result).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@Path("{taskName}/{description}/{priority}/{status}")
	@POST
	@Produces("application/json")
	public Response insertTask(@PathParam("taskName") String taskName, 
			@PathParam("description") String description,
			@PathParam("priority") String priority,
			@PathParam("status") String status) {
		
		Task task = new Task(taskName, description, priority, status);
		
		taskService.addTask(task);
		
		List<JSONObject> tasks = taskService.getAllTasks();
		
		String result = "" + tasks;
		
		return Response.status(200).entity(result).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@Path("{taskId}")
	@GET
	@Produces("application/json")
	public Response getTask(@PathParam("taskId") int taskId) {
		
		JSONObject task = taskService.getTaskById(taskId);
		
		//List<JSONObject> tasks = taskService.getAllTasks();
		
		String result = "" + task;
		
		return Response.status(200).entity(result).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@Path("update/{taskId}/{taskName}/{description}/{priority}/{status}")
	@GET
	@Produces("application/json")
	public Response updateTask(@PathParam("taskId") int taskId,
			@PathParam("taskName") String taskName, 
			@PathParam("description") String description,
			@PathParam("priority") String priority,
			@PathParam("status") String status) throws ParseException {
		
		Task task = taskService.getTaskToEditById(taskId);
		task.setTaskName(taskName);
		task.setDescription(description);
		task.setPriority(priority);
		task.setStatus(status);
		
		taskService.updateTask(task);
		
		List<JSONObject> tasks = taskService.getAllTasks();
		
		String result = "" + tasks;
		
		return Response.status(200).entity(result).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@Path("delete/{taskId}")
	@GET
	@Produces("application/json")
	public Response deleteTask(@PathParam("taskId") int taskId) throws ParseException {
		
		taskService.archiveTask(taskId);
		
		List<JSONObject> tasks = taskService.getAllTasks();
		
		String result = "" + tasks;
		
		return Response.status(200).entity(result).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
}
