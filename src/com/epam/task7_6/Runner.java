package com.epam.task7_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public void run() {
        // 7_1
        List<Integer> integerList = Stream.iterate(10, n -> n+10)
                .limit(10)
                .map(n -> n/2)
                .collect(Collectors.toList());
        System.out.println(integerList);

        // 7_2
        List<Person> people = createList();
        System.out.println("Before: " );
        people.stream().forEach(System.out::println);
        System.out.println("After: " );
        people.stream()
                .filter(obj -> obj.getSex() == Person.Sex.MALE && obj.getAge()>=18 && obj.getAge()<=55)
                .forEach(System.out::println);

        System.out.println("Average age =    " + people.stream()
                .filter(obj -> obj.getSex() == Person.Sex.FEMALE)
                .mapToInt(Person::getAge)
                .average().getAsDouble());
    }


    private List<Person> createList() {
        return Arrays.asList(new Person("Vasya", 34, Person.Sex.MALE),
        new Person("Oleg", 14, Person.Sex.MALE),
                new Person("Natali", 20, Person.Sex.FEMALE),
                new Person("Dasha", 54, Person.Sex.FEMALE),
                new Person("Igor", 18, Person.Sex.MALE),
                new Person("Nina", 34, Person.Sex.FEMALE),
                new Person("Oleg", 17, Person.Sex.MALE),
                new Person("Olya", 4, Person.Sex.FEMALE),
                new Person("Oleg1", 44, Person.Sex.MALE),
                new Person("Oleg3", 55, Person.Sex.MALE));
    }
}
