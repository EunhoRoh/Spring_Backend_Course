package com.example.spring_project_test_24_01_11.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

//entity는 service에서 db에 넘길때 잠깐 사용? 데이터 형태를 DTO 형태로 해서 넘기자.
// 다 dto 형식으로 controller, service, db에서 데이터 전달
//lombok => 유효성 검사?
//controller는 view단에서 받은 정보를 DTO로 만들고 그 DTO로 controller와 service에서 사용

public class TbboardDto {

    //생성자를 안 만들었는디...
    //static? 왜 static class를 만드는 거지?
    // json을 바로 DTo의 필드로 넣는게 신기하다.
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TbboardCreateDTO{
        //schema설정?
        @Schema(description = "title", example = "title")
        @NotNull
        @NotEmpty
        @Size(max = 100)
        private String title;

        @Schema(description = "content", example = "content")
        @NotNull
        @NotEmpty
        @Size(max=200)
        private String content;
    }

}
