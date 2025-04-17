package com.reactive.programming.controllers;

import io.reactivex.rxjava3.core.Single;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * package com.reactive.programming.controllers; /**
 *
 * @author <John Brix Pomoy>
 * @version $Id: ReactiveControllers.java, v 0.1 2025-04-17 3:25 AM John Brix Pomoy Exp $$
 */
@RestController
public class ReactiveControllers {

    @GetMapping("/")
    public Single<String> getHelloWorld(){

        return Single.just("HelloWorld");
    }
}
