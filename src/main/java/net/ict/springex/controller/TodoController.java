package net.ict.springex.controller;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/todo")
public class TodoController {
//     이 메소드의 경로는 todolist 임
    @RequestMapping("/list")
    public void list(Model model){
        log.info("todo list :>");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register(){
        log.info("todo register :< ");
    }
//    @PostMapping("/register")
//    public void registerPost(){
//        log.info("Post 방식의 todoregister :< ");
//    }

    //1114 수업 : form 에서 넘어오는 값 받는 post방식 register.
    //'todoregister' 요청명을 post 방식으로 TodoDTO mapping 하기
    @PostMapping("/register")
    public String registerPost(TodoDTO todoDTO, RedirectAttributes ra){
        log.info(todoDTO);
        //ra.addAttribute(todoDTO);
        return "redirect:/todo/list";
    }

//    @PostMapping("/register")
//    public void registerPost1(TodoDTO todoDTO, Model model) {
//        log.info("TodoDTO를 모델에 담는다 :>");
//        log.info(todoDTO);
//    }
}
