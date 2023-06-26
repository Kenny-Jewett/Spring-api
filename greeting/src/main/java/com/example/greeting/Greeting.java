package com.example.greeting;

import java.time.LocalDate;
import java.util.Random;

public class Greeting {
    private long id = new Random().nextLong();
    private String createdBy;
    private String greeting;
    private String originCountry;
    private LocalDate dateCreated = LocalDate.now();

    public Greeting() {}

    public Greeting(long id, String createdBy, String greeting, String originCountry, LocalDate dateCreated) {
        this.id = id;
        this.createdBy = createdBy;
        this.greeting = greeting;
        this.originCountry = originCountry;
        this.dateCreated = dateCreated;
    }

    public long getId(long id) {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
