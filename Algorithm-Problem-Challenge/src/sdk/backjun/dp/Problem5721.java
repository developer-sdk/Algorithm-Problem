package sdk.backjun.dp;

import java.util.Scanner;

/**
 * 백준, 5721, 사탕줍기
 * 
 * @author whitebeard-k
 *
 */
public class Problem5721 {

	static int M;
	static int N;
	static int[] nums;
	static int[] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			M = sc.nextInt();
			N = sc.nextInt();

			if (M == 0 && N == 0)
				break;

			dp = new int[M + 1];

			for (int i = 1; i <= M; i++) {

				nums = new int[N + 1];

				// y축에 대한 선택 
				for (int j = 1; j <= N; j++) {

					nums[j] = sc.nextInt();

					if (j >= 2) {
						// j-2에 대한 값의 선택과, j-1에 대한 값의 선택중 큰 값을 저장 
						nums[j] = Math.max(nums[j - 2] + nums[j], nums[j - 1]);
					}
				}

				dp[i] = nums[N];

				// x축에 대한 선택 
				if (i >= 2) {
					// y축의 최대값 중 i-2의 값의 선택과 i-1의 값의 선택을 저장 
					dp[i] = Math.max(dp[i - 2] + dp[i], dp[i - 1]);
				}
			}

			System.out.println(dp[M]);
		}

		sc.close();
	}
}
