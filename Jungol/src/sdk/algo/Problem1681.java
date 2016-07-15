package sdk.algo;

import java.util.Scanner;

/**
 * 
 * 1681, 해밀턴 순환회로
 * 
 * @author ADMIN
 *
 */
public class Problem1681 {

    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[][] array = new int[n][n];
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                array[i][j] = in.nextInt();
//            }
//        }
//        in.close();
        
        
        int n = 5;
        int[][] array = {    { 0, 14,  4, 10, 20 },
                            {14,  0,  7,  8,  7 },
                            { 4,  5,  0,  7, 16 },
                            {11,  7,  9,  0,  2 },
                            {18,  7, 17,  4,  0 }};
        
//        int n = 6;
//        int[][] array = {{ 0, 93, 23, 32, 39, 46 },
//                { 0, 0, 7, 58, 59, 13 },
//                { 40, 98, 0, 14, 33, 98 },
//                { 3, 39, 0, 0, 13, 16 },
//                { 51, 25, 19, 88, 0, 47 },
//                { 65, 81, 63, 0, 6, 0 } };
        
        int start = 0;
        int[] visited = new int[n];
        visited[start] = 1;
        
        // 최소값 확인 
        move(array, visited, start, start, 0, 1);
        
        // 이동 경로도 같이 확인 
        moveWithPath(array, visited, start, start, 0, 1, String.valueOf(start) + " ");
        
        System.out.println(min);
    }
    
    public static void move(int[][] array, int[] visited, int start, int location, int sum, int count) {
        
    	// 마지막 위치까지 도달 
        if(count == visited.length) {
        	// 다시 시작 위치로 돌아갈 수 있는지 확인 
            if(array[location][start] == 0)
                return;
            
            // 시작 위치로 돌아가는 값까지 추가해서 최소값 확인 
            sum += array[location][start];
            min = min < sum ? min : sum;
            return;
        }
        
        for(int i = 0; i < visited.length; i++) {
            
        	// 가지 않은 노드, 갈 수 있는 노드를 확인하여 이동 
            if(visited[i] == 0 && array[location][i] != 0) {
                visited[i] = 1;
                move(array, visited, start, i, sum + array[location][i], count + 1);
                visited[i] = 0;
            } 
        }
    }
    
    // 이동 경로까지 추가해서 확인 
    public static void moveWithPath(int[][] array, int[] visited, int start, int location, int sum, int count, String path) {
        
        if(count == visited.length) {
            if(array[location][start] == 0)
                return;
            
            sum += array[location][start];
            
            System.out.printf("%s : %d\n", path + String.valueOf(start), sum);
            
            min = min < sum ? min : sum;
            return;
        }
            
        
        for(int i = 0; i < visited.length; i++) {
            
            if(visited[i] == 0 && array[location][i] != 0) {
                visited[i] = 1;
                moveWithPath(array, visited, start, i, sum + array[location][i], count + 1, path + String.valueOf(i) + " ");
                visited[i] = 0;
            } 
        }
    }
}
