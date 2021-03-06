package io.github.melokissy.todo.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.melokissy.todo.model.Todo;
import io.github.melokissy.todo.repository.TodoRepository;

@RestController
@RequestMapping("/api/todos")
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("https://melokissy.github.io")
public class TodoController {
	
	@Autowired
	private TodoRepository repository; 
	
	@PostMapping
	public Todo save(@RequestBody Todo todo) {
		return repository.save(todo); 
	}
	
	@GetMapping
	public List<Todo> getAll(){
		return repository.findAll();
	}
	
	// url/api/todos/id
	@GetMapping("{id}")
	public Todo getById(@PathVariable Long id) {
		return repository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	// api/todos/id/done
	@PatchMapping("{id}/done") //atualiza parcialmente
	public Todo markAsDone(@PathVariable Long id) {
		return repository.findById(id).map(todo -> {
			todo.setDone(true);
			todo.setDoneDate(LocalDateTime.now());
			repository.save(todo); //atualiza os dados do todo 
			return todo;
		}).orElse(null); 
	}
}
