package com.transcendence.gangoffour.creational.singleton;

/**
 * @author Joephone on 2024/12/1 9:32
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc 线程安全的懒汉式（双重检查锁定）
 * 为了确保线程安全，同时避免每次调用 getInstance() 时都进行同步操作，
 * 可以使用 双重检查锁定（Double-Checked Locking）。这种方式在多线程环境下也能保证单例的唯一性，并且性能较好。
 * @Edition 1.0
 * @EditionHistory
 */
public class SingletonLazyThreadSafe {

    // 使用 volatile 关键字确保 instance 的可见性和有序性
    private static volatile SingletonLazyThreadSafe instance;

    // 私有构造函数，防止外部实例化
    private SingletonLazyThreadSafe() {
        // 可以在这里进行一些初始化操作
    }

    // 提供全局访问点，线程安全的懒汉式
    public static SingletonLazyThreadSafe getInstance() {
        if (instance == null) {  // 第一次检查
            synchronized (SingletonLazyThreadSafe.class) {
                if (instance == null) {  // 第二次检查
                    instance = new SingletonLazyThreadSafe();
                }
            }
        }
        return instance;
    }

    // 其他业务方法
    public void doSomething() {
        System.out.println("Doing something in 线程安全的懒汉式");
    }

}
