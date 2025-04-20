package com.reactive.programming.service.impl;

import com.reactive.programming.entity.PersonModel;
import com.reactive.programming.repository.PersonRepository;
import com.reactive.programming.service.PersonService;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.adapter.rxjava.RxJava3Adapter;
import reactor.core.publisher.Mono;

import static com.reactive.programming.constant.ExceptionConstants.DATABASE_ERROR;
import static com.reactive.programming.constant.PersonConstants.PERSON_ENTITY;

/**
 * package com.reactive.programming.services.impl; /**
 *
 * @author <John Brix Pomoy>
 * @version $Id: PersonServiceImpl.java, v 0.1 2025-04-20 1:15 AM John Brix Pomoy Exp $$
 */
@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Single<PersonModel>getPerson(Long id){

        Mono<PersonModel> personModelMono = personRepository.findById(id)
                .flatMap(personModel -> {
                    log.info(PERSON_ENTITY,personModel);

                    return Mono.just(personModel);
                })
                .switchIfEmpty(Mono.error(new Exception(DATABASE_ERROR)))
                .onErrorMap(Throwable::getCause);

        return RxJava3Adapter.monoToSingle(personModelMono);
    }

}
