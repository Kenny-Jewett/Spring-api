package com.example.greeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface GreetingsRepository extends JpaRepository<Greeting, Long> {


    List<Greeting> getGreetingsByOriginCountry(String country);
    //OPERATION>ENTITY>BY>ATTRIBUTE


    @Query(value="SELECT * FROM greetings.greeting ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Greeting getRandomGreeting();


    //Creating data
//
//    public void addGreeting(Greeting greeting) {
//        greetings.add(greeting);
//    }
//
//    //Reading data / Return all greetings
//    public List<Greeting> getAllGreetings() {
//        return greetings;
//    }
//
//    public List<Greeting> getGreetingById(long id) {
//        return this.greetings.stream()
//                .filter(s -> s.getId(id) == id)
//                .collect(Collectors.toList());
//    }
//
//    public void deleteGreetingById(long id) {
//         List<Greeting> greeting = this.greetings.stream()
//                 .filter(s -> s.getId(id) != id)
//                 .collect(Collectors.toList());
//         greetings = greeting;
//    }
//
//    public void updateGreeting(Greeting newGreeting, long id) {
//        for (int i = 0; i < greetings.size(); i++) {
//            if(greetings.get(i).getId(id) == id) {
//                greetings.set(i, newGreeting);
//                return;
//            }
//        }
//    }


}
