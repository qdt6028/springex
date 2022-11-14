package net.ict.springex.mapper;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.mapper.TimeMapper;
import net.ict.springex.mapper.TimeMapper2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")

public class TimeMapperTest {
//    // Autowired에 required 속성을 false 로 주면 의존 주입이 되지 않더라도 Exception 이 일어나지 않음.
//    @Autowired(required = false)
//    private TimeMapper timemapper;
//    @Test
//    public void testGetTime() throws Exception{
//        log.info(timemapper.getTime());
//    }
    @Autowired(required = false)
    private TimeMapper2 timeMapper2;
    @Test
    public void testGetNow(){
        log.info(timeMapper2.getNow());
        //System.out.println(timeMapper2.getNow());
    }
}
