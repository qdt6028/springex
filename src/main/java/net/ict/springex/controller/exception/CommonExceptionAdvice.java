package net.ict.springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

// 예외처리를 위한 Class
@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {
//
//    // 응답받은 Body 태그 안에서 작동해라
//    @ResponseBody
//    // 지정한 Exception 이 발생하면 발동하는 handler로 지정하는 Annotation
//    @ExceptionHandler(NumberFormatException.class)
//    public String exceptNumber(NumberFormatException numexcep){
//        log.error("=========================================");
//        log.error(numexcep.getMessage());
//        return "NUMBER FOTMAT EXCEPTION... :<";
//
//    }

    //예외 처리의 최상위 타입인 Exception 타입을 처리하도록 구성 exceptCommon(Exception exception)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptCommon(Exception excep) {
        log.error("=================최상위exception======================");
        log.error(excep.getMessage());

        StringBuffer buf = new StringBuffer("<ul>");
        buf.append("<li>" + excep.getMessage() + "</li>");
        Arrays.stream(excep.getStackTrace()).forEach(stackTraceElement -> {
            buf.append("<li>" + stackTraceElement + "</li>");
        });
        buf.append("</ul>");
        return buf.toString();

    }
    // 내가 원하는 page 가 없을때 내가 만든 exception page로   처리
    @ExceptionHandler(NoHandlerFoundException.class)

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "custom404";
    }

}
