package com.emmaluo.javastudy;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zcluo on 2017/3/6.
 */
public class ThreadId {
    private static final AtomicInteger nextId;
    static
    {
        nextId = new AtomicInteger(0);
    }


    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return nextId.get();
        }
    };

    synchronized public static int get(){

        /*int ret = threadId.get();
        threadId.set(ret + 1);
        return ret;*/
        return nextId.getAndIncrement();

    }
}
