package org.example.mapper;

import java.util.function.Function;

public class Mapper implements Convert<Person, PersonDTO> {

  public static Function<Person, PersonDTO> convertToDTO = (person) ->
      new PersonDTO(person.getName(), person.getLastName());

  @Override
  public PersonDTO convert(Person person) {
    return new PersonDTO(person.getName(), person.getLastName());
  }

  public static PersonDTO convertToDTO(Person person) {
    return new PersonDTO(person.getName(), person.getLastName());
  }
}
