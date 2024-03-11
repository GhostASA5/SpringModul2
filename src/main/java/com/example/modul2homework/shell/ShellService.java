package com.example.modul2homework.shell;

import com.example.modul2homework.exceptions.IncorrectUserDataException;
import com.example.modul2homework.exceptions.NoSuchStudentException;
import com.example.modul2homework.service.StudentService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ShellService {

    private final StudentService service;

    public ShellService(StudentService service) {
        this.service = service;
    }

    @ShellMethod(key = "get")
    public String getStudents(){
        String students = service.getStudents();
        if (students.equals("")){
            return "Student list is empty";
        }
        return "Students list: \n" + service.getStudents();
    }

    @ShellMethod(key = "add")
    public String addStudent(@ShellOption(value = "f") String firstName,
                           @ShellOption(value = "l") String lastName,
                           @ShellOption(value = "a") String age){
        try {
            service.addStudent(firstName, lastName, age);
            return "Student saved";
        } catch (IncorrectUserDataException ex){
            return ex.getMessage();
        }
    }

    @ShellMethod(key = "delete")
    public String deleteStudent(@ShellOption(value = "id") String id){
        try {
            service.deleteStudent(id);
            return "Student was delete";
        } catch (NoSuchStudentException ex){
            return ex.getMessage();
        }
    }

    @ShellMethod(key = "delete all")
    public String deleteAllStudents(){
        service.deleteAllStudents();
        return "All students was delete";
    }
}
