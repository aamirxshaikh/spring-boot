package com.example.springboot.post;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class  PostConfiguration {
  @Bean("postCommandLineRunner")
  CommandLineRunner runner(PostClient postClient) {
    return args -> {
      System.out.println("Post size : " + postClient.getPosts().size());
      System.out.println("Post with ID 1 : " + postClient.getPost(1));
    };
  }
}
