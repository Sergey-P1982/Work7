package com.epam.task73_75;

import java.util.*;
import java.util.function.Predicate;

public class Runner {
    public void run() {

        //7_3

        Integer[] arrInt = createArrayInt(12);
        System.out.println("Array: " + Arrays.toString(arrInt));
        Arrays.sort(arrInt,
//                (x,y)->y.compareTo(x));
//                Integer::compareTo);
                Comparator.reverseOrder());
        System.out.println("Sort: " + Arrays.toString(arrInt));

        List<String> stringList = createListStrings();
        System.out.println("List: " + stringList);
        Collections.sort(stringList, Collections.reverseOrder());
        System.out.println("Sort: " + stringList);
        System.out.println("_____________________________________________________________");
        // 7_4

        System.out.println("sum " + sunEven(arrInt, x -> x % 2 == 0));
        System.out.println("sum " + sunEven(arrInt, x -> x > 10 && x % 3 == 0));
        System.out.println("_____________________________________________________________");
        System.out.println("select: " + selectStrings(stringList, x -> x.startsWith("c") || x.startsWith("a")));
        System.out.println("_____________________________________________________________");

        // 7_5
        updateListString(stringList, x -> x.toUpperCase());
        System.out.println("new list: " + stringList);
        List<String> list = Arrays.asList("", null, "  ", " sdvdfd");
        updateListString(list, String::toUpperCase);
        System.out.println("new list: " + list);
    }

    private Integer[] createArrayInt(int size) {
        Integer[] arrayInt = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < arrayInt.length; i++)
            arrayInt[i] = random.nextInt(100);
        return arrayInt;
    }

    private List<String> createListStrings() {
        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            list.add("" + ch + ch);
        }
        Collections.shuffle(list);
        return list;
    }

    public int sunEven(Integer[] array, Predicate<Integer> filter) {
        int ss = 0;
        for (int value : array) {
            if (filter.test(value)) {
                ss += value;
            }
        }
        return ss;
    }

    public List<String> selectStrings(List<String> list, Predicate<String> filter) {
        List<String> newList = new ArrayList<>();
        for (String string : list) {
            if (filter.test(string)) {
                newList.add(string);
            }
        }
        return newList;
    }

    public void updateListString(List<String> list, ConvertString convertString) {
        for (int i = 0; i < list.size(); i++) {
            if (!convertString.isNull(list.get(i))) {
                list.set(i, convertString.convert(list.get(i)));
            }
        }

    }
}
