package sdk.dovlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Koi_Factory {

    public static void main(String[] args) {
        
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        int[] bs = new int[n];
//        
//        for(int i = 0; i < n ; i++) {
//            list.add(in.nextInt());
//        }
//        for(int i = 0; i < n ; i++) {
//            bs[i] = in.nextInt();
//        }
//        in.close();
        
        int n = 5;
        int[] as = { 132, 392, 311, 351, 231 };
        List<Integer> list = Arrays.asList(132, 392, 311, 351, 231);
        int[] bs = { 392, 351, 132, 311, 231 };
        
        // bs의 인덱스 순서
        int[] array = new int[n];
        for(int i = 0; i < bs.length; i++) {
            array[i] = list.indexOf(bs[i]);
        }
        
        // 1. 전수조사
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(array[0]);
        for(int i = 1; i < array.length; i++) {
            
            int pivot = array[i];
            set.add(pivot);
            
//            set.
        }
        
//        int count = 0;
//        for(int i = 1; i < array.length; i++) {
//            
//            int pivot = array[i];
//            
//            for(int j = 0; j < i; j++) {
//                
//                if(array[j] > pivot) {
//                    count++;
//                }
//            }
//        }
        
//        System.out.println(count);
    }
}
