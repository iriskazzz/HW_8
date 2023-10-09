package com.demoqa.utils;

import java.util.Random;

import static com.demoqa.data.TestData.faker;

public class RandomUtils {
  public static String getRandomString(int length) {
    String saltChars = "abcdefghijklmnopqrstuvwxyz1234567890";
    StringBuilder result = new StringBuilder();
    Random rnd = new Random();
    while (result.length() < length) {
      int index = (int) (rnd.nextFloat() * saltChars.length());
      result.append(saltChars.charAt(index));
    }
    return result.toString();
  }

}