package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages={"org.example","dao"})
public class FoodOrderingApplication { public static void main(String[] args){ SpringApplication.run(FoodOrderingApplication.class,args); } }
