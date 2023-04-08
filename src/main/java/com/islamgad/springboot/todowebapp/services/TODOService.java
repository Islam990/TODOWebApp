package com.islamgad.springboot.todowebapp.services;

import com.islamgad.springboot.todowebapp.data.TODO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TODOService {

    private static final List<TODO> todos = new ArrayList<>();
    private static int count = 0;

    static {
        todos.add(new TODO(++count, "Islam Gad", "Learn React JS", LocalDate.now().plusYears(1), false));
        todos.add(new TODO(++count, "Islam Gad", "Learn JavaFX Platform", LocalDate.now().plusYears(1), false));
        todos.add(new TODO(++count, "Samir", "Learn Devops", LocalDate.now().plusYears(2), false));
    }

    public List<TODO> getTODOByName(String userName) {
        return todos.stream().filter(todo -> todo.getName().equalsIgnoreCase(userName)).toList();
    }

    public void addTodo(String name, String description, LocalDate targetDate, boolean IsDone) {
        todos.add(new TODO(++count, name, description, targetDate, IsDone));
    }

    public void delete(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public TODO getTodoByID(int id) {
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .get();
    }

    public void updateTodo(TODO todo) {
        delete(todo.getId());
        todos.add(todo);
    }
}
