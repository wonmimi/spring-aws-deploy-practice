package com.aws.toy.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA entity 클래스가 이 클래스를 상속할 경우 저장시간 관련 필드들도 칼럼으로 인식 된다
@EntityListeners(AuditingEntityListener.class) // 클래스에 Auditing 기능 포함
public class BaseTimeEntity {

    @CreatedDate // 엔티티 생성되어 저장될때 시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate   // 엔티티의 값을 변경할때 자동저장
    private LocalDateTime modifiedDate;

}
