package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.data.TestData;
import com.demoqa.page.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class RegistrationFormWithTestDataTests {

  RegistrationFormPage registrationFormPage = new RegistrationFormPage();
  TestData testData = new TestData();


  private final static String TITLE_TEXT = "Student Registration Form";

  @BeforeAll
  static void configure() {
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://demoqa.com";
  }

  @Test
  void fillPracticeForm() {
    System.out.println(testData);
    registrationFormPage
            .openPage()
            .checkTitle(TITLE_TEXT)
            .removeBanner()
            .setFirstName(testData.firstName)
            .setLastName(testData.lastName)
            .setEmail(testData.email)
            .setGenter(testData.gender)
            .setNumber(testData.number)
            .setBirthDate(testData.day, testData.month, testData.year)
            .setSubjects(testData.subject)
            .setHobbies(testData.hobby)
            .setPicture(testData.picture)
            .setCurrentAddress(testData.currentAddress)
            .setState(testData.state)
            .setCity(testData.city)

            .clickSubmit()

            .checkResultTable()
            .checkResult("Student Name", testData.fullName)
            .checkResult("Student Email", testData.email)
            .checkResult("Gender", testData.gender)
            .checkResult("Mobile", testData.number)
            .checkResult("Date of Birth", testData.expectedDateOfBirth)
            .checkResult("Subjects", testData.subject)
            .checkResult("Hobbies", testData.hobby)
            .checkResult("Picture", testData.picture)
            .checkResult("Address", testData.currentAddress)
            .checkResult("State and City", testData.stateAndCity);
  }

  @Test
  void fillPracticeWithMinimumDataForm() {
    System.out.println(testData);
    registrationFormPage
            .openPage()
            .removeBanner()
            .checkTitle(TITLE_TEXT)
            .setFirstName(testData.firstName)
            .setLastName(testData.lastName)
            .setGenter(testData.gender)
            .setNumber(testData.number)

            .clickSubmit()

            .checkResultTable()
            .checkResult("Student Name", testData.fullName)
            .checkResult("Gender", testData.gender)
            .checkResult("Mobile", testData.number)
    ;
  }
}