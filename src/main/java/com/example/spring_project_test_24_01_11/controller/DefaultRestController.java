package com.example.spring_project_test_24_01_11.controller;

import com.example.spring_project_test_24_01_11.controller.service.TbboardService;
import com.example.spring_project_test_24_01_11.domain.Tbboard;
import com.example.spring_project_test_24_01_11.dto.TbboardDto;
import com.example.spring_project_test_24_01_11.repository.TbboardRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//페이지 이동하고 싶지 않으면 내가 물어본거에 답만 딱 해주고 싶을때
//restController 사용

@Tag(name="1.제목입니다.", description = "설명입니다.")
// api/test로 가는 것이다.
// request mapping과 getmapping의 차이점은?
@RequestMapping("/api")
//page 자체를 정보 자체로 주는거다.
// 페이지를 보여주는 것이 아니라, Rest 방식을 사용할때! 애플리케이션 처럼 그 page에서 업데이트 하는 방식
@RestController
public class DefaultRestController {

    //TbboardRepository를 연결해준다?
    // JpaRepository 기능을 사용하려고 선언해준건가? ㅇㅇ
//    public final TbboardRepository tbboardRepository;
    // DefaultRestController생성자는 tbboardRepository 초기화 해주려고?
//    public DefaultRestController(TbboardRepository tbboardRepository) {
//        this.tbboardRepository = tbboardRepository;
//    }


    //생성자
//    @Autowired -> 생성자 자동 생성
    //@inject -> 생성자 편하게 하려고
    //오토와이어드 쓸수도 있지만, 이렇게 주입하는 방식을 선호!!
    private final TbboardService tbboardService;

    public DefaultRestController(TbboardService tbboardService) {
        this.tbboardService = tbboardService;
    }

    @Operation(summary = "요약제목",
            description = "~~을 위한 컨트롤러 (~~만 접근 가능) <br />"
                    + "@param Tb~~Dto tb~~Dto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<Tb~~Dto\\> <br />"
                    + "@exception 중복 <br />"
    )

    @GetMapping({"/paramTest"})
    public Map<String, Object> paramTest(@RequestParam String aaa) {
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("name", "sprapi!!");
        a_map.put("phone", "010!!");
        return a_map;
    }


    @GetMapping({"/test"})
    //return 하는게 파일 명이다.
    public Map<String, Object> getTest() {
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("name", "sprapi!!");
        a_map.put("phone", "010!!");
        return a_map;
    }

//    requestBody -> 키, value 값으로 한꺼번에 받기
    //신기하네 json 형식으로 줬는데 DTO 필드에 넣을수 있는걸까 -> 그게 바로 스프링의 위엄
    @PostMapping({"/create1"})
//    @RequestParam 기능 확인
    //ajax로 데이터 전달
    public int createTbboard(@RequestBody TbboardDto.TbboardCreateDTO params
    /*
            @RequestParam(value = "title", required = true) String title
            ,@RequestParam(value = "content", required = true) String content
    */
    ) {
//        원하는 정보를 가공해서, 제공함.. but 해야하는 내용들을 service에 보냄
        System.out.println("api/ create1/ Data" + params);

        /*
        //tbboard instance 생성
        Tbboard tbboard = Tbboard.of("제목 예시", "내용 예시");
        //24.01.15. question
//        tbboardRepository는?
        //tbboard를 jpa Repository를 사용해서 저장해서 ... 흠.. 그냥 생성하면 자동으로 id하고 column들 생성되는데..
        // tbboardRepository를 사용해서 db에 저장했다는 건가..
        tbboard = tbboardRepository.save(tbboard);*/

        //넣어준 객체를 만들라고 tbboardService에 보낸다.
        //params에는 DTO 클래스가 들어가 있다.
        int result_int = tbboardService.create1(params);
        return result_int;
    }

    @PostMapping("itest")
    public int itest(
            @RequestBody Map<String, Object> map
    ){
        //try_num int로 만들기
        int try_num = Integer.parseInt(map.get("try_num") + "");
        System.out.println("try_num : " + try_num);
        //원하는 정보를 가공해서, 제공함..
        /*
        !해야 하는 내용들..
         */
        int result_int = 0;
        //system의 millisecond
        long millis = System.currentTimeMillis();
        //10의 자리로 만들어 주기
        result_int = (int) millis % 10;

        if(try_num == 17){
            result_int = 0;
        } else if(try_num < 17){
            if(result_int == 0){
                result_int = 9;
            }
        }

        return result_int;
    }

    @PostMapping({"/update1"})
//    @RequestParam 기능 확인
    public int updateTbboard(@RequestBody TbboardDto.TbboardCreateDTO params
    /*
            @RequestParam(value = "title", required = true) String title
            ,@RequestParam(value = "content", required = true) String content
    */
    ) {
//        원하는 정보를 가공해서, 제공함.. but 해야하는 내용들을 service에 보냄
        System.out.println("api/ update1/ Data" + params);
//            String title = "122334";
//            String content = "2244555";
//            System.out.println(title + "//" + content);

        //등록하기
//            Map<String, Object> a_map = new HashMap<>();
//            a_map.put("title", title);
//            a_map.put("content", content);
        /*
        //tbboard instance 생성
        Tbboard tbboard = Tbboard.of("제목 예시", "내용 예시");
        //24.01.15. question
//        tbboardRepository는?
        //tbboard를 jpa Repository를 사용해서 저장해서 ... 흠.. 그냥 생성하면 자동으로 id하고 column들 생성되는데..
        // tbboardRepository를 사용해서 db에 저장했다는 건가..
        tbboard = tbboardRepository.save(tbboard);*/

        //넣어준 객체를 만들라고 tbboardService에 보낸다.
        int result_int = tbboardService.update1(params);
        return result_int;
    }

//    update 기능
    @GetMapping({"/update"})
    public int updateTbboard(
    ) {
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("id", "fbc9664d-013c-4657-96fe-09604aa967ea");
        a_map.put("title", "updated");
        // 주어진 id로 update하게 만들기
        int result_int = tbboardService.update(a_map);
        return result_int;
    }

    @PostMapping("btest")
    public int btest(@RequestBody Map<String, Object> map){
        int result_int =0;
        return result_int;
    }
}
