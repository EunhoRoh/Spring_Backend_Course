package com.example.spring_project_test_24_01_11.mapper;
//Mybatis쓰려고
//Mybatis -> repository랑 똑같은거
//이게 My batis야
import java.util.Map;

public interface TbboardMapper {
    //get으로 xml에서 mybatis 호출
    Map<String, Object> get(Map<String, Object> param);
}
