package com.example.modul2homework.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentEventsListener {

    @EventListener
    public void handleAddStudentEvent(AddStudentEvent event) {
        System.out.println("Student added: " + event.getStudent());
    }

    @EventListener
    public void handleDeleteStudentEvent(DeleteStudentEvent event) {
        System.out.println("Student deleted: " + event.getId());
    }

}
