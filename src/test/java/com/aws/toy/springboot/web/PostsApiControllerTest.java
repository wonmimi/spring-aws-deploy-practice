package com.aws.toy.springboot.web;

import com.aws.toy.springboot.domain.posts.Posts;
import com.aws.toy.springboot.domain.posts.PostsRepository;
import com.aws.toy.springboot.web.dto.PostsSaveRequestsDto;
import com.aws.toy.springboot.web.dto.PostsUpdateRequestsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void Posts_등록된다() throws Exception{
        //given
        String title = "title";
        String content = "content";
        PostsSaveRequestsDto requestsDto = PostsSaveRequestsDto.builder()
                .title(title).content(content).author("author")
                .build();
        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestsDto, Long.class);
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestsDto)))
                .andExpect(status().isOk());



        //then
        /*
        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody())
                .isGreaterThan(0L);
         */

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    @WithMockUser(roles = "USER")
    public void Posts_수정된다() throws Exception{
        //given
        Posts savePosts = postsRepository.save(Posts.builder()
        .title("title").content("content").author("author").build());

        Long updateId = savePosts.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";

        PostsUpdateRequestsDto requestsDto = PostsUpdateRequestsDto.builder()
                .title(expectedTitle).content(expectedContent).build();

        String url = "http://localhost:" + port + "/api/v1/posts/"+ updateId;
        HttpEntity<PostsUpdateRequestsDto> requestEntity  = new HttpEntity<>(requestsDto);

        // when
//        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,
//                requestEntity, Long.class);
        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestsDto)))
                .andExpect(status().isOk());

        //then
        /*
        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        */

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);

    }

}
