package com.example.firstproject.controller;

// URL 연결 요청 (@GetMapping())과 동시에 자동으로 임포트


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 선언
public class FirstController {

    @GetMapping("/hi") // URL 요청 접수 // GET 쓰는이유 데이터가 url에 다표현해서 조회할떄, 페이지 반환시킬 /host :
    public String niceToMeetYou(Model model) { // (Model model)  모델 객체 가져오기, 메서드 수행
        // model 객체가 "홍팍" 값을 "username"에 연결해 웹 브라우저로 보냄
        model.addAttribute("username", "박준형"); // 모델 변수 등록
        return "greetings"; // greetings.mustache 파일 반환, 뷰 템플릿 페이지 반환
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "홍길동");
        return "goodbye";

    }
}
