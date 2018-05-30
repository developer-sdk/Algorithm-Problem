package sdk.backjun.dp;

import java.util.Scanner;

/**
 * 백준, 다이나믹, 1149, RGB 거리 
 * 
 * @author whitebeard-k
 *
 */
public class Problem1149 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] costs = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int k = 0; k < 3; k++)
				costs[i][k] = sc.nextInt();
		}
		
		sc.close();

		// 0 : 빨강, 1 : 초록, 2 : 파랑 색으로 칠하는 값 
		int[][] dp = new int[N][3];
		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];

		for (int i = 1; i < N; i++) {

			for (int pivot = 0; pivot < 3; pivot++) {

				int min = Integer.MAX_VALUE;
				for (int k = 1; k <= 2; k++) {
					// 자기 말고 다른 색으로 칠할 수 있는 값중 최소값 
					min = Math.min(min, dp[i - 1][(pivot + k) % 3] + costs[i][pivot]);
				}

				dp[i][pivot] = min;
			}
		}

		int MIN_VALUE = Integer.MAX_VALUE;
		for (int pivot = 0; pivot < 3; pivot++)
			MIN_VALUE = Math.min(dp[N - 1][pivot], MIN_VALUE);

		System.out.println(MIN_VALUE);
	}
}
