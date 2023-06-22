package com.example.greeting;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class GreetingsController {

    List<String> greetings = new ArrayList<>();

    {
        greetings.addAll(List.of("Hello", "Howdy", "Bonjour", "Hola"));
    }


    @GetMapping("/greetings/{id}")
    public String getGreetingById(@PathVariable int id) {
        return greetings.get(id);
    }




    @DeleteMapping("/delete/{id}")
    public boolean deleteGreetingById(@PathVariable int id) {
        greetings.remove(id);
        return true;
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
