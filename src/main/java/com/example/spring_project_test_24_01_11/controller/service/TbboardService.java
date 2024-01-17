package com.example.spring_project_test_24_01_11.controller.service;

import com.example.spring_project_test_24_01_11.domain.Tbboard;
import com.example.spring_project_test_24_01_11.dto.TbboardDto;
import com.example.spring_project_test_24_01_11.mapper.TbboardMapper;
import com.example.spring_project_test_24_01_11.repository.TbboardRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.SynchronizationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

//controlloer가 data service에 던져줌
//Service는 연산을 당담
// repository, db에 정보를 전달
@Service
public class TbboardService {
    //autowired는 생성자를 만들어서 직접 주입하는게 더 괜찮지만
    //객체생성?*
//    @Autowired
//    TbboardRepository tbboardRepository;
    private final TbboardRepository tbboardRepository;

    private final TbboardMapper tbboardMapper;
    //bean을 찾을 수 없다?

    public TbboardService(TbboardRepository tbboardRepository, TbboardMapper tbboardMapper) {
        this.tbboardRepository = tbboardRepository;

        this.tbboardMapper=tbboardMapper;
    }


    public int create(Map<String, Object> param){
        int result_int =0;

        System.out.println(3333);
        //param객체를 Map으로 만들어서 사용가능
        Tbboard tbboard = Tbboard.of(param.get("title")+"", param.get("content")+"");


        //jpa로 값 가져와서 저장
        tbboard = tbboardRepository.save(tbboard);
        //24.01.15 불러오기
        //tbboard id 불러오기 근데 하나만 불러오나?
        //객체 하나만 생성?
        if((tbboard.getId()+"").equals("null")){

        }else {
//           잘 만들면 200 return
            result_int=200;
        }
        return result_int;

    }
    
    //DTo로 controller에서 보낸 dto를 service에서 처리
    public int create1(TbboardDto.TbboardCreateDTO params){
        int result_int =0;
        Tbboard tbboard = Tbboard.of(params.getTitle(), params.getContent());
        tbboard=tbboardRepository.save(tbboard);

        if((tbboard.getId()+"").equals("null")){

        }else {
            result_int=200;
        }
        return result_int;
    }

    public int update1(TbboardDto.TbboardCreateDTO params){
        int result_int =0;
        Tbboard tbboard = Tbboard.of(params.getTitle(), params.getContent());

//        //param에서 id의 value값 가져오기
//        String id = param.get("id")+"";
////        //param에서 id의 value값 가져오기
//        String title = param.get("title")+"";
        //500은 서버 문제
        String title = params.getTitle();
        String content = params.getContent();

        //데이터베이스에서 id를 찾아서 tbbord1 객체에 저장
//        //Tbboard tbboard1= tbboardRepository.findByTitle(String title).orElseThrow(new Supplier<EntityNotFoundException>() {
//            @Override
//            public EntityNotFoundException get() {
//                return new EntityNotFoundException("id : ");
//            }
//        });

//        System.out.println("1.title : "+tbboard1.getTitle());
//
//        //title 바꾸기
//        tbboard1.setTitle(title);
//        //저장
//        tbboardRepository.save(tbboard1);
//
//
//        System.out.println("2.title : "+tbboard1.getTitle());
//
//        int result_int = 0;
//
//        //id를 못가져오면 아무것도 못한거다.
//        if((tbboard1.getId()+"").equals("null")){
//
//        }else {
//            result_int=200;
//        }
        return result_int;
    }

    public int update(Map<String, Object> param){
        //param에서 id의 value값 가져오기
        String id = param.get("id")+"";
        //param에서 id의 value값 가져오기
        String title = param.get("title")+"";

        //데이터베이스에서 id를 찾아서 tbbord1 객체에 저장
        Tbboard tbboard1= tbboardRepository.findById(id).orElseThrow(new Supplier<EntityNotFoundException>() {
            @Override
            public EntityNotFoundException get() {
                return new EntityNotFoundException("id : ");
            }
        });

        System.out.println("1.title : "+tbboard1.getTitle());

        //title 바꾸기
        tbboard1.setTitle(title);
        //저장
        tbboardRepository.save(tbboard1);


        System.out.println("2.title : "+tbboard1.getTitle());

        int result_int = 0;

        //id를 못가져오면 아무것도 못한거다.
        if((tbboard1.getId()+"").equals("null")){

        }else {
            result_int=200;
        }
        return result_int;
    }


    public Map<String, Object> select(Map<String, Object> param){
        //c23693ff-ac58-4a31-9f36-a15e6aa1553b

        Map<String, Object> map_tbboard = new HashMap<>();
        map_tbboard = tbboardMapper.get(param);

        return map_tbboard;
    }
}
