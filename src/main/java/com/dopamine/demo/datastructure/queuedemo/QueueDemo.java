package com.dopamine.demo.datastructure.queuedemo;

import java.util.Arrays;

/**
 * @author chenzi.ma
 * @since 2022/11/23
 * 队列demo
 */
public class QueueDemo {

    public static final int maxSize = 5;

    public static int[] queue = new int[maxSize];
    public static int rear = -1;
    public static int front = -1;

    public static void main(String[] args) {
        addQueue(1);
        System.out.println("存入一次数据，目前数据为：queue:"+Arrays.toString(queue) + "【rear="+rear + "】 【front="+front+"】");
        addQueue(2);
        System.out.println("存入一次数据，目前数据为：queue:"+Arrays.toString(queue) + "【rear="+rear + "】 【front="+front+"】");
        addQueue(3);
        System.out.println("存入一次数据，目前数据为：queue:"+Arrays.toString(queue) + "【rear="+rear + "】 【front="+front+"】");
        addQueue(4);
        System.out.println("存入一次数据，目前数据为：queue:"+Arrays.toString(queue) + "【rear="+rear + "】 【front="+front+"】");
        addQueue(5);
        System.out.println("存入一次数据，目前数据为：queue:"+Arrays.toString(queue) + "【rear="+rear + "】 【front="+front+"】");

        System.out.println("取出一次数据为："+ takeQueue() +"剩余数据为:queue:"+Arrays.toString(queue) + "【rear="+rear + "】 【front="+front+"】");
        System.out.println("取出一次数据为："+ takeQueue() +"剩余数据为:queue:"+Arrays.toString(queue) + "【rear="+rear + "】 【front="+front+"】");
        System.out.println("取出一次数据为："+ takeQueue() +"剩余数据为:queue:"+Arrays.toString(queue) + "【rear="+rear + "】 【front="+front+"】");
        System.out.println("取出一次数据为："+ takeQueue() +"剩余数据为:queue:"+Arrays.toString(queue) + "【rear="+rear + "】 【front="+front+"】");
        System.out.println("取出一次数据为："+ takeQueue() +"剩余数据为:queue:"+Arrays.toString(queue) + "【rear="+rear + "】 【front="+front+"】");
        System.out.println("取出一次数据为："+ takeQueue() +"剩余数据为:queue:"+Arrays.toString(queue) + "【rear="+rear + "】 【front="+front+"】");

    }

    /**
     * 将提供数据按队尾放入queue数组
     * @param i
     */
    public static void addQueue(int i){
        if(front == maxSize-1){
            System.out.println("队列已满！");
            return;
        }
        front++;
        queue[front] = i;
    }

    /**
     * 按顺序取出queue中数据
     */
    public static int takeQueue(){
        if(rear == front){
            System.out.println("队列已空!");
            return -1;
        }
        rear++;
        int result = queue[rear];
        queue[rear] = 0;
        return result;
    }
}
