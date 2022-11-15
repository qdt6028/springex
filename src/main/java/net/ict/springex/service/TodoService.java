package net.ict.springex.service;

import net.ict.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);
    // 1115
    List<TodoDTO> getAll();

    void deleteTodo(TodoDTO todoDTO);
//    void deleteTodo(Long num);

    TodoDTO getOne(Long num);

    void modify(TodoDTO todoDTO);
}
