package sdk.algo.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 정올, 1078문제
 * 저글링 방사능 오염 
 * 
 * @author whitebeard
 *
 */
public class Problem1078 {

    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        int x = in.nextInt();
        int[][] array = new int[x][y];
        for(int i = 0; i < x; i++) {
            String str = in.next();
            char[] chs = str.toCharArray();
            
            for(int j = 0; j < chs.length; j++) {
                array[i][j] = Character.getNumericValue(chs[j]);
            }
        }
        
        
//        for(int i = 0; i < x; i++) {
//            for(int j =0; j < y; j++) {
//                
//                array[i][j] = in.nextInt();
//            }
//        }
        int rY = in.nextInt() - 1;
        int rX = in.nextInt() - 1;
        in.close();
        
//        int x = 8;
//        int y = 7;
//        int[][] array = {    { 0, 0, 1, 0, 0, 0, 0 },
//                            { 0, 0, 1, 1, 0, 0, 0 },
//                            { 0, 0, 0, 1, 1, 0, 0 },
//                            { 1, 0, 1, 1, 1, 1, 1 },
//                            { 1, 1, 1, 1, 0, 1, 1 },
//                            { 0, 0, 1, 1, 1, 0, 0 },
//                            { 0, 0, 1, 1, 1, 0, 0 },
//                            { 0, 0, 0, 1, 0, 0, 0 }};
//        
//        int rX = 5-1;
//        int rY = 3-1;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        
        array[rX][rY] = 0;
        queue.add(new int[] { rX, rY, 3 });
        
        bfs(array, queue);
        
        System.out.println(max);
        
        int sum = 0;
        for(int[] aa : array)
            for(int zz : aa) 
                sum += zz;
        
        System.out.println(sum);
    }
    
    public static void bfs(int[][] array, Queue<int[]> queue) {
        
        int size = queue.size();
        
        if(size == 0) 
            return;
        
        while(size-- > 0) {
            
            int[] location = queue.poll();
            int x = location[0];
            int y = location[1];
            int count = location[2];
            
            max = max < count ? count : max;
            
            if(x-1 > -1 && array[x-1][y] == 1) {
                array[x-1][y] = 0;
                queue.add(new int[] { x-1, y, count+1});
            }
                
            
            if(x+1 < array.length && array[x+1][y] == 1){
                array[x+1][y] = 0;
                queue.add(new int[] { x+1, y, count+1});
            }
                
            
            if(y-1 > -1 && array[x][y-1] == 1) {
                array[x][y-1] = 0;
                queue.add(new int[] { x, y-1, count+1});
            }
                
            
            if(y+1 < array[0].length && array[x][y+1] == 1) {
                array[x][y+1] = 0;
                queue.add(new int[] { x, y+1, count+1});
            }
                
        }
        
        bfs(array, queue);
    }
}