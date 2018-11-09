package com.epam.task7_1;

import java.lang.reflect.Field;

public class Runner {
    public void run() throws NoSuchFieldException, IllegalAccessException {
        String string = "Hello Java";
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter your string");
//        String string = scanner.nextLine();
        System.out.println(string);
        Class<?> clazz = string.getClass();
        Field field = clazz.getDeclaredField("value");

        field.setAccessible(true);
        field.set(string, "New string".toCharArray());
        System.out.println("new  -> " + string);

        System.out.println("Hello Java".equals("New string"));

    }
}
