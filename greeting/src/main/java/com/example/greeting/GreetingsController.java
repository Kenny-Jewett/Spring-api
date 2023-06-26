package com.example.greeting;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class GreetingsController {

    @Autowired
    GreetingsRepository greetingsRepository;

    @PostMapping("/greetings")
    public void addGreeting(@RequestBody Greeting greeting) {
        greetingsRepository.addGreeting(greeting);
    }

    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings() {
        return greetingsRepository.getAllGreetings();
    }

    @GetMapping("/greetings/{id}")
    public List<Greeting> getGreetingById(@PathVariable long id) {
        return greetingsRepository.getGreetingById(id);
    }

    @DeleteMapping("/greetings/{id}")
    public void deleteGreetingById(@PathVariable long id) {
        greetingsRepository.deleteGreetingById(id);
    }

    @PutMapping("/greetings/{id}")
    public void updateGreeting(@RequestBody Greeting newGreeting, @PathVariable long id) {
        newGreeting.getId(id);
        greetingsRepository.updateGreeting(newGreeting, id);
    }













//    @GetMapping("/greet")
//    public List<String> getGreetings() {
//        return greetings;
//    }
//
//    @GetMapping("/greeting/random")
//    public String getRandomGreeting() {
////        double randomNum = Math.random() * greetings.size();
////        int convertedInt = (int) randomNum;
//        Random random = new Random();
//        return greetings.get(random.nextInt(greetings.size()));
//    }


}
