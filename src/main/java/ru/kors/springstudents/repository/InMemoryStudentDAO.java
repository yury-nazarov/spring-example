package ru.kors.springstudents.repository;

import org.springframework.stereotype.Repository;
import ru.kors.springstudents.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Repository
public class InMemoryStudentDAO {
    private final  List<Student> STUDENTS = new ArrayList<>();

    public List<Student> findAllStudent() {
        return STUDENTS;
    }


    public Student saveStudent(Student student) {
        STUDENTS.add(student);
        return student ;
    }

    public Student findEmail(String email) {
        // Используем потоки
        return STUDENTS.stream()
                //  Итерируемся по массиму students
                .filter(element -> element
                // для каждого студента проверяем электронную почту с той которую прислали
                .getEmail().equals(email)).findFirst()
                // если такой почты нет - то получим в ответе значение null
                .orElse(null);
    }

    public Student updateStudent(Student student) {
        var studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(index -> STUDENTS.get(index).getEmail()
                // Сравниваем с почтой получаемого студента
                .equals(student.getEmail()))
                .findFirst().orElse(-1);

        if (studentIndex > -1) {
            //  Обновляем данные в массиве
            STUDENTS.set(studentIndex, student);
            return student;
        }

        return null;
    }

    public void deleteStudent(String email) {
        var student = findEmail(email);
        if (student != null) {
            STUDENTS.remove(student);
        }

    }
}
