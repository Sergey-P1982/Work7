package com.epam.task73_75;

@FunctionalInterface
public interface ConvertString {
    String convert(String str);
    default boolean isNull(String string) {
      return string == null ||
              string.trim().equals("");
    }
}
