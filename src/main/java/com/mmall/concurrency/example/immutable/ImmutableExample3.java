package com.mmall.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 不可变对象：Guava
 */
@ThreadSafe
public class ImmutableExample3 {

//    private final static List<Integer> list = ImmutableList.of(1, 2, 3);
//    ImmutableList.of(1, 2, 3)赋值
    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);
//ImmutableSet.copyOf(list) 复制list
    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

//    ImmutableMap.<Integer, Integer>builder().put(1, 2).put(3, 4).put(5, 6).build() 为map赋值
    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3, 4).put(5, 6).build();


    public static void main(String[] args) {
//        set.add(4);
//        map2.put(1,4);
//        Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println(map2.get(3));
    }
}
