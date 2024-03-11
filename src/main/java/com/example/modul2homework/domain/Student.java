package com.example.modul2homework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private UUID id;

    private String firstName;

    private String lastName;

    private int age;

    @Override
    public String toString(){
        return MessageFormat.format("Student id - {0}, first name - {1}, last name - {2}, age - {3}",
                id, firstName, lastName, age);
    }

}
