package net.ict.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// 데이터베이스를 처리하는 TodoMapper 와 DTO와 VO 변환을 처리하는 ModelMapper 주입
@Service
@Log4j2
@RequiredArgsConstructor // 의존성 주입이 필요한 객체의 타입을 final로 고정 후 생성자를 주입받아 생성자를 생성하는 방식
public class TodoServiceImpl implements TodoService{

    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);
        log.info(vo);
        todoMapper.insert(vo);
    }
    // 1115
    @Override
    public List<TodoDTO> getAll() {
        //stream() : builder() 랑 비슷
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
            // vo 는 ResultSet 으로 넘어올때 1row 씩 넘어왔기 때문에
            // 각각의 vo객체들을 List로 묶어서 한 테이블 처럼 만들어 줘야 한다.
                    // 1. modelMapper를 통해서 TodoDTO 로 바뀐다.
                .map(vo->modelMapper.map(vo, TodoDTO.class))
                    // 2. DTO로 바뀐 각각 1 row 당 객체들을 list 로 묶어준다.
                .collect(Collectors.toList());
        return dtoList;
    }

//    @Override
//    public void deleteTodo(Long num) {
//        todoMapper.delete(num);
//    }

    @Override
    public void deleteTodo(TodoDTO todoDTO) {
        TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);
        log.info(vo);
        todoMapper.delete(vo);
    }

    @Override
    public TodoDTO getOne(Long num) {
        TodoVO vo = todoMapper.selectOne(num);
        TodoDTO todoDTO = modelMapper.map(vo, TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO vo = modelMapper.map(todoDTO,TodoVO.class);
        todoMapper.update(vo);
        log.info(vo);
    }

}
