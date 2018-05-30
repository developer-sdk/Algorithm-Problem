package sdk.backjun.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준, 1520, 내리막길 
 * https://www.acmicpc.net/problem/1520
 * 
 * @author whitebeardk
 *
 */
public class Problem1520 {

	static int N;
	static int M;
	static int[][] moves = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		int[][] maps = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				maps[i][j] = sc.nextInt();
			}
		}
		sc.close();

		// 방문한곳 처리를 위해 -1로 초기화
		int[][] dp = new int[M][N];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		// 종료지점 확인
		dp[M - 1][N - 1] = 1;

		findWay(maps, dp, 0, 0);

		System.out.println(dp[0][0]);

		// 경로 확인 
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%6d ", dp[i][j]);
			}
			System.out.println();
		}
	}

	public static int findWay(int[][] maps, int[][] dp, int x, int y) {

		// 종점 도달
		if (x == M - 1 && y == N - 1)
			return 1;

		// 이미 처리한 곳
		if (dp[x][y] >= 1 || dp[x][y] == 0)
			return dp[x][y];

		// 방문 처리
		if (dp[x][y] == -1) {
			dp[x][y] = 0;
		}

		for (int i = 0; i < moves.length; i++) {

			int nextX = x + moves[i][0];
			int nextY = y + moves[i][1];

			if (0 <= nextX && nextX < maps.length && 0 <= nextY && nextY < maps[0].length && maps[x][y] > maps[nextX][nextY]) {
				dp[x][y] += findWay(maps, dp, nextX, nextY);
			}
		}

		return dp[x][y];
	}
}
