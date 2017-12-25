package com.atguigu.java8;

import org.junit.Test;

import java.net.ServerSocket;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * STREAM的终止操作
 */
public class TestStreamAPI3 {
    List<Employee> lists = Arrays.asList(
            new Employee("lisi",38,555,"FREE"),
            new Employee("wangwu",40,360,"BUSY"),
            new Employee("liuxiang",56,896,"BUSY"),
            new Employee("ll",22,564,"FREE")
    );
    @Test
    public void test1(){
        boolean free = lists.stream().allMatch((e) -> e.getStatus().equals("FREE"));

        Optional<Employee> first = lists.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).findFirst();
        System.out.println(first.get());
        //parallelStream表示并行
        Optional<Employee> free1 = lists.parallelStream().filter((e) -> e.getStatus().equals("FREE")).findAny();
        System.out.println(free1);

    }

    @Test
    public void test2(){

        long count = lists.stream().count();

        //获取工资最高的
        Optional<Employee> max = lists.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get());

        //获取最小的工资的工资是多少
        Optional<Double> min = lists.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(min.get());

    }

    @Test
    public void test3(){
        //归约：
        //reduce(T identity, BinaryOperator) 可以将流中元素反复结合起来，得到一个值。
        List<Integer> list = Arrays.asList(1,2,3,4);
        //0座位起始值，赋予x，y是每次从集合中取出的值
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
        //计算工资的总和:如果有可能为空的话封装到Optional中，防止空指针
        Optional<Double> reduce = lists.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce.get());
    }

    @Test
    public void test4(){
        //收集：
        //collect：将流转换为其他形式，接收一个collector接口的实现，用于给Stream中元素汇总的方法
        List<String> collect = lists.stream().map(Employee::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("_________________________");
        HashSet<String> collect1 = lists.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        collect1.forEach(System.out::println);
    }

    @Test
    public void test5(){
        //总数
        Long collect = lists.stream().collect(Collectors.counting());
        System.out.println("总数："+collect);
        //工资总和
        Double collect1 = lists.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("工资总和："+collect1);

        //平均值
        Double collect2 = lists.stream().collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println("工资平均值："+collect2);

    }

    @Test
    public void test6(){
        //分组
        Map<String, List<Employee>> collect = lists.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);


        //多级分组
        Map<String, Map<String, List<Employee>>> collect1 = lists.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
            if (e.getAge() > 25 && e.getAge() <= 40) {
                return "中年";
            } else {
                return "青年";
            }
        })));

        System.out.println(collect1);
    }

    @Test
    public void test7(){
        //分区
        Map<Boolean, List<Employee>> collect = lists.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 5000));
        System.out.println(collect);
    }

    /**
     * 给定一个数字列表，如何返回一个由每个数字的平方构成的列表呢？
     * 给定【1,2，3,4】 应该返回【1,4,9,16】
     */
    @Test
    public void test8(){

        Integer[] nums = new Integer[]{1,2,3,4};

        Arrays.stream(nums).map((x)->x*x).forEach(System.out::println);
    }

    @Test
    public void test9(){
        Optional<Integer> reduce = lists.stream().map((e) -> 1).reduce(Integer::sum);
        System.out.println(reduce.get());
    }
}
