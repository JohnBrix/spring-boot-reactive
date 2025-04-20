package com.reactive.programming.service;

import com.reactive.programming.entity.PersonModel;
import io.reactivex.rxjava3.core.Single;

/**
 * package com.reactive.programming.services; /**
 *
 * @author <John Brix Pomoy>
 * @version $Id: PersonService.java, v 0.1 2025-04-20 1:13 AM John Brix Pomoy Exp $$
 */
public interface PersonService {

    Single<PersonModel> getPerson(Long id);
}
