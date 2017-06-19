package sdk.backjun.dp;

import java.util.Scanner;

/**
 * 백준, 2156, 포도주 시식
 * 다이나믹 프로그래밍 
 * 
 * @author whitebeard-k
 *
 */
public class Problem2156 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] wine = new int[n + 1];
		for (int i = 1; i <= n; i++)
			wine[i] = sc.nextInt();
		sc.close();

		long[][] dp = new long[n + 1][4];
		dp[1][1] = wine[1];
		long maxValue = wine[1];

		for (int i = 2; i <= n; i++) {
			dp[i][1] = dp[i - 1][3] + wine[i];	// 한잔을 마시는 경우 
			dp[i][2] = dp[i - 1][1] + wine[i];	// 두잔을 연속으로 마시는 경우 
			dp[i][3] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]);	// 마시지 않는 경우 

			maxValue = Math.max(Math.max(Math.max(dp[i][1], dp[i][2]), dp[i][3]), maxValue);
		}

//		for (int i = 1; i <= 3; i++) {
//			for (int k = 1; k <= n; k++) {
//				System.out.printf("%6d", dp[k][i]);
//			}
//			System.out.println();
//		}

		System.out.println(maxValue);
	}			
}
