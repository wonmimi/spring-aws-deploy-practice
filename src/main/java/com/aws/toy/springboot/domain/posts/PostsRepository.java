package com.aws.toy.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// = Repository  , 엔티티 와 함께 위치해야한다 ( Mybatis: Dao)
public  interface PostsRepository extends JpaRepository<Posts, Long> {  // <Entity클래스, PK타입>

}
