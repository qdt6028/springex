package net.ict.springex.mapper;

import org.apache.ibatis.annotations.Select;

//Mapper interface 활용 : Annotation 방식과 XML 방식이 있음.
//Mapper interface : MyBatis 를 통해서 수행해야 하는 기능을 mapper interface 로 작성한다.
        //1. Annotation 방식으로 작성하는 법
public interface TimeMapper {
    @Select("select now()")
    String getTime();
}
