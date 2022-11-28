package com.dopamine.demo.datastructure.singlelinkedlist;

import lombok.Data;

/**
 * @author chenzi.ma
 * @since 2022/11/24
 * 定义：链表节点类，用于存放数据
 */
@Data
public class NodeDemo {

    /**
     * 编号，单链表唯一索引
     */
    private int no;

    /**
     * 链表数据
     */
    private NodeDemo next;

    /**
     * 元素名称
     */
    private String name;


    public NodeDemo(int no, NodeDemo next, String name) {
        this.no = no;
        this.next = next;
        this.name = name;
    }

    public NodeDemo(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "NodeDemo{" + "no=" + no +  ", name='" + name + '\'' + '}';
    }
}
