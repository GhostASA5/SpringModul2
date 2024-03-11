package com.example.modul2homework.events;

import com.example.modul2homework.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.creat-students", havingValue = "true")
@RequiredArgsConstructor
public class StartAppEvent {

    private final StudentService service;

    @EventListener(ApplicationStartedEvent.class)
    public void creatStudents(){
        service.addStudent("Artem", "Sv", "17");
        service.addStudent("Ivan", "Ph", "15");
    }
}
