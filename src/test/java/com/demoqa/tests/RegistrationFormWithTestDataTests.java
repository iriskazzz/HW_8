package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.page.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.demoqa.data.TestData.*;

public class RegistrationFormWithTestDataTests {

  RegistrationFormPage registrationFormPage = new RegistrationFormPage();

  private final static String TITLE_TEXT = "Student Registration Form";

  @BeforeAll
  static void configure() {
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://demoqa.com";
  }

  @Test
  void fillPracticeForm() {
    registrationFormPage
            .openPage()
            .checkTitle(TITLE_TEXT)
            .removeBanner()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setGenter(gender)
            .setNumber(number)
            .setBirthDate(day, month, year)
            .setSubjects(subject)
            .setHobbies(hobby)
            .setPicture(picture)
            .setCurrentAddress(currentAddress)
            .setState(state)
            .setCity(city)

            .clickSubmit()

            .checkResultTable()
            .checkResult("Student Name", fullName)
            .checkResult("Student Email", email)
            .checkResult("Gender", gender)
            .checkResult("Mobile", number)
            .checkResult("Date of Birth", expectedDateOfBirth)
            .checkResult("Subjects", subject)
            .checkResult("Hobbies", hobby)
            .checkResult("Picture", picture)
            .checkResult("Address", currentAddress)
            .checkResult("State and City", stateAndCity);
  }

  @Test
  void fillPracticeWithMinimumDataForm() {
    registrationFormPage
            .openPage()
            .removeBanner()
            .checkTitle(TITLE_TEXT)
            .setFirstName(firstName)
            .setLastName(lastName)
            .setGenter(gender)
            .setNumber(number)

            .clickSubmit()

            .checkResultTable()
            .checkResult("Student Name", fullName)
            .checkResult("Gender", gender)
            .checkResult("Mobile", number)
    ;
  }
}