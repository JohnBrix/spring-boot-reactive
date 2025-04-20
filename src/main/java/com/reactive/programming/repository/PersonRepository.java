package com.reactive.programming.repository;

import com.reactive.programming.entity.PersonModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * package com.reactive.programming.repositories; /**
 *
 * @author <John Brix Pomoy>
 * @version $Id: PersonRepository.java, v 0.1 2025-04-20 2:01 AM John Brix Pomoy Exp $$
 */

public interface PersonRepository extends ReactiveCrudRepository<PersonModel,Long> {
}
