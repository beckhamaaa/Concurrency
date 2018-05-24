package com.mmall.concurrency.example.threadLocal;

/**
 * 线程封闭：ThreadLocal
 */
public class RequestHolder {
//    ThreadLocal生命周期aa
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
//        必须移除，否则造成内存泄漏
        requestHolder.remove();
    }
}
