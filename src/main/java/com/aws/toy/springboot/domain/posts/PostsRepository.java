package com.aws.toy.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// = Repository  , Entity (Posts) 와 함께 위치해야한다 ( Mybatis: Dao)
public  interface PostsRepository extends JpaRepository<Posts, Long> {  // <Entity클래스, PK타입>
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
