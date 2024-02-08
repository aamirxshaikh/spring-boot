package com.example.springboot.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class  PostConfiguration {
  private static final Logger LOGGER = LoggerFactory.getLogger(PostConfiguration.class);

  @Bean("postCommandLineRunner")
  CommandLineRunner runner(PostClient postClient) {
    return args -> {
      LOGGER.info("Post size : {}", postClient.getPosts().size());
      LOGGER.info("Post with ID 1 : {}", postClient.getPost(1));
    };
  }
}
