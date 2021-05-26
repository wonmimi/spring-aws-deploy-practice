package com.aws.toy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing // => SpringBootApplication 과 분리 하므로 주석.
@SpringBootApplication
public class Application {
        public static void main(String[] args){
            SpringApplication.run(Application.class, args); // 내장 WAS 실행
        }
}
