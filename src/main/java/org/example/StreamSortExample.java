package org.example;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamSortExample {
  public static List<Student> getStudentSortByName() {
    Function<Student, String> activities = Student::getName;
    Function<Student, Integer> grade = Student::getGradeLevel;

    return StudentDataBase.getAllStudents().stream()
        .sorted(Comparator.comparing(activities).thenComparing(grade))
        .collect(Collectors.toList());
  }

  public static List<Student> getStudentSortByGrade() {
    Function<Student, Integer> grade = Student::getGradeLevel;

    return StudentDataBase.getAllStudents().stream()
        .sorted(Comparator.comparing(grade).reversed())
        .collect(Collectors.toList());
  }


  public static void main(String[] args) {
    getStudentSortByName().stream().forEach(System.out::println);
    getStudentSortByGrade().stream().forEach(System.out::println);
  }
}
