package sdk.backjun.dp;

import java.util.Scanner;

/**
 * 벡준, 9184 신나는 함수 실행
 * 
 * @author whitebeard-k
 *
 */
public class Problem9184 {

	static int A;
	static int B;
	static int C;

	static int[][][] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		dp = new int[21][21][21];

		while (true) {
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();

			if (A == -1 && B == -1 && C == -1)
				break;

			StringBuffer buffer = new StringBuffer();
			buffer.append("w(").append(A).append(", ").append(B).append(", ").append(C).append(") = ");
			
			if (A > 20)
				A = 20;
			if (B > 20)
				B = 20;
			if (C > 20)
				C = 20;

			if (A < 0)
				A = 0;
			if (B < 0)
				B = 0;
			if (C < 0)
				C = 0;

			int ans = w(A, B, C);
			System.out.printf("%s%d\n", buffer, ans);
		}

		sc.close();
	}

	public static int w(int a, int b, int c) {

		if (dp[a][b][c] == 0) {

			if (a <= 0 || b <= 0 || c <= 0) {
				return 1;
			} else if (a > 20 || b > 20 || c > 20) {
				return w(20, 20, 20);
			} else if (a < b && b < c) {
				dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
			}

			dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		}

		return dp[a][b][c];
	}
}