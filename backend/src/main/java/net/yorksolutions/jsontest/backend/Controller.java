package net.yorksolutions.jsontest.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

// Annotating as a rest controller
// gives capability to spring app to respond to web requests
// REST specifically uses JSON to communicate -
// if we specify a property as JSON property in model then can read and display
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
    @GetMapping("/echo/{echo}")
    Response echo(@PathVariable String echo) {
        Random rand = new Random();
        int id = rand.nextInt(100);
        Response myEcho = new Response(id, echo);
        return myEcho;
    }

    @GetMapping("/add")
    String add(@RequestParam String text) {
        toDoRepository.save(new ToDo(text));
        return "You have added an item";
    }

    @GetMapping("/all")
    Iterable<ToDo> getAll() {
        // Crud repository defines this findALl() function for us -
        // gives list of table and returns as an iterable,
        // REST controller then uses the @json annotation to determine
        // what it should convert to json and return for browser to read
        //JSON property is only required when we return and send to browser - it's what the browser will see
        return toDoRepository.findAll();
    }

    @GetMapping("/getById")
    ToDo getById(Long id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (optionalToDo.isPresent()) {
            // .get() returns the actual thing not the optional thing
            return optionalToDo.get();
        } else {
            System.out.println("id not found");
            return new ToDo();
        }
    }
    // get mapping when it returns converts our return to json so a map or string or whatever
    @GetMapping("/headers")
    // map is a list of key value pairs, can be different types but for http requests can all be strings
    Map<String, String> header(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @GetMapping("/todo/{id}")
    ToDo todoById(@PathVariable Long id) {
        return toDoRepository.findById(id).orElse(new ToDo());
    }

    @GetMapping("/ip")
    Object getClientIPAddress(HttpServletRequest request) {
        String ip = HttpUtils.getRequestIP(request);
        return "Client IP Address:" + ip;
    }

    @GetMapping("/datetime")
    DateTimeModel displayDateTime() {
        Date fullDate = new Date();
        String time = fullDate.getHours() + ":" + fullDate.getMinutes() + ":" + fullDate.getSeconds();
        String date = fullDate.toGMTString();

        return new DateTimeModel(time, date);
    }
}
