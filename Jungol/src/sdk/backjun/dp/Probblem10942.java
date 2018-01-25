package sdk.backjun.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * DP 10942
 * 팰린드롬?
 * 
 * @author whitebeard-k
 *
 */
public class Probblem10942 {

	static int N;
	static int M;

	static int[] number;
	static int[][] memo;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		number = new int[N + 1];
		memo = new int[N + 1][N + 1];

		// memo 의 값을 -1로 초기화
		for (int[] arr : memo)
			Arrays.fill(arr, -1);

		// 팰린드롬 체크를 위한 초기값을 입력 받음
		for (int i = 1; i <= N; i++) {
			number[i] = sc.nextInt();
		}

		M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			// 값 체크
			int result = go(start, end);
			System.out.println(result);
		}

		sc.close();

		// System.out.println("====================================");
		//
		// for(int[] arr : memo) {
		// for(int n : arr) {
		// System.out.printf("%3d ", n);
		// }
		// System.out.println();
		// }
	}

	/**
	 * start 에서 end 까지가 팰린드롬인지 체크
	 * 
	 * @param start
	 * @param end
	 * @return 1: 팰린드롬, 0: 팰린드롬 아님
	 */
	public static int go(int start, int end) {

		// -1이 아니면 체크가 됨
		if (memo[start][end] == -1) {
			if (start == end) {
				memo[start][end] = 1;
			} else if (start + 1 == end) {
				memo[start][end] = (number[start] != number[end]) ? 0 : 1;
			} else if (number[start] != number[end]) {
				memo[start][end] = 0;
			} else if (number[start] == number[end]) {
				memo[start][end] = go(start + 1, end - 1);
			}
		}

		return memo[start][end];
	}
}