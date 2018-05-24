package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 线程安全性：原子性 AtomicReference
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {

//    设置初始值
   private static AtomicReference<Integer> count=new AtomicReference<>(0);

    public static void main(String[] args) {
//       compareAndSet将expect与update的引用相比，相同返回true，并更新值，不相同，返回false，第一次相等，因为在常量池中
        log.info("count：{}",count.compareAndSet(0,2));  //true
        log.info("count：{}",count.compareAndSet(0,1));  //false
        count.compareAndSet(1,3);  //false
        count.compareAndSet(2,4);  //4
        count.compareAndSet(3,5);  //false
//        获得值
        log.info("count：{}",count.get());
    }
}
