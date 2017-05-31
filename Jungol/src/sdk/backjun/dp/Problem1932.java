package sdk.backjun.dp;

import java.util.Scanner;

/**
 * 백준, 1932, 숫자 삼각형 
 * 
 * @author whitebeard
 *
 */
public class Problem1932 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] triangle = new int[n + 1][n + 1];
		int MAX = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {

			// 삼각형값을 입력받음 
			for (int k = 1; k <= i; k++) {
				triangle[i][k] = sc.nextInt();
			}

			// 상단, 좌상의 값을 더한 값중 더 큰값을 입력하고, 현라인의 가장 큰값을 MAX에 입력 
			for (int k = 1; k <= i; k++) {
				triangle[i][k] = Math.max(triangle[i][k] + triangle[i - 1][k], triangle[i][k] + triangle[i - 1][k - 1]);
				MAX = Math.max(MAX, triangle[i][k]);
			}
		}

		System.out.println(MAX);
		sc.close();
	}
}
