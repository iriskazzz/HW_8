package com.demoqa.data;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Stream;

import static com.demoqa.utils.RandomUtils.getRandomPhone;
import static com.demoqa.utils.RandomUtils.getRandomString;
import static java.lang.String.format;
import static java.util.Calendar.*;
import static java.util.Calendar.MONTH;
import static java.util.Locale.*;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class TestData {
  public static Faker faker = new Faker(new Locale("ru"));
  private final String[]
          genderList = {"Male", "Female", "Other"},
          monthList = {"January", "February", "March", "April", "May", "June",
                  "July", "August", "September", "October", "November", "December"},
          subjectList = {"Accounting", "Arts", "Biology", "Chemistry", "Civics", "Commerce", "Computer Science",
                  "Economics", "English", "Hindi", "History", "Maths", "Physics", "Social Studies"},
          hobbiesList = {"Sports", "Reading", "Music"},
          stateList = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
          ncrCities = {"Delhi", "Gurgaon", "Noida"},
          uttarCities = {"Agra", "Lucknow", "Merrut"},
          haryanaCities = {"Karnal", "Panipat"},
          rajasthanCities = {"Jaipur", "Jaiselmer"};
  public String
          firstName = faker.name().firstName(),
          lastName = faker.name().lastName(),
          fullName = format("%s %s", firstName, lastName),
          email = getRandomString(6) + "@quru.qa",
          gender = faker.options().option(genderList),
          number = getRandomPhone(),
          day = String.valueOf(faker.number().numberBetween(10, 30)),
          month = faker.options().option(monthList),
          year = String.valueOf(faker.number().numberBetween(1901, 2020)),
          expectedDateOfBirth = format("%s %s,%s", day, month, year),
          subject = faker.options().option(subjectList),
          currentAddress = faker.address().fullAddress(),
          hobby = faker.options().option(hobbiesList),
          picture = "test.png",
          state = faker.options().option(stateList),
          city = getCity(state),
          stateAndCity = format("%s %s", state, city);

  private String getCity(String ofState) {
    return switch (ofState) {
      case "NCR" -> faker.options().option(ncrCities);
      case "Uttar Pradesh" -> faker.options().option(uttarCities);
      case "Haryana" -> faker.options().option(haryanaCities);
      case "Rajasthan" -> faker.options().option(rajasthanCities);
      default -> "";
    };
  }
}