package net.ict.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/todo")
@RequiredArgsConstructor    // 생성자 주입
public class TodoController {

    private final TodoService todoService;

    //     이 메소드의 경로는 todolist 임
    @RequestMapping("/list")
    public void list(Model model) {
        log.info("todo list :>");
        //1115 : todoServiceImpl 에서 getAll()로 각각 vo 객체들이 list 로 담겨 있기 때문에 model에 set 을 해준다.
        model.addAttribute("dtoList", todoService.getAll());
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register() {
        log.info("todo register :< ");
    }

    //1114 수업 : form 에서 넘어오는 값 받는 post방식 register.
    //'todoregister' 요청명을 post 방식으로 TodoDTO mapping 하기
    @PostMapping("/register")
    // 1115 : TodoDTO가 검증 대상임을 알려주는 Annotation 붙이기
    //          BindingResult Type 추가 : ????
    public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes ra) {
        log.info(todoDTO);
        // 바인딩 객체에 error 가 있으면
        if (bindingResult.hasErrors()) {
            // hasError 에서 로그에러를 뿌릴것이며
            log.error("error .... X< ");
            // 발생한 에러를 일회성으로 담아서 보여줄 것이고,
            ra.addFlashAttribute("errors", bindingResult.getAllErrors());
            // 다시 todolist 를 작성하는 페이지로 이동시킬 것이다.
            return "redirect:/todo/register";
        }
        // 1115 : 실제 insert 기능을 하는 service 객체를 불러와서 검증이 끝난 DTO 를 주입해 준다.
        todoService.register(todoDTO);
        return "redirect:/todo/list";
    }

//    @RequestMapping("/delete")
//    public String deletePost(Long num) {
//        todoService.deleteTodo(num);
//        return "redirect:/todo/list";
//    }
    @RequestMapping("/delete")
    public String deletePost(TodoDTO todoDTO) {
        log.info(todoDTO);
        todoService.deleteTodo(todoDTO);
        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public void readPost(Long num, Model model) {
        TodoDTO todoDTO = todoService.getOne(num);
        model.addAttribute("dtos", todoDTO);
    }

    @PostMapping("/modify")
    public String modifyPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes ra) {
        // 바인딩 객체에 error 가 있으면
        if (bindingResult.hasErrors()) {
            // hasError 에서 로그에러를 뿌릴것이며
            log.error("error .... X< ");
            // 발생한 에러를 일회성으로 담아서 보여줄 것이고, 수정하려던 페이지의 num 값이 다시 저장되어야 하니까 저장한 상태로
            ra.addFlashAttribute("errors", bindingResult.getAllErrors());
            ra.addAttribute("num",todoDTO.getNum());
            // 다시 수정하는 페이지로 이동시킬 것이다.
            return "redirect:/todo/modify";
        }
        todoService.modify(todoDTO);
        return "redirect:/todo/list";
    }



}
