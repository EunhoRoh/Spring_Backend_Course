package com.example.spring_project_test_24_01_11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//spring 프로젝트 파일인걸 명시해 주는 anno
// entity가 뭐지?
// EnableJpaAuditing ?
//
@EnableJpaAuditing
@SpringBootApplication
public class SpringProjectTest240111Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectTest240111Application.class, args);
    }

}
