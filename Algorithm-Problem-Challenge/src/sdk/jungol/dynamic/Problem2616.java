package sdk.jungol.dynamic;

import java.util.Scanner;

/**
 * 정올, 2616, 앱
 * 다이나믹 프로그래밍 
 * 
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1878&sca=3050
 * 
 * @author whitebeard-k
 *
 */
public class Problem2616 {
	static int N;
	static int M;
	static int totalValue;
	static int[][] apps;
	static int MIN;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		apps = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			apps[i][0] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			apps[i][1] = sc.nextInt();
			totalValue += apps[i][1];
		}
		sc.close();

		int[] D = new int[totalValue + 1];

		// i 번재 앱을 비활성화시
		for (int i = 1; i <= N; i++) {

			// j 비용으로 얻을수 있는 최대 메모리
			for (int value = totalValue; value >= 1; value--) {

				if (value - apps[i][1] >= 0) {
					D[value] = Math.max(D[value], D[value - apps[i][1]] + apps[i][0]);
				}

				if (i == N && D[value] >= M) {
					// 뒤에서 부터 채워오니 가장 마지막에 채운값이
					// 답이된다.
					MIN = value;
				}
			}
		}

		System.out.println(MIN);
	}
}
