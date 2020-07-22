package com.htc.todo.rest.webservices.restfulwebservice.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable int id) {
		System.out.println("Xoa: " + id);
		Todo todo = todoHardcodeService.deleteById(id);
		if (todo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable int id) {
		return todoHardcodeService.getById(id);
	}

	// edit/update a Todo
	// Put users/{username}/todos/{id}
	@PutMapping("users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id,
			@RequestBody Todo todo) {
		Todo todoUpdated = todoHardcodeService.save(todo);
		return  new ResponseEntity<Todo>(todo,HttpStatus.OK);
	}

	// Create a new todo
	// Post /users/{username}/todos/
}
