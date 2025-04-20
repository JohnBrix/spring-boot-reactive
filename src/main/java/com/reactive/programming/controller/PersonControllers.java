package com.reactive.programming.controller;

import io.reactivex.rxjava3.core.Single;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * package com.reactive.programming.controllers; /**
 *
 * @author <John Brix Pomoy>
 * @version $Id: PersonControllers.java, v 0.1 2025-04-17 3:25 AM John Brix Pomoy Exp $$
 */
@RestController
@RequestMapping("/api/v1/persons")
public class PersonControllers {

    @GetMapping("/{id}")
    public Single<String> getHelloWorld(@PathVariable Long id){

        return Single.just("HelloWorld");
    }
}
