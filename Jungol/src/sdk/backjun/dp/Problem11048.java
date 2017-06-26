package sdk.backjun.dp;

import java.util.Scanner;

/**
 * 백준, 11048, 이동하기
 * 다이나믹 프로그래밍 
 * 
 * @author whitebeardk
 *
 */
public class Problem11048 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 미로의 크기 N
		int M = sc.nextInt();	// 미로의 크기 M
		
		int[][] maps = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= M; y++) {
				maps[x][y] = sc.nextInt();
			}
		}
		
		sc.close();
		
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= M; y++) {
				// 좌측, 상단의 DP값 중 더 큰값에 현재의 사탕개수를 더하여 DP값에 저장 
				dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]) + maps[x][y];
			}
		}
		
		System.out.println(dp[N][M]);
	}
}
