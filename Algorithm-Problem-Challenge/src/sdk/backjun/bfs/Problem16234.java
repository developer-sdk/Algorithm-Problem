package sdk.backjun.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준, 16234
 * 인구이동 
 * 
 * @author whitebeard-k
 *
 */
public class Problem16234 {

	public static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public static int N; // 땅의 크기
	public static int L; // L명 이상
	public static int R; // R명 이하

	public static int[][] map;
	public static boolean[][] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();

		map = new int[N][N];
		

		for (int x = 0; x < N; x++)
			for (int y = 0; y < N; y++)
				map[x][y] = sc.nextInt();

		sc.close();

		int count = 0;
		while (true) {

			boolean hasNext = false;
			visited = new boolean[N][N];

			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {

					// 방문여부, 연합의 개수를 확인하여 이번 턴에 연합이 있는지 확인 
					if (!visited[x][y] && check(x, y) > 1) {
						hasNext = true;
					}
				}
			}

			if (hasNext) {
				count++;
			} else {
				break;
			}
		}

		System.out.println(count);
	}

	// 연합 확인 
	public static int check(int startX, int startY) {

		LinkedList<Nation> allies = new LinkedList<>();
		Queue<Nation> queue = new LinkedList<>();
		Nation start = new Nation(startX, startY);
		queue.add(start);
		allies.add(start);
		visited[startX][startY] = true;
		int sum = map[startX][startY];
		
		while (!queue.isEmpty()) {

			Nation current = queue.poll();

			for (int[] move : moves) {
				int nextX = current.x + move[0];
				int nextY = current.y + move[1];

				if (isMoveable(current, nextX, nextY)) {
					Nation next = new Nation(nextX, nextY);
					queue.add(next);
					allies.add(next);
					sum += map[nextX][nextY];
					visited[nextX][nextY] = true;
				}
			}
		}

		// 연합이 있으면 연합의 인구수 변경 
		if (allies.size() != 1) {
			int result = sum / allies.size();

			for (Nation ally : allies) {
				map[ally.x][ally.y] = result;
			}
		}

		// 연합이 없으면 1반환 
		return allies.size();
	}

	// 이동 가능 여부 확인 
	private static boolean isMoveable(Nation current, int nextX, int nextY) {

		if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !visited[nextX][nextY]) {

			// 인구수의 차이 확인 
			int abs = Math.abs(map[current.x][current.y] - map[nextX][nextY]);

			if (L <= abs && abs <= R)
				return true;
		}

		return false;
	}

	static class Nation {
		public int x;
		public int y;

		public Nation(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}