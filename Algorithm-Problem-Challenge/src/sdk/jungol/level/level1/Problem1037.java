package sdk.jungol.level.level1;

import java.util.Scanner;

public class Problem1037 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] array = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int k = 0; k < n; k++) {
				array[i][k] = in.nextInt();
			}
		}
		in.close();
		
//		int n = 4;
//		int[][] array = { 	{ 0, 0, 0, 0 },
//				  			{ 0, 0, 0, 0 },
//				  			{ 0, 0, 1, 0 },
//				  			{ 0, 0, 0, 0 } };
		
		boolean isParitty = checkParitty(array);
		
		if(isParitty) {
			System.out.println("OK");
		} else {
			changeParitty(array);
		}
	}
	
	public static void changeParitty(int[][] array) {
		
		int[] col = new int[array.length];
		int[] row = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				row[i] += array[i][j];
				col[i] += array[j][i];
			}
		}
		
		int cols = getOddIndex(col); 
		int rows = getOddIndex(row);
		
		if(cols != -1 && rows != -1) {
			System.out.printf("Change bit (%d,%d)", rows+1, cols+1);
		} else {
			System.out.println("Corrupt");
		}
		
	}
	
	public static int getOddIndex(int[] array) {
		
		int count = 0;
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] % 2 != 0) {
				count++;
				index = i;
			}
		}
		
		if(count >= 2) {
			return -1;
		}
		
		return index;
	}
	
	public static boolean checkParitty(int[][] array) {
		
		int sumRow = 0; 
		int sumCol = 0;
		
		for(int i = 0; i < array.length ; i++) {
			for(int k = 0; k < array[i].length; k++) {
				sumRow += array[i][k];
				sumCol += array[k][i];
			}
			
			if(sumRow%2 == 1 || sumCol%2 == 1)
				return false;
		}
		
		return true;
	}
}
