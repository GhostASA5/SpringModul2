package com.example.modul2homework.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class DeleteStudentEvent extends ApplicationEvent {

    private final String id;

    public DeleteStudentEvent(Object source, String id) {
        super(source);
        this.id = id;
    }
}
