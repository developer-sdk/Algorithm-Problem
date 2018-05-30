package sdk.jungol.dynamic;

import java.util.Scanner;

/**
 * 소형기관차
 * 
 * @author whitebeard
 *
 */
public class Problem1019 {

	static int N;
	static int K;
	static int[] trains;
	static int[] sums;
	static int[][] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		trains = new int[N + 1];
		sums = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			trains[i] = sc.nextInt();
			sums[i] = trains[i] + sums[i - 1];
		}

		K = sc.nextInt();
		sc.close();

		dp = new int[4][N + 1];

		// 끌수 있는 기차는 3대 
		for (int t = 1; t <= 3; t++) {
			for (int i = K * t; i <= N - (K * (3 - t)); i++) {

				int sumValue = (i - K > 0) ? sums[i] - sums[i - K] : sums[i];
				dp[t][i] = Math.max(dp[t][i - 1], dp[t - 1][i - K] + sumValue);
			}
		}

		System.out.println(dp[3][N]);
	}
}