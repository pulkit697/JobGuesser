package dev.pulkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobPredictor {
    public static void main(String[] args) {
        run(args);
    }

    private static void run(String[] args) {
        SpringApplication.run(JobPredictor.class, args);
    }
}
