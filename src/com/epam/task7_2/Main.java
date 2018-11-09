package com.epam.task7_2;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        try {
            new Runner().run();
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
