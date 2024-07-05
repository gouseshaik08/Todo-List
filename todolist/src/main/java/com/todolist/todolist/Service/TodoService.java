package com.todolist.todolist.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolist.Model.Todo;
import com.todolist.todolist.Repository.ITodoRepo;

@Service
public class TodoService {
    
    @Autowired
    ITodoRepo repo;

    public List<Todo> getAlltodoItems(){
        ArrayList<Todo> todolist = new ArrayList<>();
        repo.findAll().forEach(todo -> todolist.add(todo));
        return todolist;
    }
    
    public Todo gettodoItemById(Long id){
        return repo.findById(id).get();
    }
    public boolean updateStatus(Long id){
        Todo td = gettodoItemById(id);
        td.setStatus("Completed");
        return saveOrUpdatetodoItem(td);
    }
    public boolean saveOrUpdatetodoItem(Todo td){
        Todo updatedobj = repo.save(td);
        if(gettodoItemById(updatedobj.getId()) != null){
            return true;
        }
        return false;
    }
    public boolean deletetodoItem(Long id){
        repo.deleteById(id);
        if(repo.findById(id).isEmpty()){
            return true;
        }
        return false;
    }
}

