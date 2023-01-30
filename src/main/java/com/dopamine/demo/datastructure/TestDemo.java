package com.dopamine.demo.datastructure;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author chenzi.ma
 * @since 2022/11/22
 * 测试用demo,用于测试编写代码中考虑到的疑问
 */
public class TestDemo {

    public static void main(String[] args) {

    }

    /**
     * 测试新建空数组扩容
     */
    public static void testEmptyArray(){
        //创建长度为6的arrayList
        ArrayList<String> list = new ArrayList<>(6);
        System.out.println(getArrayListCapacity(list));
        //添加至上限
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        System.out.println(getArrayListCapacity(list));
        //继续添加
        list.add("7");
        System.out.println(getArrayListCapacity(list));
        //继续添加
        list.add("8");
        list.add("9");
        System.out.println(getArrayListCapacity(list));
        //继续添加
        list.add("10");
        System.out.println(getArrayListCapacity(list));
    }

    /**
     * 获取arrayList中elementData的长度
     */
    public static int getArrayListCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            //获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            //开始访问权限
            field.setAccessible(true);
            //把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[])field.get(arrayList);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
