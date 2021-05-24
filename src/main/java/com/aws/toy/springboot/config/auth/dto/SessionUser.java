package com.aws.toy.springboot.config.auth.dto;

import com.aws.toy.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;
/*
    인증된 사용자 정보 저장 DTO 클래스
    (직렬화 기능을 가졌기 때문에 User 사용 아닌 별도로 생성)
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
