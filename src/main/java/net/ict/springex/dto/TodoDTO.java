package net.ict.springex.dto;
/* 객체 자료형은 파라미터로 처리하기 위해서는 반드시 객체로 생성되고,
 setter 메소드를 이용해서 처리해야 한다.*/

import lombok.*;

import java.time.LocalDate;
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private long num;
    private String content;
    private LocalDate dueDate;
    private boolean finished;
    // 작성자를 의미하는 파라메터 추가.
    private String writer;

}
