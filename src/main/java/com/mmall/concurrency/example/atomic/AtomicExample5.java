package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 线程安全性：原子性 AtomicIntegerFieldUpdater
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");
    //    AtomicIntegerFieldUpdater 更新指定字段，字段要求volatile修饰，不能为static
    @Getter
//    生成getter方法
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();
//        第一个参数为对象
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success 1,{}", example5.getCount());
            if (updater.compareAndSet(example5, 120, 140)) {
                log.info("update success 2,{}", example5.getCount());
            } else {
                log.info("update failed,{}", example5.getCount());
            }
        }
    }
}
