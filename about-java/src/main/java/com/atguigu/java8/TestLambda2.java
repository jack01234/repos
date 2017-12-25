package com.atguigu.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能
 * 1.无参数无返回值  ()->System.out.println();
 * 2.一个参数，有返回值
 *
 * 接口中只有一个抽象方法时被称为函数式接口
 * @FunctionalInterface 注解修饰的接口只能是函数式接口
 */
public class TestLambda2 {

    @Test
    public void test1(){
        int num = 0;
        Runnable runnable = ()->System.out.println("sssss"+num);
        runnable.run();
    }

    @Test
    public void test2(){
        Consumer<String> con = x->System.out.println("sfdfdsfsdf");
        con.accept("jjjjjjjj");
    }

    @Test
    public void test3(){
        Comparator<Integer> com = (x,y)->{
          System.out.println(x+y);
          return  Integer.compare(x,y);
        };


        //如果只有一条语句，大括号和return都可以省略
        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
    }


    @Test
    public void test5(){
        Integer operter = operter(10, num -> num + 200);
        System.out.println(operter);
    }
    //对数据进行运算
    public Integer operter(Integer num,MyFun myFun){

        return myFun.fun(num);
    }
}
