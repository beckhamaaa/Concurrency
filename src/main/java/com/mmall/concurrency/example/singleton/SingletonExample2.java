package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 安全发布对象:
 * 饿汉模式
 * 单例实例在类装载时进行创建
 * 缺点：
 * 1.构造方法中代码多时创建对象较慢，性能低
 * 2.如果此类未被使用，会造成资源浪费
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有构造函数
    private SingletonExample2() {

    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
