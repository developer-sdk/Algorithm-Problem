package sdk.backjun.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준, 11066
 * 파일합치기
 * 다이나믹 프로그래밍
 * 
 * @author whitebeard
 *
 */
public class Problem11066 {

	static int T;
	static int K;
	static int[] pages;
	static int[] sum;
	static int[][] memo;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		while (T-- > 0) {
			K = sc.nextInt();

			pages = new int[K + 1];
			sum = new int[K + 1];
			memo = new int[K + 1][K + 1];
			for (int[] arr : memo)
				Arrays.fill(arr, -1);

			for (int i = 1; i <= K; i++) {
				pages[i] = sc.nextInt();
				sum[i] = sum[i - 1] + pages[i];
			}

			int result = dp(1, K);
			System.out.println(result);
		}

		sc.close();
	}

	public static int dp(int start, int end) {

		if (start >= end)
			return 0;

		if (memo[start][end] != -1)
			return memo[start][end];

		if (end - start == 1)
			return pages[start] + pages[end];

		memo[start][end] = Integer.MAX_VALUE;

		for (int i = start; i <= end; i++) {
			int temp = dp(start, i) + dp(i + 1, end) + sum[end] - sum[start - 1];
			memo[start][end] = Math.min(memo[start][end], temp);
		}

		return memo[start][end];
	}
}
