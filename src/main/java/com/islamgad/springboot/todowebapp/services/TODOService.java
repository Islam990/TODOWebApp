package com.islamgad.springboot.todowebapp.services;

import com.islamgad.springboot.todowebapp.data.TODO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TODOService {

    private static List<TODO> todos = new ArrayList<>();
    private static int count = 0;

    static {
        todos.add(new TODO(++count, "Islam Gad", "Learn React JS", LocalDate.now().plusYears(1), false));
        todos.add(new TODO(++count, "Samir Filfil", "Learn Devops", LocalDate.now().plusYears(2), false));
    }

    public List<TODO> getTODOByName(String userName) {
        return todos;
    }

    public void addTodo(String name, String description, LocalDate targetDate, boolean IsDone) {
        todos.add(new TODO(++count, name, description, targetDate, IsDone));
    }

}
