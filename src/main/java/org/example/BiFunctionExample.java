package org.example;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {

//  public static void main(String[] args) {
//    BiFunction<String, Integer, String> concat = (text, value) -> text + "" + value;
//    System.out.println(concat.apply("Hello", 1));
//  }

  private static Map<String, String> loginPageLocs = new HashMap<>();


  static BiFunction<List<Student>, Predicate<Student>,Map<String, Double>> biFunction = (students, studentPredicate)->{

    Map<String,Double> studentGradeMap = new HashMap<>();
    students.forEach((student -> {

      if(studentPredicate.test(student)){
        studentGradeMap.put(student.getName(),student.getGpa());
      }
    }));

    return studentGradeMap;

  };

  public static String getLoginLocs(String sLocator, String elementType) {

    return loginPageLocs.get(elementType);
  }

  static BiFunction<String,String,String> getLoginLocs = (sLocator,elementType) -> loginPageLocs.get(sLocator);

  public static void main(String[] args) {

    System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), PredicateStudentExample.p2));

    getLoginLocs.apply("locator","elementType");

  }
}
