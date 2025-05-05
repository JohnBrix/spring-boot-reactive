package com.reactive.programming.model;

import com.reactive.programming.entity.PersonModel;
import lombok.Builder;
import lombok.Data;

/**
 * package com.reactive.programming.dto; /**
 *
 * @author <John Brix Pomoy>
 * @version $Id: HttpPersonResponse.java, v 0.1 2025-04-20 2:30 AM John Brix Pomoy Exp $$
 */
@Data
@Builder
public class HttpPersonResponse {

    private boolean result;
    private String resultMessage;
    private String resultDescription;
    private PersonModel personModel;

}
