package com.example.modul2homework.service;

import com.example.modul2homework.domain.Student;
import com.example.modul2homework.events.AddStudentEvent;
import com.example.modul2homework.events.DeleteStudentEvent;
import com.example.modul2homework.exceptions.IncorrectUserDataException;
import com.example.modul2homework.exceptions.NoSuchStudentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;

@Component
@Slf4j
public class StudentService {

    private final ApplicationEventPublisher publisher;
    private final HashMap<UUID, Student> students = new HashMap<>();

    public StudentService(ApplicationEventPublisher publisher){
        this.publisher  = publisher;
    }

    public String getStudents(){
        StringBuilder sb = new StringBuilder();
        students.values().forEach(student -> sb.append(student.toString()).append("\n"));
        log.info("get all students");
        return sb.toString().trim();
    }

    public void addStudent(String firstName,  String lastName, String age){
        if (!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+") || !age.matches("\\d+")){
            throw new IncorrectUserDataException("You write incorrect student first name, last name or age. Check you request");
        }
        UUID id = UUID.randomUUID();
        Student student = new Student(id, firstName, lastName, Integer.parseInt(age));
        students.put(id, student);
        publisher.publishEvent(new AddStudentEvent(this, student));
        log.info("add student " + student);
    }

    public void deleteStudent(String id){
        try {
            UUID uuid = UUID.fromString(id);
            if (students.containsKey(uuid)){
                students.remove(UUID.fromString(id));
                publisher.publishEvent(new DeleteStudentEvent(this, id));
                log.info("delete student with id " + id);
            } else {
                log.info("NoSuchStudentException: User with this id does not exist");
                throw new NoSuchStudentException("User with this id does not exist");
            }
        } catch (Exception ex){
            log.info("NoSuchStudentException: User with this id does not exist");
            throw new NoSuchStudentException("User with this id does not exist");
        }
    }

    public void deleteAllStudents(){
        students.clear();
        log.info("delete all students");
    }

}
