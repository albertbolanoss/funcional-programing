package org.example.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class PeriodExample {
  public static void main(String[] args) {
    LocalDate localDate1 = LocalDate.now();
    LocalDate localDate2 = LocalDate.now().plusDays(783);

    // The period defined the period between days, month, years each calculate apart
    Period period = Period.between(localDate1, localDate2);
    System.out.println(String.format("Period in: Days: %s, Months: %s, Years: %s",
        period.getDays(),
        period.getMonths(),
        period.getYears()));

    Period period2 = Period.between(localDate2, localDate1);
    System.out.println(String.format("Period in: Days: %s, Months: %s, Years: %s",
        period2.getDays(),
        period2.getMonths(),
        period2.getYears()));


    LocalDateTime localDateTime1 = LocalDateTime.now();
    LocalDateTime localDateTime2 = LocalDateTime.now().plusHours(60);

    // The duration return the time conversion (seconds, minutes, hours, etc) between two date times
    Duration duration = Duration.between(localDateTime1, localDateTime2);

    System.out.println(String.format("Duration in: Hours: %s, equal to Minutes: %s, equals to Seconds: %s",
        duration.toHours(),
        duration.toMinutes(), duration.toSeconds()));


    var instant = Instant.now();
    var instant2 = Instant.ofEpochMilli(0);
    var diff = Duration.between(instant2, instant).toSeconds();
    System.out.println(String.format("Epoch: %s, Object: %s", instant.toEpochMilli(), instant));
    System.out.println(String.format("Duration: %s", diff));

  }
}
