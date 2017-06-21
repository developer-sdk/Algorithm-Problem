package sdk.backjun.dp;

import java.util.Scanner;

/**
 * 백준, 10844, 쉬운 계단수, 다이나믹 프로그래밍  
 * 
 * @author whitebeardk
 *
 */
public class Problem10844 {

	static int MOD = 1000000000;
	static int N;	// 수의 길이 

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();

		int[][] memo = new int[N + 1][10];

		// 한자리 수를 입력 1~9까지 
		for (int i = 1; i < 10; i++)
			memo[1][i] = 1;

		for (int length = 2; length <= N; length++) {
			for (int number = 0; number <= 9; number++) {

				// 0, 9는 1, 8 하나씩만 가능 
				// 1~8은 -1, +1 숫자의 합 
				if (number == 0)
					memo[length][0] = (memo[length - 1][1]) % MOD;
				else if (number == 9)
					memo[length][9] = (memo[length - 1][8]) % MOD;
				else
					memo[length][number] = (memo[length - 1][number - 1] + memo[length - 1][number + 1]) % MOD;
			}
		}

		// 결과는 지정한 자릿수의 합 
		int result = 0;
		for (int i = 0; i <= 9; i++) {
			result = (result + memo[N][i]) % MOD;
		}

		System.out.println(result);
	}
}