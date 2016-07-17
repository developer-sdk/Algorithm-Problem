package sdk.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1662 {

	static int maxValue = 0;
	static int bishopN = 0;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] array = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				array[i][j] = in.nextInt();
				bishopN += array[i][j];
			}
		}
		in .close();
		
//		int n = 5;
//		bishopN = 13;
//		int[][] array = {	{ 1, 1, 0, 1, 1 }, 
//							{ 0, 1, 0, 0, 0 }, 
//							{ 1, 0, 1, 0, 1 }, 
//							{ 1, 0, 0, 0, 0 }, 
//							{ 1, 0, 1, 1, 1 }};
		
//		int n = 5;
//		bishopN = 0;
//		int[][] array = {	{ 0, 0, 0, 0, 0 }, 
//							{ 0, 0, 0, 0, 0 }, 
//							{ 0, 0, 0, 0, 0 }, 
//							{ 0, 0, 0, 0, 0 }, 
//							{ 0, 0, 0, 0, 0 }};
		
//		int n = 7;
//		bishopN = 34;
//		int[][] array = { 	{ 1, 0, 1, 1, 1, 0, 1 },
//							{ 0, 1, 1, 1, 1, 1, 1 },
//							{ 1, 1, 1, 1, 1, 1, 1 },
//							{ 1, 0, 1, 1, 1, 1, 1 },
//							{ 0, 1, 0, 0, 0, 1, 1 },
//							{ 0, 1, 1, 1, 1, 1, 1 },
//							{ 0, 0, 0, 0, 0, 0, 1 } };
		
		int[][] bishops = new int[bishopN][bishopN];
		
		int index = 0;
		for(int x = 0; x < n; x++) {
			for(int y = 0; y < n; y++ ) {
				if(array[x][y] == 1)
					bishops[index++] = new int[] { x, y };
			}
		}
		
		int[] mate = new int[bishopN];
		for(int i = 0; i < bishopN; i++) {
			Arrays.fill(mate, 0);
			mate[i] = 1;
			check(bishops, mate, 1, i);
		}
		
		System.out.println(maxValue);
	}
	
	public static void check(int[][] bishops, int[] mate, int count, int index) {
		
		if(count >= bishopN) {
			int sum = 0;
			for(int m : mate) {
				if(m == 1)
					sum++;
				System.out.printf("%2d ", m);
			}
				
			maxValue = (maxValue < sum) ? sum : maxValue;
			System.out.println(sum);
			return;
		}
		
		for(int i = 0; i < index; i++) {
			
			if(mate[i] == 0) {
				mate[i] = promising(bishops, mate, i) ? 1 : -1;
				check(bishops, mate, count+1, i);
			}
		}

		for(int i = index+1; i < mate.length; i++) {
			
			if(mate[i] == 0) {
				mate[i] = promising(bishops, mate, i) ? 1 : -1;
				check(bishops, mate, count+1, i);
			}
		} 
		
		
	}

	public static boolean promising(int[][] bishops, int[] mate, int index) {
		int x = bishops[index][0];
		int y = bishops[index][1];
		
		for(int i = 0; i < mate.length; i++) {
			if(index != i && mate[i] == 1) {
				int tX = bishops[i][0];
				int tY = bishops[i][1];
				
				if(Math.abs(x-tX) == Math.abs(y-tY)) {
					return false;
				}
			}
		}
		
		return true;
	}
}
