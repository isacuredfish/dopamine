package com.dopamine.demo.datastructure.queuedemo;

import lombok.Data;

import java.util.Arrays;

/**
 * @author chenzi.ma
 * @since 2022/11/23
 * 在基础数组队列的前提下完善为环形队列
 *
 */
@Data
public class CircularQueueDemo {
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
     * 此处与普通数组队列不同：
     * 队尾位置，指向队伍的最后一个元素的位置+1，默认0
     */
    private int rear = 0;
    /**
     * 此处与普通数组队列不同：
     * 队首位置，指向队伍的第一个元素，默认0
     */
    private int front = 0;

    CircularQueueDemo(){
        super();
    }

    CircularQueueDemo(int maxSize){
        this.maxSize = maxSize;
        queue = new int[maxSize];
    }

    /**
     * 将提供数据按队尾放入queue数组
     * @param i
     */
    public void addQueue(int i){
        //因为会发生回环，所以此时判断队列是否已满的逻辑变为(rear+1) % maxSize = front
        if((rear+1) % maxSize == front){
            System.out.println("队列已满！");
            return;
        }
        //rear指的本身就是队列最后一位的下一位了，无需处理直接赋值
        queue[rear] = i;
        //将指针后移，此时需要考虑回环的场景
        rear = (rear +1) % maxSize;
    }

    /**
     * 按顺序取出queue中数据
     */
    public int takeQueue(){
        //队列为空的判断条件并未发生变化
        if(front == rear){
            System.out.println("队列已空!");
            return -1;
        }
        //fornt此时代表第一个元素，无需处理直接取值
        int result = queue[front];
        //取值之后进行清空，并且将front指针后移（考虑回环）
        queue[front] = 0;
        front = (front +1) % maxSize;
        return result;
    }

    /**
     * 获取队列中有效的数据个数
     * @return
     */
    public int getCount(){
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 按front->rear的顺序显示队列全部数据
     * @return
     */
    public String getQueueString(){
        if(rear == front){
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        //获取有效数据量
        int count = getCount();

        //首先输出front到有效数据量最后一位(不超过总长度)
        for (int i = front; i <front+count; i++) {
            stringBuilder.append(" "+ queue[i%maxSize]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CircularQueueDemo queueDemo = new CircularQueueDemo();
        System.out.println("测试初始化:"+ Arrays.toString(queueDemo.getQueue())+"[front="+queueDemo.getFront() + "][rear="+ queueDemo.getRear()+"]；此时队列输出为:"+queueDemo.getQueueString());
        queueDemo.addQueue(1);
        System.out.println("测试添加单个元素:"+ Arrays.toString(queueDemo.getQueue())+"[front="+queueDemo.getFront() + "][rear="+ queueDemo.getRear()+"]"+"[有效数据个数="+queueDemo.getCount()+"]；此时队列输出为:"+queueDemo.getQueueString());
        queueDemo.addQueue(2);
        queueDemo.addQueue(3);
        queueDemo.addQueue(4);
        System.out.println("测试添加到上限:"+ Arrays.toString(queueDemo.getQueue())+"[front="+queueDemo.getFront() + "][rear="+ queueDemo.getRear()+"]"+"[有效数据个数="+queueDemo.getCount()+"]；此时队列输出为:"+queueDemo.getQueueString());
        queueDemo.addQueue(100);
        System.out.println("测试空出一个空间:"+ Arrays.toString(queueDemo.getQueue())+"[front="+queueDemo.getFront() + "][rear="+ queueDemo.getRear()+"]"+"[有效数据个数="+queueDemo.getCount()+"]；此时队列输出为:"+queueDemo.getQueueString());
        System.out.println("测试取出第一个数据，取出的值为:"+queueDemo.takeQueue()+"此时队列为:"+ Arrays.toString(queueDemo.getQueue())+"[front="+queueDemo.getFront() + "][rear="+ queueDemo.getRear()+"]"+"[有效数据个数="+queueDemo.getCount()+"]；此时队列输出为:"+queueDemo.getQueueString());
        System.out.println("测试取出第二个数据，取出的值为:"+queueDemo.takeQueue()+"此时队列为:"+ Arrays.toString(queueDemo.getQueue())+"[front="+queueDemo.getFront() + "][rear="+ queueDemo.getRear()+"]"+"[有效数据个数="+queueDemo.getCount()+"]；此时队列输出为:"+queueDemo.getQueueString());
        queueDemo.addQueue(5);
        System.out.println("此时添加元素会发生回环:"+ Arrays.toString(queueDemo.getQueue())+"[front="+queueDemo.getFront() + "][rear="+ queueDemo.getRear()+"]"+"[有效数据个数="+queueDemo.getCount()+"]；此时队列输出为:"+queueDemo.getQueueString());
        queueDemo.addQueue(6);
        System.out.println("此时添加元素会发生回环:"+ Arrays.toString(queueDemo.getQueue())+"[front="+queueDemo.getFront() + "][rear="+ queueDemo.getRear()+"]"+"[有效数据个数="+queueDemo.getCount()+"]；此时队列输出为:"+queueDemo.getQueueString());

    }
}
