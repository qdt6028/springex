package net.ict.springex.controller;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Model 속성들에 대한 껍데기.
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

// 내가 컨트롤러다 하는 annotation . 이 annotation 이 sevlet-context.xml 에 component-scan 으로 읽혀서
// web.xml 에 appServlet 으로 읽혀서 servlet-context 에 view 설정한 bean에 의해서 view로 이동하게 된다
@Controller
@Log4j2
public class SampleController {
//get 방식으로 들어오는 요청을 처리하기 위한 annotation
    // 뷰 리졸버에서 GetMapping 이름으로 이동할 view 주소를 만들어 주기 때문에
    // view 로 이동하기 위한 jsp 파일 이름은 일치해야 한다.
    @GetMapping("/hello")
    public void hello(){
        log.info("혼돈의 서막이 시작된드아ㅏㅏㅏㅏㅏ.......");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age){
        log.info("ex1 ..... ");
        log.info("name : " + name);
        log.info("age : " + age);
    }
    // parameter 값이 안넘어 올 경우를 위해 각각 default 값을 정해주는 것
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "oh...") String name,
                    @RequestParam(name = "age", defaultValue = "32") int age) {
        log.info("ex2.....:< ");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate){
        log.info("ex3....... 언제까지.... ");
        log.info("dueDate : " + dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model){
        log.info("Model info.... :< ");
        model.addAttribute("message","Helloooooooooooo");
        log.info("Model : " + model);
    }

    @GetMapping("/ex5")
    // model에 dto를 담겠다 ( 파라메터로 처리함 )
    public void ex5(TodoDTO todoDTO, Model model){
        log.info("TodoDTO info.....XD");
        log.info(todoDTO);
        /*결과값 console 출력
        * TodoDTO(num=0, content=null, dueDate=null, finished=false, writer=null)
        */
    }

    @GetMapping("/ex6")
    public String ex6(RedirectAttributes ra){
        // ra에 값을 담기
        ra.addAttribute("name","denise");
        // ra에 일회용 값을 담기 ( 새로고침하면 사라짐. )
        ra.addFlashAttribute("result","hello");
        // ex7로 redirect
        return "ex/ex7";
    }
    // ex7.jsp view 페이지로 이동할수 있게 하는 ex7
    @GetMapping("/ex7")
    public void ex7(){}


    // numberFomatException 을 위한 ex8
    @GetMapping("/ex8")
    public void ex8(String p1, int p2){
        log.info("p1 : " + p1);
        log.info("p2 : " + p2);
    }



}
