package com.sangoh.book.springboot.web;

import com.sangoh.book.springboot.service.posts.PostsService;
import com.sangoh.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("posts", postsService.findAllDesc());

        // "Index"만 리턴해도 머스터치 스타터 덕분에 앞뒤로 경로가 붙는다.
        // 그리고 그렇게 전달된 mustache 파일은 view resolver가 처리해준다.
        // result: /src/main/resources/templates/index.mustache
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}