package com.example.spring_project_test_24_01_11.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

//공통된 column을 생략하고 싶어서
// 추상클래스 -> 추상화 구현화 문제, 다중구현? polynomial?
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditingFields {
    //id 만들자
    @Id
    private String id;

    @Column(nullable = false)
    private String deleted;

//    대부분쓰는 포맷
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt; //생성일시

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    protected LocalDateTime modifiedAt; //수정일시

    //uuid 바꿔주기
    @PrePersist
    public  void onPrePersist(){
        String uuid= UUID.randomUUID().toString().replace("-","");
        this.id= uuid.substring(0,16);
        this.deleted="N";
    }
}
