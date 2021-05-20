package com.aws.toy.springboot.web;

import com.aws.toy.springboot.service.posts.PostsService;
import com.aws.toy.springboot.web.dto.PostsUpdateRequestsDto;
import com.aws.toy.springboot.web.dto.PostsResponseDto;
import com.aws.toy.springboot.web.dto.PostsSaveRequestsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    // 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestsDto requestsDto){
        return postsService.save(requestsDto);
    }

    //수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable long id, @RequestBody PostsUpdateRequestsDto requestsDto){
        return postsService.update(id, requestsDto);
    }

    //조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }
}
