package sdk.algo.dynamic;

import java.util.Scanner;

/**
 * 정올, 다이나믹
 * 배낭채우기 
 * 
 * @author whitebeard
 *
 */
public class Problem1077 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int W = in.nextInt();
		int[][] array = new int[N][2];
		for (int i = 0; i < N; i++) {
			array[i][0] = in.nextInt();
			array[i][1] = in.nextInt();
		}
		in.close();

		// int N = 4;
		// int W = 14;
		// int[][] array = { { 2, 40 }, { 5, 110 }, { 10, 200 }, { 3, 50 } };

		int[] C = new int[W + 1];

		for (int i = 1; i < W + 1; i++) {

			int maxCost = 0;

			for (int j = 0; j < N; j++) {

				int weight = array[j][0];
				int value = array[j][1];

				if (i - weight >= 0 && C[i - weight] + value > maxCost) {
					maxCost = C[i - weight] + value;
				}
			}

			C[i] = maxCost;
		}

		System.out.println(C[W]);
	}
}
