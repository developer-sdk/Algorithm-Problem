package sdk.jungol.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 정올, 소시지공장, 그리디,  1669
 * 
 * 소시지의 길이 기준으로 오름차순정렬  
 * 너비 순서대로 오름차순으로 작업진행 
 * 
 * @author whitebeard
 * @since 2016.07.07
 */
public class Problem1669 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] array = new int[n][2];
        for(int i = 0; i < n; i++) {
            array[i][0] = in.nextInt();
            array[i][1] = in.nextInt();
        }
        in.close();
        
//        int n = 5;
//        int[][] array = {     { 4, 9 }, 
//                            { 5, 2 }, 
//                            { 2, 1 }, 
//                            { 3, 5 }, 
//                            { 1, 4 } };
        
//        int n = 3;
//        int[][] array = {     { 1, 3 }, 
//                            { 2, 2 }, 
//                            { 3, 1 } };
        
//        int n = 50;
//        int[][] array = { { 5436,  7946 },
//                { 1350,  3080 },
//                { 6245,  3855 },
//                { 3909,  5194 },
//                { 1257,  4648 },
//                { 3688,  5327 },
//                { 6101,  5645 },
//                { 5921,  1493 },
//                { 5758,  6463 },
//                { 4909,  1696 },
//                { 4405,  7934 },
//                { 3528,  4635 },
//                { 2079,  471 },
//                { 1088,  281 },
//                { 1258,  7404 },
//                { 1610,  3838 },
//                { 2362,  5294 },
//                { 6553,  3472 },
//                { 2415,  7632 },
//                { 3596,  3776 },
//                { 3074,  4059 },
//                { 6481,  6051 },
//                { 2482,  705 },
//                { 6486,  2352},
//                { 2082,  6662 },
//                { 3236,  4270 },
//                { 854 , 4917 },
//                { 985 , 6312 },
//                { 4291,  4248 },
//                { 4638,  4670 },
//                { 6395,  7345 },
//                { 7176,  2863 },
//                { 5249,  5926 },
//                { 5491,  5346 },
//                { 2646,  6287 },
//                { 4743,  375 },
//                { 2373,  5077 },
//                { 4748,  5972 },
//                { 3862,  6803 },
//                { 6494,  3737 },
//                { 3378,  6192 },
//                { 7388,  7894 },
//                { 6386,  3634 },
//                { 1759,  7732 },
//                { 7394,  5450 },
//                { 866 , 712 },
//                { 4294,  2344 },
//                { 4906,  7958 },
//                { 4789,  4410 },
//                { 7904,  4556 } };

        // 소시지 길이 기준으로 오름차순 정렬 
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] <= b[0] ? -1 : 1;
            }
        });
        
        for(int[] a : array)
            System.out.printf("%5d %5d\n", a[0], a[1]);
        
        int start = -1;
        int count = 0;
        int[] visited = new int[n];
        
        while(true) {
            // 1. 너비 기준으로 작업안한 데이터 선택 
        	for(int i = 0; i < visited.length; i++) {
                if(visited[i] == 0) {
                    start = i;
                    break;
                }
            }
            
            if(start == -1)
                break;
            
            // 2. 너비 순서대로 작업안한 첫번째 데이터 선택 
            int[] prev = array[start];
            visited[start] = 1;
            
            for(int i = start+1; i < visited.length; i++) {
                
            	// 이미 작업한 곳은 처리 안함 
                if(visited[i] == 1)
                    continue;
                
                // 이전작업보다 너비가 크면 그냥 진행, 
                // 작으면 작업했다고 표시(visited에 표시)
                if(prev[1] > array[i][1]) {
                    continue;
                } else {
                    visited[i] = 1;
                    prev = array[i];
                }
            }
            
            count++;
            start = -1;
        }
        
        System.out.println(count);
    }
}
