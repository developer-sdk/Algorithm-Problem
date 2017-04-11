package sdk.algo.dynamic;

import java.util.Scanner;

/**
 * 정올, 다이나믹 프로그래맹, 1848
 * 
 * @author whitebeard-k
 *
 */
public class Problem1848 {

	// 메모이제이션을 위한 배열 
	public static int[][] memo = new int[50][2];

	public static void main(String[] args) {

		// int N = 40;
		// int staticSeatNum = 2;
		// int[] staticSeats = { 4, 7 };

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int staticSeatNum = sc.nextInt();
		int[] staticSeats = new int[staticSeatNum];
		for (int i = 0; i < staticSeatNum; i++) {
			staticSeats[i] = sc.nextInt();
		}
		sc.close();

		if (staticSeatNum == 0) {	// 고정 좌석의 개수가 0개 
			System.out.println(calc(N));
		} else if (staticSeatNum == 1) {	// 고정 좌석의 개수가 1개 

			int first = (staticSeats[0] - 1 <= 1) ? 1 : calc(staticSeats[0] - 1);
			int end = (staticSeats[staticSeatNum - 1] + 1 >= N) ? 1 : calc(N - staticSeats[staticSeatNum - 1]);

			System.out.println(first * end);
		} else {	// 고정 좌석이 2개 이상 
			int first = (staticSeats[0] - 1 <= 1) ? 1 : calc(staticSeats[0] - 1);
			int end = (staticSeats[staticSeatNum - 1] + 1 >= N) ? 1 : calc(N - staticSeats[staticSeatNum - 1]);

			int result = 1;
			int prev = staticSeats[staticSeatNum - 1];
			for (int i = staticSeatNum - 2; i >= 0; i--) {
				result *= calc(prev - staticSeats[i] - 1);
				prev = staticSeats[i];
			}

			System.out.println(first * result * end);
		}

	}

	public static int calc(int n) {

		if (n == 0)
			return 1;

		if (n == 1) {
			memo[n][0] = 1;	// 현재 번호로 끝나는 좌석 개수 
			memo[n][1] = 0;	// 현재 번호로 끝나지 않는 좌석 개수 
		} else if (n == 2) {
			memo[n][0] = 1;
			memo[n][1] = 1;
		} else if (memo[n][0] == 0) {

			if (memo[n - 1][0] == 0) {
				calc(n - 1);
			}

			memo[n][0] = (memo[n - 1][0] * 2) / 2 + memo[n - 1][1];
			memo[n][1] = (memo[n - 1][0] * 2) / 2;
		}

		return memo[n][0] + memo[n][1];
	}
}