package sdk.backjun.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준, 14500
 * 테트로미노 
 * 
 * @author whitebeard-k
 *
 */
public class Problem14500 {

	public static int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// ㅗ, ㅜ, ㅏ, ㅓ 모양의 이동 방향 설정 
	public static int[][][] exceptions = { { { 1, 0 }, { 2, 0 }, { 1, -1 } }, 
			                                { { 1, 0 }, { 2, 0 }, { 1, 1 } },
			                                { { 0, 1 }, { 0, 2 }, { -1, 1 } }, 
			                                { { 0, 1 }, { 0, 2 }, { 1, 1 } } };

	public static int N; // 가로
	public static int M; // 세로
	public static int[][] map;
	public static boolean[][] visited;

	public static int MAX_SUM = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(reader.readLine());
			for (int y = 0; y < M; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
			}
		}

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				dfs(x, y, 0, 0);
				exception(x, y);
			}
		}

		System.out.println(MAX_SUM);
	}

	// 예외적 모양, ㅗ, ㅜ, ㅏ, ㅓ
	public static void exception(int x, int y) {

		for (int[][] moves : exceptions) {

			int sum = map[x][y];
			boolean isValid = true;

			for (int[] move : moves) {

				int nextX = move[0] + x;
				int nextY = move[1] + y;

				if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
					sum += map[nextX][nextY];
				} else {
					isValid = false;
					break;
				}
			}

			if (isValid)
				MAX_SUM = Math.max(MAX_SUM, sum);
		}
	}

	// 나머지 모양은 상하 좌우로 4번 DFS로 이동하면 형성 가능함 
	public static void dfs(int x, int y, int sum, int depth) {

		if (depth == 4) {
			MAX_SUM = Math.max(MAX_SUM, sum);
			return;
		}

		visited[x][y] = true;

		for (int[] move : moves) {
			int nextX = move[0] + x;
			int nextY = move[1] + y;

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && !visited[nextX][nextY]) {

				visited[nextX][nextY] = true;
				dfs(nextX, nextY, sum + map[x][y], depth + 1);
				visited[nextX][nextY] = false;
			}
		}

		visited[x][y] = false;
	}
}
