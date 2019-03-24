package sdk.backjun.dp;

import java.util.Scanner;

/**
 * 백준, 11726, 다이나믹 프로그래밍 
 * 2 X n 타일링 
 * @author seo
 *
 */
public class Problem11726 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		int result = dp(N);
		System.out.println(result);
	}

	public static int dp(int N) {

		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
		}

		return dp[N];
	}
}