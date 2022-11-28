package com.dopamine.demo.datastructure;

import java.util.Arrays;

/**
 * @author chenzi.ma
 * @since 2022/11/22
 * 稀疏数组:将一个二维数组按稀疏数组的形式保存，二维数组数据如下
 * 0   0   0  22   0   0   15
 * 0  11   0   0   0   17   0
 * 0   0   0  -6   0   0    0
 * 0   0   0   0   0  39    0
 * 91  0   0   0   0   0    0
 * 0   0  28   0   0   0    0
 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] sparseArray = getSparseArray();
        int[][] array = getArrayBySparseArray(sparseArray);
        getSparseArrayByArray(array);
    }

    /**
     * 构建稀疏数组
     */
    public static int[][] getSparseArray(){
        //构建稀疏数组，数组的三列所代表的意义分别为行，列，值
        int[][] sparseArray = new int[9][3];
        //数组第一行记录原二维数组的总行数，总列数，和非0数的总个数
        sparseArray[0] = new int[]{6,7,8};
        //第二行开始记录每个非0数的位置和值
        sparseArray[1] = new int[]{0,3,22};
        sparseArray[2] = new int[]{0,6,15};
        sparseArray[3] = new int[]{1,1,11};
        sparseArray[4] = new int[]{1,5,17};
        sparseArray[5] = new int[]{2,3,-6};
        sparseArray[6] = new int[]{3,5,39};
        sparseArray[7] = new int[]{4,0,91};
        sparseArray[8] = new int[]{5,2,28};
        //最后输出稀疏数组
        for (int[] element : sparseArray){
//            System.out.println(Arrays.toString(element));
        }
        return sparseArray;
    }

    /**
     * 将稀疏数组解析为普通二维数组
     */
    public static int[][] getArrayBySparseArray(int[][] sparseArray){
        //获取稀疏数组第一行数据，构建二维数组
        int row = sparseArray[0][0];
        int column = sparseArray[0][1];
        int[][] array = new int[row][column];
        //解析稀疏数组，从第二行开始
        for (int i = 1; i < sparseArray.length; i++) {
            int indexRow = sparseArray[i][0];
            int indexColumn = sparseArray[i][1];
            int val = sparseArray[i][2];
            array[indexRow][indexColumn] = val;
        }
        //最后输出数组
        for (int[] element : array){
//            System.out.println(Arrays.toString(element));
        }
        return array;
    }

    /**
     * 将普通数组解析为稀疏数组
     */
    public static void getSparseArrayByArray(int[][] array){
        //第一次遍历普通数组，获取稀疏数组长度
        //count为稀疏数组length,指的是普通数组中有值的数据量
        int count = 0;
        for (int i = 0; i < array.length ; i++) {
            int[] elementArray = array[i];
            count += Arrays.stream(elementArray).filter(e -> e!=0).count();
        }

        //创建稀疏数组，行数为普通数组中非0总数+1(第一行为记录行)，列数固定为3
        int[][] sparseArray = new int[count+1][3];
        //设置稀疏数组第一行数据
        sparseArray[0] = new int[]{array.length,array[0].length,count};

        //第二次遍历普通数组，向稀疏数组中填充数值
        int index = 1;
        for (int i = 0; i < array.length ; i++) {
            int[] elementArray = array[i];
            for (int j = 0; j < elementArray.length; j++) {
                int val = elementArray[j];
                if(val != 0){
                    sparseArray[index] = new int[]{i,j,val};
                    index++;
                }
            }
        }

        //打印稀疏数组
        for (int[] element : sparseArray){
            System.out.println(Arrays.toString(element));
        }
    }
}
