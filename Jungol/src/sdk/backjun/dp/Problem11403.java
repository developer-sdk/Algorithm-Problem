package sdk.backjun.dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준, 11403
 * 경로 찾기 
 * 
 * @author whitebeard
 *
 */
public class Problem11403 {

	static int N; // 정점의 개수
	static int[][] maps;
	static int[][] result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		maps = new int[N + 1][N + 1];
		result = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				maps[i][j] = sc.nextInt();
			}
		}

		sc.close();

		for (int from = 1; from <= N; from++) {
			for (int to = 1; to <= N; to++) {
				int[] visited = new int[N + 1]; // 방문여부 확인

				Queue<Integer> queue = new LinkedList<>(); // bfs 큐
				queue.add(from);
				visited[from] = 1;

				bfs: while (!queue.isEmpty()) {
					int next = queue.poll();

					for (int i = 1; i <= N; i++) {
						if (visited[i] == 0) {
							// 현재위치에서 목표지점으로 이동 가능 ||
							// 다음 이동가능 위치에서 다음에 목표지점 이동가능(visited로 인해 자신에게 도달하지 못하는 경우)
							if ((i == to && maps[next][i] == 1) || maps[next][i] == 1 && maps[i][to] == 1) {
								result[from][to] = 1;
								visited[to] = 1;
								break bfs;
							}

							if (maps[next][i] == 1) {
								queue.add(i);
								visited[i] = 1;
							}
						}
					}
				}
			}
		}

		for (int from = 1; from <= N; from++) {
			for (int to = 1; to <= N; to++) {
				System.out.printf("%d ", result[from][to]);
			}
			System.out.println();
		}
	}
}
