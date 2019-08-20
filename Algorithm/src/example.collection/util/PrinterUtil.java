package example.collection.util;

public class PrinterUtil {
    public static void print(int[] arr) {

        for(int item : arr)
            System.out.printf("%d ", item);

        System.out.println();
    }
}
