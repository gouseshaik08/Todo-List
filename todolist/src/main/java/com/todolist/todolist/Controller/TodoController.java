package com.todolist.todolist.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todolist.todolist.Model.Todo;
import com.todolist.todolist.Service.TodoService;

import org.springframework.ui.Model;


@Controller
public class TodoController {
    @Autowired
    private TodoService service;
    
    @GetMapping({"/","/viewtodoList"})
    public String viewalltodoItems(Model model , @ModelAttribute("message") String message){
        model.addAttribute("list",service.getAlltodoItems());
        model.addAttribute("msg", message);
        return "ViewtodoList";
    }
    @PostMapping("/updatetodoStatus/{id}")
    public String updatetodoStatus(@PathVariable Long id,RedirectAttributes redirectAttributes){
        if(service.updateStatus(id)){
            redirectAttributes.addFlashAttribute("message","Update Success");
            return "redirect:/viewtodoList";
        }
        redirectAttributes.addFlashAttribute("message","Update Failure");
        return "redirect:/viewtodoList";
    }
    @GetMapping("/addtodoItem")
    public String addtodoItem(Model model){
        model.addAttribute("td", new Todo());
        return "Addtodoitem";
    }
    @PostMapping("/savetodoItem")
    public String savetodoItem(Todo td, RedirectAttributes redirectAttributes){
        if(service.saveOrUpdatetodoItem(td)){
            redirectAttributes.addFlashAttribute("message","Save Success"); 
            return "redirect:/viewtodoList";
        }
        redirectAttributes.addFlashAttribute("message","Save Failure");
        return "redirect:/addtodoList";
    }
    @GetMapping("/edittodoItem/{id}")
    public String edittodoItem(@PathVariable Long id , Model model){
        model.addAttribute("td", service.gettodoItemById(id));
        return "Edittodoitem";
    }
    @PostMapping("/editsavetodoItem")
    public String editsavetodoItem(Todo td,RedirectAttributes redirectAttributes){
        if(service.saveOrUpdatetodoItem(td)){
            redirectAttributes.addFlashAttribute("message","Save Success"); 
            return "redirect:/viewtodoList";
        }
        redirectAttributes.addFlashAttribute("message","Save Failure");
        return "redirect:/edittodoItem"+td.getId();
    }
    @GetMapping("/deletetodoItem/{id}")
    public String deletetodoItem(@PathVariable Long id,RedirectAttributes redirectAttributes){
        if(service.deletetodoItem(id)){
            redirectAttributes.addFlashAttribute("message","Delete Success");
            return "redirect:/viewtodoList";
        }
        redirectAttributes.addFlashAttribute("message","Delete Failure");
        return "redirect:/viewtodoList";
    }
}
