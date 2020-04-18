package com.jingying.leetcode.base.datastructrue.SparseArr;

/**
 * 稀疏数组，总是三列结构，行数不固定，第一行的第一列为二维数组的总行数，第二列为二维数组的总列数，第三列为非0数字的个数。
 * 从第二行开始，第一列记录第1个非0数字所在的行数，第二列记录第1个非0数字所在的列数，第三列记录第一个非0数字的值
 * 第三列记录第2个非0数字的行数……以此类推
 */
public class SparseArr {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        System.out.println("空白棋盘");
        for (int[] ints : arr) {
            for (int item : ints) {
                System.out.printf("%d\t\t", item);
            }
            System.out.println();
        }

        // 给棋盘赋值，1代表蓝色棋子，2代表黑色棋子

        arr[1][2] = 1;
        arr[2][3] = 2;
        System.out.println("赋值后的棋盘");
        for (int[] ints : arr) {
            for (int item : ints) {
                System.out.printf("%d\t\t", item);
            }
            System.out.println();
        }

        // 获取棋盘不为零的数据

        int count = 0;
        for (int[] ints : arr) {
            for (int item : ints) {
                if (item != 0) {
                    count++;
                }
            }
        }

        System.out.println("初始化稀疏数组");
        // 创建稀疏数组
        int[][] sparseArr = new int[count + 1][3];
        for (int[] ints : sparseArr) {
            for (int item : ints) {
                System.out.printf("%d\t\t", item);
            }
            System.out.println();
        }

        // 开始为稀疏数组赋值
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr.length;
        sparseArr[0][2] = count;

        int loop = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    loop++;
                    sparseArr[loop][0] = i;
                    sparseArr[loop][1] = j;
                    sparseArr[loop][2] = arr[i][j];
                }
            }
        }

        System.out.println("赋值后稀疏数组");
        // 创建稀疏数组
        for (int[] ints : sparseArr) {
            for (int item : ints) {
                System.out.printf("%d\t\t", item);
            }
            System.out.println();
        }

        int[][] newArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            newArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("转换后的原数组");

        for (int[] ints : newArr) {
            for (int item : ints) {
                System.out.printf("%d\t\t", item);
            }
            System.out.println();
        }
    }
}
