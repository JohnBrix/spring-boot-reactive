package com.reactive.programming.controller;

import com.reactive.programming.model.HttpPersonResponse;
import com.reactive.programming.entity.PersonModel;
import com.reactive.programming.service.PersonService;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.reactive.programming.constant.ExceptionConstants.*;
import static com.reactive.programming.constant.PersonConstants.*;

/**
 * package com.reactive.programming.controllers; /**
 *
 * @author <John Brix Pomoy>
 * @version $Id: PersonControllers.java, v 0.1 2025-04-17 3:25 AM John Brix Pomoy Exp $$
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/persons")
public class PersonControllers {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Single<ResponseEntity<HttpPersonResponse>>getHelloWorld(@PathVariable Long id){
        log.info("Id: {}",id);

        return personService.getPerson(id)
                .flatMap(response -> Single.just(new ResponseEntity<>(buildSuccessResponse(response), HttpStatus.OK)))
                .onErrorResumeNext(errorResponse->{

                    if(errorResponse.getMessage().contains(DATABASE_ERROR)){
                        return Single.just(new ResponseEntity<>(buildInternalServerResponse(),HttpStatus.INTERNAL_SERVER_ERROR));
                    }
                    return Single.just(new ResponseEntity<>(buildInternalServerResponse(),HttpStatus.INTERNAL_SERVER_ERROR));
                });

    }

    public HttpPersonResponse buildSuccessResponse(PersonModel response){

        return HttpPersonResponse.builder()
                .result(RESULT)
                .resultMessage(RESULT_MESSAGE)
                .resultDescription(RESULT_DESCRIPTION)
                .personModel(response)
                .build();
    }

    public HttpPersonResponse buildInternalServerResponse(){

        return HttpPersonResponse.builder()
                .result(false)
                .resultMessage(ERROR)
                .resultDescription(THERE_S_SOMETHING_WRONG)
                .build();
    }


}
