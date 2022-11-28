package com.dopamine.demo.datastructure.queuedemo;

import lombok.Data;

import java.util.Arrays;

/**
 * @author chenzi.ma
 * @since 2022/11/23
 * 使用数组模拟队列
 */
@Data
public class ArrayQueueDemo {
    /**
     * 数组长度，默认5
     */
    private int maxSize = 5;
    /**
     * 存储数据使用的数组
     * 数组的存储为:front -> rear
     */
    private int[] queue = new int[maxSize];
    /**
     * 队尾位置，指的是队列下标最大的位置，默认-1
     */
    private int rear = -1;
    /**
     * 队首位置，指的是队列下标最小的位置，默认-1
     */
    private int front = -1;

    ArrayQueueDemo(){
        super();
    }

    ArrayQueueDemo(int maxSize){
        this.maxSize = maxSize;
        queue = new int[maxSize];
    }

    /**
     * 将提供数据按队尾放入queue数组
     * @param i
     */
    public void addQueue(int i){
        if(rear == maxSize-1){
            System.out.println("队列已满！");
            return;
        }
        rear++;
        queue[rear] = i;
    }

    /**
     * 按顺序取出queue中数据
     */
    public int takeQueue(){
        if(front == rear){
            System.out.println("队列已空!");
            return -1;
        }
        front++;
        int result = queue[front];
        queue[front] = 0;
        return result;
    }

    public static void main(String[] args) {
        ArrayQueueDemo arrayQueue = new ArrayQueueDemo();
        arrayQueue.addQueue(1);
        System.out.println("存入一次数据，目前数据为：queue:"+ Arrays.toString(arrayQueue.getQueue()) + "【rear="+arrayQueue.getRear() + "】 【front="+arrayQueue.getFront()+"】");
        System.out.println("取出一次数据为："+ arrayQueue.takeQueue() +"剩余数据为:queue:"+Arrays.toString(arrayQueue.getQueue()) + "【rear="+arrayQueue.getRear() + "】 -- 【front="+arrayQueue.getFront()+"】");
        System.out.println("取出一次数据为："+ arrayQueue.takeQueue() +"剩余数据为:queue:"+Arrays.toString(arrayQueue.getQueue()) + "【rear="+arrayQueue.getRear() + "】 -- 【front="+arrayQueue.getFront()+"】");
    }
}
