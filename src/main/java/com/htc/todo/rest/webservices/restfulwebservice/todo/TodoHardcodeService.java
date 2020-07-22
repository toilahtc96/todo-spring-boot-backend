package com.htc.todo.rest.webservices.restfulwebservice.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class TodoHardcodeService {
	private static List<Todo> todos = new ArrayList<Todo>();

	private static int idCounter = 0;
	static {
		todos.add(new Todo(++idCounter, "htc", "Learn to Code", new Date(), false));
		todos.add(new Todo(++idCounter, "htc", "Learn to Angular", new Date(), true));
		todos.add(new Todo(++idCounter, "htc", "Learn to Spring", new Date(), false));
		todos.add(new Todo(++idCounter, "htc", "Learn to Design", new Date(), true));
		todos.add(new Todo(++idCounter, "htc", "Learn to ACC", new Date(), false));
		todos.add(new Todo(++idCounter, "htc", "Learn to AXAZ", new Date(), true));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(int id) {
		Todo todoDelete = getById(id);
		if (todoDelete == null) {
			return null;
		}
		todos.remove(todoDelete);
		return todoDelete;
	}

	public Todo getById(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

	public Todo save(Todo todo) {
		if (todo.getId() == -1) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

}
