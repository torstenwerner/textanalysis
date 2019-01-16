package com.example.textanalysis;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TextanalysisApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(TextanalysisApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final UnicodeCosineDistance cosineDistance = new UnicodeCosineDistance();
        final Double distance = cosineDistance.apply("Hallo schöne Welt!", "Tschüss Welt!");
        System.out.printf("cosine distance: %f%n", distance);
    }
}

