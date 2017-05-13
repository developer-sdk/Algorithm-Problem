package sdk.jungol.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 정올, 도서관
 * 
 * @author whitebeard
 *
 */
public class Problem2247 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] times = new int[n][2];
        for(int i = 0; i < n; i++) {
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
        }
        sc.close();
        
//        int n = 4;
//        int[][] times = {     { 1, 3 },
//                            { 3, 6 },
//                            { 3, 8 },
//                            { 12, 17 } };
        
//        int n = 10;
//        int[][] times = {     { 2, 7 },
//                            { 1, 1 },
//                            { 1, 1 },
//                            { 3, 8 },
//                            { 3, 7 },
//                            { 4, 9 },
//                            { 6, 7 },
//                            { 1, 1 },
//                            { 5, 5 },
//                            { 3, 6 } };
        
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] <= b[0] ? -1 : 1;
            }
        });
        
//        for(int[] time : times)
//            System.out.printf("%d %d\n", time[0], time[1]);
//        System.out.println("--------------------------");
        
        int inTime = 0;
        int outTime = 0;
        int[] in = new int[2];
        int[] out = new int[2];
        in = times[0];
        
//        int[] prev = times[0];
//        in = prev;
        
        for(int i = 1; i < times.length; i++) {
            int[] time = times[i];
            
//            System.out.printf("time: %d %d, in: %d %d\n", time[0], time[1], in[0], in[1]);
            
            if(in[1] < time[0]) {
                // 시간이 벌어짐
                out[0] = in[1];
                out[1] = time[0];
                
                inTime = (inTime < in[1]-in[0]) ? in[1]-in[0] : inTime;
                outTime = (outTime < out[1]-out[0]) ? out[1]-out[0] : outTime;
                
                in = time;
            } else if(time[0] <= in[1]) {
                // 시간이 겹침
                if(time[1] > in[1]) {
                    in[1] = time[1];
                }
            }
        }
        
        inTime = (inTime < in[1]-in[0]) ? in[1]-in[0] : inTime;
        
        System.out.printf("%d %d\n", inTime, outTime);
    }
}
