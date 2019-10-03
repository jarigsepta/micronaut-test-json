package belajar.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.MediaType;

@Controller("/users")
public class User {
    @Get(produces = MediaType.APPLICATION_JSON)
    public String index() {
        return "[{'username':'jarigsepta'}]";
    }
}