package com.transcendence.gangoffour.creational.singleton;

/**
 * @author Joephone on 2024/12/1 9:32
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc 静态内部类实现的懒汉式（推荐）
 * 静态内部类的方式是一种既线程安全又高效的懒汉式实现。它利用了 Java 类加载机制的特性，
 * 只有在调用 getInstance() 时才会加载静态内部类，从而实现懒加载。
 * @Edition 1.0
 * @EditionHistory
 */
public class SingletonLazyStaticInnerClass {

    // 私有构造函数，防止外部实例化
    private SingletonLazyStaticInnerClass() {
        // 可以在这里进行一些初始化操作
    }

    // 静态内部类，只有在调用 getInstance() 时才会加载
    private static class SingletonHolder {
        private static final SingletonLazyStaticInnerClass INSTANCE = new SingletonLazyStaticInnerClass();
    }

    // 提供全局访问点，线程安全且懒加载
    public static SingletonLazyStaticInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // 其他业务方法
    public void doSomething() {
        System.out.println("Doing something in 静态内部类实现的懒汉式");
    }

}
