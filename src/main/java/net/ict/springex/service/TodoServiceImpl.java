package net.ict.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
