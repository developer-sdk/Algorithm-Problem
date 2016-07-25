package sdk.algo;

import java.util.Scanner;

/**
 * 
 * 2194, 요플레 공장 
 * 주차에 따른 보관비용을 추가해서 계산하여 최소 비용이 현재 주차의 최소값이 된다. 
 * 
 * @author whitebeard
 * @since 2016.07.25
 */
public class Problem2194 {
 
    public static void main(String[] args) {
         
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int[][] array = new int[n][2];
        for(int i = 0; i < n; i++) {
            array[i][0] = in.nextInt();
            array[i][1] = in.nextInt();
        }
        in.close();
         
//      // 운영할 주
//      int n = 4;
//      // 1리터당 보관 비용
//      int s = 5;
//      
//      int[][] array = {   { 88, 200 },
//                          { 89, 400 },
//                          { 97, 300 },
//                          { 91, 500 } };
         
//      int n = 10000;
//      int s = 50;
//      
//      int[][] array = new int[n][2];
//      for(int i = 0; i < n; i++) {
//          array[i][0] = 2345;
//          array[i][1] = 10000;
//      }
         
        // 최소 비용 
        long sum = 0;
        // 주차 카운ㅌ 
        long count = 0;
        for(int i = 0; i < n; i++) {
             
            long min = Long.MAX_VALUE;
            for(int j = 0; j <= i; j++) {
                 
            	// 비용에 주차에 따른 보관 비용을 추가해서 계산한다. 
                long result = (((count-j)*s) + array[j][0]) * array[i][1];
                min = (min < result) ? min : result;
            }
             
            sum += min;
            count++;
        }
         
        System.out.println(sum);
    }
}