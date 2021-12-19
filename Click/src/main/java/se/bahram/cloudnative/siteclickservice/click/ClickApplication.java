package se.bahram.cloudnative.siteclickservice.click;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClickApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClickApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Service is Started.");
    }
}
