package org.example;

import org.example.data.Bike;
import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {
  public static void main(String[] args) {
    Optional<Student> studentOptional = StudentDataBase.getOptionalStudent();

    Optional<String> name = studentOptional
        .filter(e -> e.getGradeLevel() > 1)
            .flatMap(Student::getBike)
                .map(Bike::getName);

    System.out.println(name);

  }
}
