package example.collection;

import example.collection.util.PrinterUtil;

public class ArrayExample {

    public static void main(String[] args) {

        // 1차원 배열 생성 방법 #1
        int[] array1 = new int[10];
        array1[0] = 10;
        PrinterUtil.print(array1);

        // 1차원 배열 생성 방법 #2
        int[] array2 = { 1, 3, 4, 5, 2 };
        PrinterUtil.print(array2);
    }
}
