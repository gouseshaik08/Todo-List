package com.todolist.todolist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.todolist.Model.Todo;

@Repository
public interface ITodoRepo extends JpaRepository<Todo,Long>{

}

