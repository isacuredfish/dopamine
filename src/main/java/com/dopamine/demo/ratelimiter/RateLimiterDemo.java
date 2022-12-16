package com.dopamine.demo.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzi.ma
 * @date 2022/12/16 11:26
 * Guava中单机限流工具类demo,基于令牌桶算法实现限流和平滑预热限流
 **/
public class RateLimiterDemo {

    public static void main(String[] args) {
        limitTraffic();
        preheatLimitTraffic();
    }

    /**
     *  平滑突发限流
     */
    public static void limitTraffic(){
        //每秒放5个令牌到桶里，即限制0.2s请求一次
        RateLimiter rateLimiter = RateLimiter.create(5);
        //for循环模拟请求
        for (int i = 0; i < 5; i++) {
            //获取令牌，返回这次获取的时间
            double sleepTime = rateLimiter.acquire(1);
            System.out.println("第"+(i+1)+"次请求，获取令牌时间为:"+sleepTime+"s");
        }
    }

    /**
     *  平滑预热限流
     */
    public static void preheatLimitTraffic(){
        //每秒放5个令牌到桶里，但是是在3秒内逐渐预热到这个速度
        RateLimiter rateLimiter = RateLimiter.create(5,2, TimeUnit.SECONDS);
        //for循环模拟请求
        for (int i = 0; i < 5; i++) {
            //获取令牌，返回这次获取的时间
            double sleepTime = rateLimiter.acquire(1);
            System.out.println("第"+(i+1)+"次请求，获取令牌时间为:"+sleepTime+"s");
        }
    }
}
