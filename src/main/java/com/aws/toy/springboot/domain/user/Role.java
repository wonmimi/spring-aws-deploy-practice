package com.aws.toy.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
    사용자 권한 관리 Role
 */
@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
