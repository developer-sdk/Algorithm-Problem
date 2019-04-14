package sdk.backjun.samsung;

import java.util.Scanner;

public class Problem13460 {

	public static int N;	// 세로 
	public static int M;	// 가로 
	
	public static int[][] map;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) {
				map[x][y] = sc.nextInt();
			}
		}
	}
}
