package com.example.spring_project_test_24_01_11.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//게시판 만들자
//알아서 get 기능 제공
// 각 테이블의 컬럼에 접근하기 위해 설정
@Getter
//우리가 사용하는 toString
// 테이블 상세 내용 출력
@ToString(callSuper = true)
//table을 만들거야.
//테이블 인덱스 등 세부 내용 설정을 위한 부분
@Table(indexes = {@Index(columnList = "title")})
//중요한 순서대로 annotation 적음
//jpa repository를 사용하려면 entity 클래스를 사용해야한다.
@Entity
public class Tbboard extends AuditingFields{
//    pk 만들기 -> my sql에 대신 만들어줌
// PK로 사용될 것을 정하는 코드
//    @Id
    //값 생성해주는거
    //PK를 자동생성하기 위한 방법 정하기
    //UUID ?
//    @GeneratedValue(strategy = GenerationType.UUID) //자바에서 쓰는 unique id
    // 인덱스
//    private  String id;

    @Setter @Column(nullable = false)
    private  String title;// 제목
    @Setter @Column(nullable = false, length = 10000)
    private  String content; //본문


    //생성자 못쓰게 하기 위해 protected 사용!
    protected Tbboard(){}

    //생성자 못쓰게 하기 위해 private로 사용! => 밑에 of로만 생성하도록 유도
    private Tbboard(String title, String content) {
        this.title = title;
        this.content = content;
    }
    //그냥 파라미터 갯수 맞추려고 이렇게 선언함
    public static Tbboard of(String title, String content) {
        return new Tbboard(title, content);
    }

    public static Tbboard of(String title) {
        return new Tbboard(title, "");
    }


}

