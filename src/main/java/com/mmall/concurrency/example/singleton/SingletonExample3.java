package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NotRecommend;
import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 安全发布对象:
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * 性能开销大
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有构造函数
    private SingletonExample3() {

    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态的工厂方法,加同步锁
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
