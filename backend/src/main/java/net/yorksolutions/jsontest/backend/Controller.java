package net.yorksolutions.jsontest.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Annotating as a rest controller
// gives capability to spring app to respond to web requests
@RestController
// gives a url sub-path to all requests that this controller will respond to
@RequestMapping("/api")
public class Controller {

    @Autowired // takes in an object already created (in this case automatically was created by @Repository annotation in the interface
    // and assigns to this variable toDoRepository for us.
    ToDoRepository toDoRepository;
    // specify end point tpo get to function that follows
    // specify that this will be used to respond to Get request type
    @GetMapping("/hello")
    String respond() {
        return "Hello Corey";
    }
    // request params will take from url
    // syntax is 'localhost:8080/api/echo?variable=value'
    @GetMapping("/echo")
    String echo(@RequestParam String stringToEcho) {
        return stringToEcho;
    }

    @GetMapping("/add")
    String add(@RequestParam String text) {
        toDoRepository.save(new ToDo(text));
        return "Success";
    }
}
