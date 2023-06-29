package org.example.mapper;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PersonController {



  public static void main(String[] args) {
    Arrays.asList(new Person()).stream()
        .map(Mapper::convertToDTO)
        .collect(Collectors.toList());

    Arrays.asList(new Person()).stream()
        .map(Mapper.convertToDTO)
        .collect(Collectors.toList());
  }
}
