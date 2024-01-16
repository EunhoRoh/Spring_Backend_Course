package com.example.spring_project_test_24_01_11.repository;
//database 연결
//interface로 선언만 해줘도 다 구현해준다.

import com.example.spring_project_test_24_01_11.domain.Tbboard;
import org.springframework.data.jpa.repository.JpaRepository;
//데이터베이스 이름과 id값 전해주면됨

//Tbborad가 entity임
//JpaRepository는 이미 연동한 데이터베이스가 들어가있다.
public interface TbboardRepository extends JpaRepository<Tbboard, String> {
    /*
    TbboardRepository를 사용하기 위해,
    JpaRepository<Tbboard, String>에서
    Tbboard 라는 엔티티 클래스를 먼저 제공하고, Tbboard의 인덱스pk의 자료형을 선언해줍니다.

    기존에 이미 구현된 JPA 기능을 모두 사용 가능!!
    */
}
