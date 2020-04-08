package com.sangoh.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        // "Index"만 리턴해도 머스터치 스타터 덕분에 앞뒤로 경로가 붙는다.
        // 그리고 그렇게 전달된 mustache 파일은 view resolver가 처리해준다.
        // result: /src/main/resources/templates/index.mustache
        return "index";
    }
}
