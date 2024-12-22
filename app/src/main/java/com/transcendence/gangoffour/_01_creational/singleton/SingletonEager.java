package com.transcendence.gangoffour._01_creational.singleton;


/**
 * @author Joephone on 2024/12/1 1:12
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc 饿汉式（Eager Initialization）
 * 饿汉式 是在类加载时就立即创建实例。这意味着无论你是否需要使用该实例，它都会被创建。
 * 优点：实现简单，线程安全，因为实例在类加载时就已经创建，避免了多线程环境下的并发问题。
 * 缺点：如果该实例在整个程序运行期间从未被使用过，可能会造成资源浪费，因为它是在类加载时就创建的。
 * @Edition 1.0
 * @EditionHistory
 */
public class SingletonEager {

    // 在类加载时就创建实例
    private static final SingletonEager instance = new SingletonEager();

    // 私有构造函数，防止外部实例化
    private SingletonEager() {
        // 可以在这里进行一些初始化操作
    }

    // 提供全局访问点
    public static SingletonEager getInstance() {
        return instance;
    }

    // 其他业务方法
    public void doSomething() {
        System.out.println("Doing something in 饿汉式");
    }

}
