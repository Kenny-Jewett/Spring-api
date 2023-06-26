package com.example.greeting;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GreetingsRepository {

    private List<Greeting> greetings = new ArrayList<>();

    //Creating data
    public void addGreeting(Greeting greeting) {
        greetings.add(greeting);
    }

    //Reading data / Return all greetings
    public List<Greeting> getAllGreetings() {
        return greetings;
    }

    public List<Greeting> getGreetingById(long id) {
        return this.greetings.stream()
                .filter(s -> s.getId(id) == id)
                .collect(Collectors.toList());
    }

    public void deleteGreetingById(long id) {
         List<Greeting> greeting = this.greetings.stream()
                 .filter(s -> s.getId(id) != id)
                 .collect(Collectors.toList());
         greetings = greeting;
    }

    public void updateGreeting(Greeting newGreeting, long id) {
        for (int i = 0; i < greetings.size(); i++) {
            if(greetings.get(i).getId(id) == id) {
                greetings.set(i, newGreeting);
                return;
            }
        }
    }


}
