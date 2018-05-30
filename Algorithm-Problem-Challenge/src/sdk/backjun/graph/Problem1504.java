package sdk.backjun.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준, 1504, 특정한 최단 경로
 * 다익스트라 알고리즘 
 * 
 * @author whitebeard
 *
 */
public class Problem1504 {

	static int N;
	static int E;

	static long[] dist;
	static int[] check;
	static int[][] maps;

	static int M1;
	static int M2;

	static int INF = Integer.MAX_VALUE - 1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();

		maps = new int[N + 1][N + 1];
		dist = new long[N + 1];
		check = new int[N + 1];

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();

			if (maps[from][to] == 0) {
				maps[from][to] = cost;
			} else {
				maps[from][to] = Math.min(maps[from][to], cost);
			}

			if (maps[to][from] == 0) {
				maps[to][from] = cost;
			} else {
				maps[to][from] = Math.min(maps[to][from], cost);
			}

		}

		M1 = sc.nextInt();
		M2 = sc.nextInt();
		sc.close();

		// 두개의 중간지점중 최단거리를 알 수 없기 때문에 순서대로 2번 호출 
		long a1 = a(1, M1, M2, N);
		long a2 = a(1, M2, M1, N);

		if (a1 == -1 && a2 == -1) {
			System.out.println(-1);
		} else if (a1 == -1)
			System.out.println(a2);
		else if (a2 == -1)
			System.out.println(a1);
		else
			System.out.println(a1 <= a2 ? a1 : a2);
	}

	/**
	 * 중간지점을 입력 받아서 최단경로 구하기 
	 * 
	 * @param start
	 * @param m1
	 * @param m2
	 * @param end
	 * @return
	 */
	public static long a(int start, int m1, int m2, int end) {
		long a1 = d(1, m1);
		long a2 = d(m1, m2);
		long a3 = d(m2, N);

		return (a1 == INF || a2 == INF || a3 == INF) ? -1 : a1 + a2 + a3;
	}

	/**
	 * 다익스트라 알고리즘 
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static long d(int start, int end) {

		Arrays.fill(dist, INF);
		Arrays.fill(check, 0);

		dist[start] = 0;

		for (int i = 0; i < N; i++) {

			long min = Integer.MAX_VALUE;
			int from = 0;

			for (int k = 1; k <= N; k++) {

				if (check[k] == 0 && dist[k] < min) {
					min = dist[k];
					from = k;
				}
			}

			check[from] = 1;

			for (int to = 1; to <= N; to++) {
				if (maps[from][to] != 0) {
					if (dist[to] > dist[from] + maps[from][to]) {
						dist[to] = dist[from] + maps[from][to];
					}
				}
			}
		}

		return dist[end];
	}
}