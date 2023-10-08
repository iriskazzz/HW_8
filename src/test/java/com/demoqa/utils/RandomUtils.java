package com.demoqa.utils;

import java.util.Random;

import static com.demoqa.data.TestData.faker;

public class RandomUtils {
  public static String getRandomString(int length) {
    String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
    StringBuilder result = new StringBuilder();
    Random rnd = new Random();
    while (result.length() < length) {
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      result.append(SALTCHARS.charAt(index));
    }
    return result.toString();
  }

  public static String getRandomPhone() {
    return faker.phoneNumber().subscriberNumber(10);
  }
}