package com.aws.toy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
        public static void main(String[] args){
            SpringApplication.run(Application.class, args); // 내장 WAS 실행
        }
}
