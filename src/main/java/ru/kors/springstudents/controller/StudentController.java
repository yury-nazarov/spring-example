package ru.kors.springstudents.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kors.springstudents.model.Student;
import ru.kors.springstudents.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor // Создает объекты по аналогии с new или @Autowired
public class StudentController {

    private StudentService service;

    @GetMapping
    public List<Student> findAllStudent() {
        return service.findAllStudent();
    }

    @PostMapping("save_student ")
    public String saveStudent(@RequestBody Student student) {
         service.saveStudent(student);
        return "Student successfully saved";
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable("email") String email) {
        return service.findEmail(email);
    }

    @PutMapping("update_student ")
    public Student updateStudents(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable("email") String email) {
        service.deleteStudent(email);
    }
}
