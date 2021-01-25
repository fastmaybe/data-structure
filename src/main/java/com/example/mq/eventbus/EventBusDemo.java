package com.example.mq.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.Executors;

/**
 * 在高并发的环境下使用AsyncEventBus时，发送事件可能会出现异常，
 * 因为它使用的线程池，当线程池的线程不够用时，会拒绝接收任务，
 * 就会执行线程池的拒绝策略，如果需要关注是否提交事件成功，
 * 就需要将线程池的拒绝策略设为抛出异常，并且try-catch来捕获异常。如下：
 *   try {
 *             eventBus.post(new LoginEvent("iwill", "123456"));
 *         }catch (Exception exp){
 *             // 落表或者其他处理
 *         }
 */

/**
 * @Author: liulang
 * @Date: 2020/12/8 16:01
 */
public class EventBusDemo {

    private AsyncEventBus eventBus;

    public EventBusDemo(){
        /**
         * 可以自定义线程池 设置策略
         */
        eventBus  = new AsyncEventBus(Executors.newSingleThreadExecutor());

        //注册
        eventBus.register(this);
    }


    @Subscribe
    public void onCountEvent(CountEvent event){
        System.out.println(event.type);
    }

    @Subscribe
    public void onCountEvent2(CountEvent event){
        System.out.println(event.type+"测试一下 发送一个事件 打印了两次事件");
    }

    @Subscribe
    public void onBitEvent(BitEvent event){
        System.out.println(event.type);
    }





    private static class CountEvent {
        private String type ="11111";

    }
    private static class BitEvent {
        private String type ="22222";

    }

    public static void main(String[] args) {

        EventBusDemo busDemo = new EventBusDemo();

        //发送事件
        busDemo.eventBus.post(new EventBusDemo.CountEvent());


        busDemo.eventBus.post(new EventBusDemo.BitEvent());

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
