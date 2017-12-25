package com.atguigu.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * java四大核心函数式接口
 * 1.Consumer<T>:消费型接口
 *      void accept(T t)
 *
 * 2.Supplier<T>:供给型接口
 *      T get()
 * 3.Function<T,R>:函数型接口
 * R apply(T t)
 *
 * 4.断言型接口：
 * Predicate<T>:断言型接口
 *   Boolean test(T t)
 */
public class TestLambda3 {

    //消费型接口
    @Test
    public void test1(){
        happy(10000,m->System.out.println("谁喜欢大保健，每次消费"+m));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    //供给型接口

    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));

        numList.stream().forEach(System.out::println);
    }
    //产生一些整数放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List list = new ArrayList();
        for (int i=0; i<num; i++) {
            Integer n = sup.get();
            list.add(n);
        }

        return list;
    }
}
