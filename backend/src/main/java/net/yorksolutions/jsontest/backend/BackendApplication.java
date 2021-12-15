package net.yorksolutions.jsontest.backend;
// package is a property of this class and spring boot can now query this whole package
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// sets the package for where spring is going to look for all our resources
// will find automatically for us because we used this annotation at this level.
@SpringBootApplication
public class BackendApplication {
    // in our main we call spring application run on our application class, and pass in any args we need
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
