package ru.kors.springstudents.service;

import org.springframework.stereotype.Service;
import ru.kors.springstudents.model.Student;

import java.util.List;


// преобразовав в интерфейс далее сможем делать реализации для RAM, HDD, etc
public interface StudentService {
    List<Student> findAllStudent();
    Student saveStudent(Student student);
    Student findEmail(String email);
    Student updateStudent(Student student);
    void deleteStudent(String email);

}

