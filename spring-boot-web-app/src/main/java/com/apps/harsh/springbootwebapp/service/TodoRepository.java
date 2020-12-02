package com.apps.harsh.springbootwebapp.service;

import java.util.List;

import com.apps.harsh.springbootwebapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Integer>{
    List<Todo> findByUser(String user);

    //service.retrieveTodos(name)

    //service.deleteTodo(id);
    //service.retrieveTodo(id)
    //service.updateTodo(todo)
    //service.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(),false);
}