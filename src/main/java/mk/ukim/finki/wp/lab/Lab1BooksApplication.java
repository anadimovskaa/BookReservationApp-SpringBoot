package mk.ukim.finki.wp.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication

public class Lab1BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab1BooksApplication.class, args);
    }

}
