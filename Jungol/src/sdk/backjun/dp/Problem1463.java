package sdk.backjun.dp;

import java.util.Scanner;

public class Problem1463 {
	static int[] d = new int[100];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		int result = one(N);

		System.out.println(result);
	}

	public static int one(int N) {

		int[] dp = new int[N + 1];
		dp[1] = 0;

		for (int i = 2; i <= N; i++) {
			
			// i-1 번째에 1을 더하는 경우
			dp[i] = dp[i - 1] + 1;
			
			// i%2 == 0인 경우에서 1을 더하는 경우
			if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
				dp[i] = dp[i / 2] + 1;
			}

			// i%3 == 0인 경우에서 1을 더하는 경우
			if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
				dp[i] = dp[i / 3] + 1;
			}
		}

		return dp[N];
	}
}
