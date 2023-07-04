package org.example;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {

  public static void main(String[] args) {
    List<String> activities = StudentDataBase.getAllStudents().stream()
        .map(Student::getActivities)
        .flatMap(List::stream)
        .distinct()
          .sorted()
        .collect(Collectors.toList());

    System.out.println(activities);
  }
}
