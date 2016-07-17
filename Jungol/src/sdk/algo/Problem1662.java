package sdk.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1662 {

	static int maxValue = 0;
	
	public static void main(String[] args) {
		
		int sumMax = 0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] array = new int[n][n];
		for(int i = 0; i < n; i++) {
			int temp = 0;
			for(int j = 0; j < n; j++) {
				array[i][j] = in.nextInt();
				temp += array[i][j]; 
			}
			sumMax = (sumMax < temp) ? temp : sumMax;
		}
		in.close();
		
//		int n = 5;
//		int[][] array = {	{ 1, 1, 0, 1, 1 }, 
//							{ 0, 1, 0, 0, 0 }, 
//							{ 1, 0, 1, 0, 1 }, 
//							{ 1, 0, 0, 0, 0 }, 
//							{ 1, 0, 1, 1, 1 }};
//		sumMax = 4;
		
		for(int x = 0; x < n; x++) {
			int sum = 0;
			for(int y = 0; y < n; y++) {
				sum += array[x][y];
			}
			
			if(sum == sumMax) {
				
				int result = check(array, x, sum);
				maxValue = maxValue < result ? result : maxValue;
//				System.out.println("------------");
//				for(int[] xx : array){
//					for(int yy : xx) {
//						System.out.printf("%d ", yy);
//					}
//					System.out.println();
//				}
				
				for(int i = 0; i < n; i++)
					for(int j = 0; j <n ; j++)
						if(array[i][j] == 9) array[i][j] = 1;
			}
		}
		
		
		
		System.out.println(maxValue);
	}
	
	public static int check(int[][] array, int pivotX, int count) {
		
		for(int x = 0; x < array.length; x++) {
			if(x == pivotX)
				continue;
			
			for(int y = 0; y < array.length; y++) {
				
				if(array[x][y] == 1 && promising(array, pivotX, x, y)) {
					array[x][y] = 9;
					count++;
				}
					
			}
		}
		
		return count;
	}

	public static boolean promising(int[][] array, int pivotX, int x, int y) {
		
		for(int pivotY = 0; pivotY < array.length; pivotY++) {
			if(array[pivotX][pivotY] == 1 && Math.abs(x-pivotX) == Math.abs(y-pivotY)) {
				return false;
			}
		}
		
		for(int i = 0; i < array.length; i++) {
			if(i == pivotX)
				continue;
			
			for(int j = 0; j < array.length; j++) {
				if(array[i][j] == 9 && Math.abs(x-i) == Math.abs(y-j)) {
					return false;
				}
			}
		}
		
		return true;
	}
}
