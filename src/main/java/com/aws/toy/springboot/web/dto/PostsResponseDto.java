package com.aws.toy.springboot.web.dto;

import com.aws.toy.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    // 엔티티 필드중 일부만 사용하므로 생성자로 entity값을 받아서 처리
    public PostsResponseDto (Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
