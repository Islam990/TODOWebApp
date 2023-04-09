package com.islamgad.springboot.todowebapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TODORepository extends JpaRepository<TODO, Integer> {
    List<TODO> getTodosByName(String name);
}
