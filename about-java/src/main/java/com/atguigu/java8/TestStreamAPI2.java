package com.atguigu.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class TestStreamAPI2 {
    List<String> list = Arrays.asList("aa","cc","bb","dd");
    List<Employee> lists = Arrays.asList(
            new Employee("lisi",38,555),
            new Employee("wangwu",40,360),
            new Employee("liuxiang",56,896),
            new Employee("ll",22,564)
    );

    @Test
    public void test1(){
        Function<String,String> function = str->str.toUpperCase();
        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);

        Stream<Character> stream = list.stream().flatMap(TestStreamAPI2::filterCharacter);

        lists.stream().map(Employee::getName).forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch: str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }
    @Test
    public void test2(){
        list.stream().sorted().forEach(System.out::println);

        lists.stream().sorted((e1,e2)->{
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        })
        .forEach(System.out::println);
    }
}
