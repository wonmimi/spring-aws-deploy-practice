package com.aws.toy.springboot.service.posts;

import com.aws.toy.springboot.domain.posts.Posts;
import com.aws.toy.springboot.domain.posts.PostsRepository;
import com.aws.toy.springboot.web.dto.PostsResponseDto;
import com.aws.toy.springboot.web.dto.PostsSaveRequestsDto;
import com.aws.toy.springboot.web.dto.PostsUpdateRequestsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestsDto requestsDto) {
        return postsRepository.save(requestsDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestsDto requestsDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));
        posts.update(requestsDto.getTitle(), requestsDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));

        return new PostsResponseDto(entity);
    }
}
