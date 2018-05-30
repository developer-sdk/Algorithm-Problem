package sdk.jungol.dynamic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 정올, 다이나믹, 1408
 * 전봇대 
 * 
 * @author whitebeard-k
 *
 */
public class Problem1408 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] line = new int[n][2];

		for (int i = 0; i < n; i++) {
			line[i][0] = sc.nextInt();
			line[i][1] = sc.nextInt();
		}

		sc.close();

		// 입력받은 전봇대를 정렬한다. 
		Arrays.sort(line, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return (a[0] <= b[0]) ? -1 : 1;
			}
		});

		int[] dp = new int[n];
		int lis = 0;

		// 정렬된 전봇대들 말고, 정렬되지 않은 전봇대의 LIS 를 조사하여, 정렬되지 않은 전봇대의 최소길이를 확인한다. 
		for (int i = line.length - 1; i >= 0; i--) {

			int target = line[i][1];
			int max = 0;

			for (int k = i + 1; k < line.length; k++) {

				if (target < line[k][1]) {
					max = (max < dp[k]) ? dp[k] : max;
				}
			}

			dp[i] = max + 1;

			if (lis < dp[i])
				lis = dp[i];
		}

		System.out.println(n - lis);
	}
}