package sdk.jungol.sillyuk;

import java.util.Scanner;

/**
 * 1495, 대각선 지그재그
 * 
 * @author whitebeard
 *
 */
public class Problem1495 {
	public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        
//      int n = 5;
         
        int[][] array = new int[n][n];
        
        // 배열에 입력할 증가값 
        int count = 1;
         
        // 배열의 현재 위치 
        int currentX = 0;
        int currentY = 0;
        
        // 0, 0 위치를 1로 초기화 
        array[currentX][currentY] = count++;
         
        while(count <= n*n) {
             
        	// x가 n보다 작은 동안은 x 증가, 이후에는 y 증가 
            if(currentX + 1 < n) {
                currentX++;
            } else {
                currentY++;
            }
             
            array[currentX][currentY] = count++;
            
            // 우상향으로 이동 
            while(currentX - 1 > -1 && currentY + 1 < n) {                
                array[--currentX][++currentY] = count++;
            }
             
            // y가 n 보다 작은 동안은 y 증가, 이후에는 x증가  
            if(currentY + 1 < n) {
                currentY++;
            } else {
                currentX++;
            }
             
            array[currentX][currentY] = count++;
             
            // 좌하향으로 이동 
            while(currentY - 1 > -1 && currentX + 1 < n) {
                array[++currentX][--currentY] = count++;
            }
        }
         
        // 결과 출력 
        for(int[] xx : array) {
            for(int nn : xx) {
                System.out.printf("%d ", nn);
            }
             
            System.out.println();
        }
    }
}
