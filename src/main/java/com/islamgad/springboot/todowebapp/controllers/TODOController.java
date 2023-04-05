package com.islamgad.springboot.todowebapp.controllers;

import com.islamgad.springboot.todowebapp.data.TODO;
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

    public TODOController(TODOService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<TODO> todos = todoService.getTODOByName("Islam");
        model.put("todos", todos);
        return "list-todos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addTodoPage(ModelMap model) {
        TODO todo = new TODO(0,
                (String) model.get("name"),
                "",
                LocalDate.now().minusDays(5),
                false);
        model.put("todo", todo);
        return "add-todo";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid @ModelAttribute("todo") TODO todo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-todo";
        }

        todoService.addTodo((String) model.get("name"),
                todo.getDescription(),
                LocalDate.now().minusDays(5),
                false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-page")
    public String deleteTodo(@RequestParam int id) {
        todoService.delete(id);
        return "redirect:list-todos";
    }
}
