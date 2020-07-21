package com.htc.todo.rest.webservices.restfulwebservice.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

	@Autowired
	private TodoHardcodeService todoHardcodeService;

	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodoByUsername(@PathVariable String username) {
		return todoHardcodeService.findAll();
	}
	
	@DeleteMapping("/users/{username}/todo/{id}")
	public Todo deleteTodoById(@PathVariable int id) {
		System.out.println("Xoa: "+id);
		return todoHardcodeService.deleteById(id);
	}

}
