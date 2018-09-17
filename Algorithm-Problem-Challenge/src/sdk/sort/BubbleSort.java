package sdk.sort;

import java.util.Arrays;

public class BubbleSort {

    static int[] array = { 9, 3, 5, 4, 6, 1, 8, 2 };

    public static void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {

                // 현재원소와 바로 앞 원소를 비교하여 큰쪽을 뒤로 넘긴다.
                if (array[j - 1] > array[j])
                    swap(j - 1, j);
            }
        }

        System.out.println(Arrays.toString(array));
    }

    private static void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        BubbleSort.sort(array);
    }
}