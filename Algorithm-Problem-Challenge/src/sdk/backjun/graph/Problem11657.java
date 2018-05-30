package sdk.backjun.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준, 11657, 타임머신
 * 최단거리, 벨만포드 알고리즘 
 * 
 * @author whitebeardk
 *
 */
public class Problem11657 {

	static int N; // 도시의 개수
	static int M; // 버스의 노선 개수
	static int[][] maps; // 노선 정보
	static int[] dist; // 최소 거리 정보, 시작점에서의 거리

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		maps = new int[M][3];

		// 시작지점(1)에서 i 번째 위치로 가는 최단 거리 
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);	// 배열 초기화 
		dist[1] = 0;	// 시작 지점 처리 

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();

			maps[i][0] = from;
			maps[i][1] = to;
			maps[i][2] = cost;

			// 초기값 설정, 시작위치(1)에서 갈 수 있는 최단 경로 
			if (from == 1) {
				if (dist[to] > cost)
					dist[to] = cost;
			}
		}
		sc.close();

		boolean negative_cycle = false;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				int from = maps[j][0];
				int to = maps[j][1];
				int cost = maps[j][2];

				// from 으로 가는 경로가 있음 
				if (dist[from] != Integer.MAX_VALUE) {

					// 시작지점(1)에서 from을 거쳐 to로 가는 비용 
					int fromToCost = dist[from] + cost;
					if (dist[to] > fromToCost) {
						dist[to] = fromToCost;

						if (i == N - 1) {
							negative_cycle = true;
						}
					}
					
				}
				
				// 경로 출력 
//				System.out.printf("from: %2d to: %2d cost: %2d   ", from, to, cost);
//				for(int k = 1; k < dist.length; k++) {
//					System.out.printf("%2d ", dist[k]);
//				}
//				System.out.println();
			}
		}

		if (negative_cycle) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= N; i++) {
				System.out.printf("%d\n", dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
			}
		}
	}
}
