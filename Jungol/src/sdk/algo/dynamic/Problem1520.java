package sdk.algo.dynamic;

import java.util.Scanner;

/**
 * 정올, 1520, 다이나믹
 * 계단오르기 
 * 
 * @author whitebeard-k
 *
 */
public class Problem1520 {

	public static void main(String[] args) {

		// int N = 6;
		// int[] steps = { 0, 10, 20, 15, 25, 10, 20 };

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] steps = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			steps[i] = sc.nextInt();
		}
		sc.close();

		// 연속해서 밟고 올라온 계단의 최대값을 표현 
		// memo[i][1] : 연속해서 밟은 계단이 하나, i-2 번째 계단의 값중 최대값과 현재 계단의 값을 더함 
		// memo[i][2] : 연속해서 밟은 계단이 두개, i-1 번째 계단의 memo[i-1][1]과 현재 계단의 값을 더함 
		int[][] memo = new int[N + 1][3];

		memo[1][1] = steps[1];

		for (int i = 2; i <= N; i++) {

			memo[i][1] = Math.max(memo[i - 2][1], memo[i - 2][2]) + steps[i];
			memo[i][2] = memo[i - 1][1] + steps[i];
		}

		System.out.println(Math.max(memo[N][1], memo[N][2]));
	}
}
