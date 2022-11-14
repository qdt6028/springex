package net.ict.springex.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {

    private long num;
    private String content;
    private LocalDate dueDate;
    private boolean finished;
    private String writer;
    
}
