package net.ict.springex.dto;
/* 객체 자료형은 파라미터로 처리하기 위해서는 반드시 객체로 생성되고,
 setter 메소드를 이용해서 처리해야 한다.*/

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 1115 : DTO 검증을 위해서 Annotation 작업
public class TodoDTO {
    private long num;
    @NotEmpty // NotNull 과 같은 의미
    private String content;
    @Future // 현재의 날짜 보다 미래인 날짜만 받을 수 있도록
    private LocalDate dueDate;
    private boolean finished;
    // 작성자를 의미하는 파라메터 추가.
    @NotEmpty // NotNull
    private String writer;

}
