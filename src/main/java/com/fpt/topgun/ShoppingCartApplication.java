package com.fpt.topgun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingCartApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(ShoppingCartApplication.class, args);
  }
  
}
