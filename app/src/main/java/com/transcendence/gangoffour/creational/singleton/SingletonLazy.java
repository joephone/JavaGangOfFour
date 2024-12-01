package com.transcendence.gangoffour.creational.singleton;


/**
 * @author Joephone on 2024/12/1 1:12
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc 懒汉式（非线程安全） （Lazy Initialization）
 * 懒汉式 是在第一次调用 getInstance() 方法时才创建实例。这种方式延迟了实例的创建，只有在真正需要时才会创建实例。
 * 优点：节省资源，因为实例只在需要时才会被创建。
 * 缺点：如果不加锁处理，在多线程环境下可能会导致多个实例被创建，破坏单例的唯一性。因此，懒汉式需要考虑线程安全问题。
 * @Edition 1.0
 * @EditionHistory
 */
public class SingletonLazy {

    // 延迟初始化，实例在第一次调用时创建
    private static SingletonLazy instance;

    // 私有构造函数，防止外部实例化
    private SingletonLazy() {
        // 可以在这里进行一些初始化操作
    }

    // 提供全局访问点，但不是线程安全的
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    // 其他业务方法
    public void doSomething() {
        System.out.println("Doing something in 懒汉式");
    }

}
