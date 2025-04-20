package com.reactive.programming.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * package com.reactive.programming.entities; /**
 *
 * @author <John Brix Pomoy>
 * @version $Id: PersonModel.java, v 0.1 2025-04-20 1:50 AM John Brix Pomoy Exp $$
 */
@Table("person")
public class PersonModel {
    @Id
    private Long id; // Primary key

    private String firstName;
    private String lastName;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
