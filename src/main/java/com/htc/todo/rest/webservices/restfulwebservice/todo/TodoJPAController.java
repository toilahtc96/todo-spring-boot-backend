package com.htc.todo.rest.webservices.restfulwebservice.todo;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJPAController {
	final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TodoHardcodeService todoHardcodeService;

	@Autowired
	private TodoJpaRepository todoJpaRepository;

	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodoByUsername(@PathVariable String username) {
		return todoJpaRepository.findByUsername(username);
	}

	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable long id) {
		System.out.println("Xoa: " + id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id) {
		return todoJpaRepository.findById(id).get();
//		return todoHardcodeService.getById(id);
	}

	// edit/update a Todo
	// Put users/{username}/todos/{id}
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id,
			@RequestBody Todo todo) {
		Todo todoUpdated = todoJpaRepository.save(todo);
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
	}

	// Create a new todo
	// Post /jpa/users/{username}/todos/

	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
		logger.info("add  "+ username);
		System.out.println("add  "+ username);
		todo.setUsername(username);
		Todo todoCreated = todoJpaRepository.save(todo);

//		build url for new Todo
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoCreated.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
