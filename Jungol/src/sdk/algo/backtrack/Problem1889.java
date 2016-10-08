package sdk.algo.backtrack;

import java.util.Scanner;

/**
 * 
 * 정올, 1889
 * NQueen 문제
 * 
 * @author whitebeard
 *
 */
public class Problem1889 {

    static int count = 0;
    
    public static void main(String[] args) {
        
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.close();
        
        int n = 10;
        int[] array = new int[n];
        
        nqueen(array, 0);
        System.out.println(count);
    }
    
    public static void nqueen(int[] array, int location) {
        
    	// 배열의 길이와 일치하면 마지막까지 도달한 것 
        if(array.length == location) {
            printChess(array);
            count++;
            return;
        }
        
        for(int i = 0; i < array.length; i++) {
            array[location] = i;
            if(promising(array, location))
                nqueen(array, location+1);
        }
    }
    
    
    /**
     * 퀸이 배치될 수 있는지 확인
     * 
     * @param array
     * @param location
     * @return
     */
    public static boolean promising(int[] array, int location) {
        
        int curX = array[location];
        int curY = location;
        
        for(int i = 0; i < location; i++) {
            
            int sX = array[i];
            int sY = i;
            
            // 같은 열이면 안됨 
            if(sX == curX)
                return false;
            
            // 대각선 방향에 있으면 안됨 
            if(Math.abs(curX - sX) == Math.abs(curY - sY))
                return false;
        }
        
        return true;
    }
    
    public static void printChess(int[] array) {
        
        for(int i = 0; i < array.length; i++ ) {
            int q = array[i];
            
            for(int j = 0; j < array.length; j++) {
                System.out.printf("%s ", (j == q) ? "Q" : "-");
            }
            
            System.out.println();
        }
        
        System.out.println();
    }
}

