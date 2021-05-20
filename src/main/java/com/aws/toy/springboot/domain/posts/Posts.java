package com.aws.toy.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //  기본생성자 자동추가
@Entity // : 테이블과 링크될 클래스 , 클래스의 카멜케이스 이름을 언더스코어 네이밍 (camel_case) 으로 테이블 이름과 매칭
public class Posts {
    @Id // : 해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)// : 테이블의 컬럼
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // : 빌드 패턴 클래스 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
