package com.mmall.concurrency;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 并发测试，Hello World
 * Created by Torres
 * 2018-05-16 23:20
 */
@Slf4j
@NotThreadSafe
public class ConcurrencyTest {
    //请求总数
    public static int clientTotal = 1000;
    //同时并发执行的线程数
    public static int threadTotal = 50;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        Semaphore 为final,并传入线程数
        final Semaphore semaphore = new Semaphore(threadTotal);
//        CountDownLatch 为final,并传入请求数
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++)
            executorService.execute(() -> {
//                jdk 1.8 lambda表达式
                try {
//                    获得许可
                    semaphore.acquire();
                    add();
//                    释放许可
                    semaphore.release();
                } catch (Exception e) {
                    log.info("exception", e);
                }
//                计算递减
                countDownLatch.countDown();
            });
//          等待，直到计数为0
            countDownLatch.await();
            executorService.shutdown();
        //        将count自动填充到 {}
        log.info("count:{}", count);
//            不为1000时，表明线程不安全

        }

    private static void add() {
        count++;
    }

}
