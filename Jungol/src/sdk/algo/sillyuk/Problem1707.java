package sdk.algo.sillyuk;

import java.util.Scanner;

/**
 * 정올, 1707 
 * 달팽이 사각형
 * 
 * @author ADMIN
 *
 */
public class Problem1707 {

    public static void main(String[] args) {
        
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.close();
        
        int n = 6;
        draw(n);
    }
    
    public static void draw(int n) {
        
        int[][] array = new int[n][n];
        
        int count = 1;        // 배열의 좌표에 입력되는 숫자
        int currentX = 0;    // 현재의 x 좌표
        int currentY = 0;    // 현재의 y 좌표
        int round = 0;        // 현재의 라운드
        
        // n*n 보다 count 가 커지면 종료
        while( count <= n*n ) {
            
            // 시작점은 라운드 회수와 
            currentX = round;
            currentY = round;
            
            // 오른쪽
            for(currentY = round; currentY < n-round; currentY++) {
                array[currentX][currentY] = count++;
            }
            
            currentY--;
            currentX++;
            
            // 아래
            for(; currentX < n-round; currentX++) {
                array[currentX][currentY] = count++;
            }
            
            currentX--;
            currentY--;
            
            // 왼쪽
            for(; currentY >= round; currentY--) {
                array[currentX][currentY] = count++;
            }
            
            currentX--;
            currentY++;
            
            // 위쪽
            for(; currentX >= round + 1; currentX--) {
                array[currentX][currentY] = count++;
            }
            
            round++;
        }
        
        
        for(int[] arr : array) {
            for(int a : arr) {
                System.out.printf("%2d ", a);
            }
            System.out.println();
        }
            
    }
}
