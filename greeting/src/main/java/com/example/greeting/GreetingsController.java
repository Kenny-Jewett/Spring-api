package com.example.greeting;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class GreetingsController {

    @Autowired
    GreetingsRepository greetingsRepository;

    @PostMapping("/greetings")
    public void addGreeting(@RequestBody Greeting greeting) {
        greetingsRepository.save(greeting);
    }

    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings() {
        return greetingsRepository.findAll();
    }

    @GetMapping("/greetings/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable long id) {
        return greetingsRepository.findById(id);
    }

    @GetMapping("/greetings/country")
    public List<Greeting> getGreetingByCountry(@RequestParam String country) {
        return greetingsRepository.getGreetingsByOriginCountry(country);
    }

    @GetMapping("/greetings/random")
    public Greeting getRandomGreeting() {
        return greetingsRepository.getRandomGreeting();
    }


    @Transactional
    @DeleteMapping("/greeting/{id}")
    public String deleteGreetingById(@PathVariable long id) {
        if(greetingsRepository.existsById(id)) {
            greetingsRepository.deleteById(id);
            return "Greeting deleted";
        } else {
            return "No matching greeting found.";
        }
    }

//    @DeleteMapping("/greetings/{id}")
//    public void deleteGreetingById(@PathVariable long id) {
//        greetingsRepository.deleteGreetingById(id);
//    }

    @PutMapping("/greetings/{id}")
    public void updateGreeting(@RequestBody Greeting newGreeting, @PathVariable long id) {
        if(greetingsRepository.existsById(id)) {
            newGreeting.setId(id);
            greetingsRepository.save(newGreeting);
        } else {
            greetingsRepository.save(newGreeting);
        }

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
