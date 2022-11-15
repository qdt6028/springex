package net.ict.springex.mapper;

import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.TodoDTO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    void insert(TodoVO todoVO);
    //1115 list 구현
    List<TodoVO> selectAll();

    void delete(TodoVO todoVO);
//    void delete(Long num);

    TodoVO selectOne(Long num);

    void update(TodoVO todoVO);
}
