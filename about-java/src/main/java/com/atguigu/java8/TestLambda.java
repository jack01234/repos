package com.atguigu.java8;

import org.junit.Test;

import java.util.*;

public class TestLambda {

        List<Employee> lists = Arrays.asList(
                new Employee("lisi",38,555),
                new Employee("wangwu",40,360),
                new Employee("liuxiang",56,896),
                new Employee("ll",22,564)
        );


    @Test
    public void test1(){
        //原来的匿名内部类
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<Integer>(com);
    }

    //Lambda表达式
    @Test
    public void test2(){
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<Integer>(com);

        List<Employee> list =filterEmployee(lists, (e)->e.getSalary()>30);

        list.forEach(System.out::println);
    }


    public List<Employee> filterEmployee(List<Employee> lists, Mypredicate<Employee> mypredicate){
        List<Employee> employees = new ArrayList<>();
        for (Employee employee:lists) {
            if (mypredicate.test(employee)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    @Test
    public void test4(){
            lists.stream().filter((e)->e.getSalary()>30).limit(2).forEach(System.out::println);

            lists.stream()
                    .map(Employee::getName)
                    .forEach(System.out::println);
    }


    @Test
    public void test5(){
        Collections.sort(lists,(e1,e2)->{
            return -Integer.compare(e1.getAge(),e2.getAge());
        });

        lists.stream().forEach(System.out::println);
    }
}
