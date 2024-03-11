package com.example.modul2homework.events;

import com.example.modul2homework.domain.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AddStudentEvent  extends ApplicationEvent {

    private final Student student;

    public AddStudentEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
