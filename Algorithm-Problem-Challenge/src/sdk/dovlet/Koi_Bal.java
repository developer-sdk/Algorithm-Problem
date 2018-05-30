package sdk.dovlet;

import java.util.Scanner;

public class Koi_Bal {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] array = new int[n+1][n+1];
		
		for(int i = 0; i < m; i++) {
			array[in.nextInt()][in.nextInt()] = 1;
		}
		in.close();
		
		// 테스트 데이터 
//		int n = 5;
//		int m = 8;
//		int[][] array = new int[n+1][n+1];
//		array[2][1] = 1;
//		array[3][4] = 1;
//		array[4][1] = 1;
//		array[2][4] = 1;
//		array[3][1] = 1;
//		array[3][2] = 1;
//		array[5][1] = 1;
//		array[5][2] = 1;
	
		// 배열 출력 
//		for(int[] a : array) {
//			for(int num : a ) 
//				System.out.printf("%d ", num);
//			
//			System.out.println();
//		}
		
		
		for(int i = 1; i < n+1; i++) {
			
			int[] visited = new int[n+1];
			
			int a = dfsDown(array, visited, i);
			int b = dfsUp(array, visited, i);
			int sum = a+b+1;
			int result = n - sum;
			
//			System.out.printf("%2d %2d %2d %2d", a, b, sum, result);
			System.out.println(result);
		}
	}
	
	// index 보다 작은, visited를 이용하여 이미 방문한 곳은 가지 않음 
	public static int dfsDown(int[][] array, int[] visited, int index) {
		
		int count = 0;
		
		for(int i = 1; i < array.length; i++) {
						
			if(array[index][i] == 1 && visited[i] == 0) {
				count++;				
				visited[i] = 1;
				count += dfsDown(array, visited, i);
			}
		}
		
		return count;
	}
	
	// index 보다 큰, visited를 이용하여 이미 방문한 곳은 가지 않음 
	public static int dfsUp(int[][] array, int[] visited, int index) {
		
		int count = 0;
		
		for(int i = 1; i < array.length; i++) {
						
			if(array[i][index] == 1 && visited[i] == 0) {
				count++;			
				visited[i] = 1;
				count += dfsUp(array, visited, i);
			}
		}
		
		return count;
	}
}
