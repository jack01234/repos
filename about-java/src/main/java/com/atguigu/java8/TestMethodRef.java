package com.atguigu.java8;

import org.junit.Test;

import java.util.function.Function;

public class TestMethodRef {
    /**
     * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
     */
    @Test
    public void test1(){
        Function<String, Employee> function = Employee::new;

        Employee employee = function.apply("aaa");
        System.out.println(employee);
    }
}
