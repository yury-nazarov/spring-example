package ru.kors.springstudents.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kors.springstudents.model.Student;
import ru.kors.springstudents.repository.InMemoryStudentDAO;
import ru.kors.springstudents.service.StudentService;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryStudentServiceImpl implements StudentService {
    // @Autowired - вместо используем @AllArgsConstructor от lambok
    private final InMemoryStudentDAO repository;

    @Override
    public List<Student> findAllStudent() {
        return repository.findAllStudent();
        //        return List.of(
//            Student.builder().firstName("Олег").email("oleg@gg.yy").age(21).build(),
//            Student.builder().firstName("Григорий").email("vv@gg.yy").age(21).build(),
//            Student.builder().firstName("Анна").email("anna@gg.yy").age(21).build()
//        );
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    @Override
    public Student findEmail(String email) {
        return repository.findEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public void deleteStudent(String email) {
        repository.deleteStudent(email );
    }
}
