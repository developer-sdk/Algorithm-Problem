package sdk.jungol.dynamic;

import java.util.Scanner;

/**
 * 정올, 1407, 다이나믹
 * 숫자카드
 * 
 * @author whitebeard-k
 *
 */
public class Problem1407 {

	// [i][0] : 마지막이 한자리인 수 ex) 1, 2, 3
	// [i][1] : 마지막이 두자리인 수 ex) 1, 23
	public static int[][] memo = new int[40][2];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();

		// String input = "7145910388927205891";
		// String input = "146902336";

		int result = 1;
		int prev = 0;
		
		for (int i = 1; i < input.length(); i++) {
			// 2자리씩 때서 계
			int temp = Integer.parseInt(input.substring(i - 1, i + 1));

			// 10의 배수 이며 40 이상일때는 카드로 표현 불가이므로 종료
			if (temp % 10 == 0 && temp / 10 > 4) {
				System.out.println(0);
				System.exit(0);
			}

			// 35 이상이면 분리 
			if (temp >= 35) {
				result *= calc(i - prev);
				prev = i;
			} else if (temp < 10) {
				prev = i;
			}
		}

		result *= calc(input.length() - prev);

		System.out.println(result);
	}

	public static int calc(int n) {
		if (n == 0 || n % 10 == 0)
			return 1;

		if (n == 1) {
			memo[n][0] = 1;
			memo[n][1] = 0;
		} else if (n == 2) {
			memo[n][0] = 1;
			memo[n][1] = 1;
		} else if (memo[n][0] == 0) {

			// 이전 결과가 없으면 계산 
			if (memo[n - 1][0] == 0) {
				calc(n - 1);
			}

			// 현재값 계산 
			memo[n][0] = (memo[n - 1][0] * 2) / 2 + memo[n - 1][1];
			memo[n][1] = (memo[n - 1][0] * 2) / 2;
		}

		return memo[n][0] + memo[n][1];
	}
}
