package com.dopamine.demo.datastructure;

/**
 * @author chenzi.ma
 * @since 2022/11/22
 * 测试用demo,用于测试编写代码中考虑到的疑问
 */
public class TestDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 0; i++) {
            System.out.println(1);
        }
    }

    /**
     * 测试新建空数组扩容
     */
    public static void testEmptyArray(){
        int[] array = new int[]{};
        array[0] = 1;
    }
}
