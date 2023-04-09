package com.islamgad.springboot.todowebapp.controllers;

import com.islamgad.springboot.todowebapp.data.TODO;
import com.islamgad.springboot.todowebapp.data.TODORepository;
import com.islamgad.springboot.todowebapp.services.TODOService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TODOController {

    private final TODOService todoService;
    private final TODORepository todoRepository;

    public TODOController(TODOService todoService, TODORepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<TODO> todos = todoRepository.getTodosByName(WelcomeController.getUserLogging());
        model.addAttribute("todos", todos);
        return "list-todos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addTodoPage(ModelMap model) {
        TODO todo = new TODO(0,
                (String) model.get("name"),
                "",
                LocalDate.now(),
                false);
        model.put("todo", todo);
        return "add-todo";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(@Valid @ModelAttribute("todo") TODO todo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-todo";
        }

        todo.setName(WelcomeController.getUserLogging());
        todoRepository.save(todo);

        return "redirect:list-todos";
    }

    @RequestMapping("delete-page")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-page", method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id, ModelMap modelMap) {
        modelMap.addAttribute("todo", todoRepository.findById(id).get());
        return "add-todo";
    }

    @RequestMapping(value = "update-page", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid @ModelAttribute("todo") TODO todo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-todo";
        }

        todo.setName((String) model.get("name"));
        todoRepository.save(todo);
        return "redirect:list-todos";
    }
}
