package com.example.demo.design.Bulid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class mainClass {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("1","5","8","4","2","6","10","3","9","7");
        List<String> filter = strList.stream().filter(i -> Integer.parseInt(i) %2 !=0).collect(Collectors.toList());
        for (String s : filter) {
            System.out.println(s);
        }

        List<String> list2 = strList.stream().sorted().collect(Collectors.toList());

        List<Integer> intList = strList.stream().map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("===String转int===");
        intList.forEach(n -> System.out.println(n));
        System.out.println("===排序===");
        for (String s : list2) {
            System.out.println(s);
        }
        System.out.println("===int排序===");
        List<Integer> sortedInt = intList.stream().sorted().collect(Collectors.toList());
        sortedInt.forEach(i -> System.out.println(i));
        list2.forEach(n -> System.out.println("lanmda测试2" + n));

    }
    public static void print(String s) {
        System.out.println(s);
    }

}
