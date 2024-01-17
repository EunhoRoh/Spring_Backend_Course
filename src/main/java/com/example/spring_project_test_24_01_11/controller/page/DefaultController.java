package com.example.spring_project_test_24_01_11.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//controller는 url 연결하는거

//똑같은거에 설정?
//앞에 적는 mapping, 반복되는거
@RequestMapping("")
//프론트페이지에서 가장 먼저 controllorer와 연결
// test 주소 왔을때

//페이지를 보여주는 컨트롤러
@Controller
public class DefaultController {
    
    //swager로 주소 바꾸기
    @GetMapping("/doc")
    public String getSwagger() {
        return "redirect:/swagger-ui/index.html";
    }

    //index 주소 혀용폭 넓히기
    @GetMapping({"", "/", "/index"})
    public String getIndex() {
        return "index";
    }

    // 그담에 오는 페이지들
    //어떤 url과 연결할 것인가
    @GetMapping({"dirTest/test"})
    //return 하는게 파일 명이다.
    public String getTest() {
        //리턴으로 정한 "test"를 파일명으로 갖는 test.html 을 templates 폴더 밑에서 찾아서 뿌려줌
        return "/testdir/test";//* 폴더명을 지정해주면 가기
    }

    @GetMapping({"/write"})
    public String getWrite() {
        return "write";
    }

//    tbcrew_title를 title로 받아서 받은 값 출력
    @GetMapping({"/params"})
    public String getParams(
            @RequestParam(value = "tbcrew_title", required = false) String tbcrew_title
            //,
            // HttpServletRequest request
    ) {
        System.out.println(tbcrew_title);
        return "params";
    }

    //컨트롤러는 직접 html로 싸준다.
    @GetMapping({"/create"})
    public String getCreate(
    ) {
        System.out.println("111111");
        return "create";
    }

    @GetMapping({"/wtest"})
    public String getWtest(){
        return  "wtest";
    }

    @PostMapping("/btest")
    public String btest(){
        return "btest";
    }

    //redirect는 다른 url를 내가 원하는 곳으로 바꿔줌
}

