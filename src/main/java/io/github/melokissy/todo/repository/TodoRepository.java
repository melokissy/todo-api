package io.github.melokissy.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.melokissy.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
