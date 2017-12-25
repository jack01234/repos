package com.atguigu.java8;

@FunctionalInterface
public interface MyFunction<T,R> {
    public R getValue(T t1, T t2);
}
