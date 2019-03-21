package sdk.backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7576 {

	public static int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int TOMATO;
	public static int M; // 가로 칸수
	public static int N; // 세로 칸수
	public static int[][] map; // 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		Queue<Tomato> queue = new LinkedList<>();

		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());

			for (int y = 0; y < M; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());

				// 익은 토마토는 큐에 추가, 익지 않은 토마토는 총 개수를 세어줌 
				if (map[x][y] == 1) {
					queue.add(new Tomato(x, y));
				} else if (map[x][y] == 0) {
					TOMATO++;
				}
			}
		}

		int result = check(-1, queue);

		System.out.println(TOMATO == 0 ? result : -1);
	}

	public static int check(int day, Queue<Tomato> queue) {

		// 일단위로 처리를 위해 현재 큐의 사이즈 만큼 반복 
		int size = queue.size();

		if (size == 0)
			return day;

		while (size-- > 0) {

			Tomato current = queue.poll();

			for (int[] move : moves) {
				int nX = current.x + move[0];
				int nY = current.y + move[1];

				if (0 <= nX && nX < N && 0 <= nY && nY < M && map[nX][nY] == 0) {
					map[nX][nY] = 1;
					queue.add(new Tomato(nX, nY));
					TOMATO--;
				}
			}
		}

		return check(++day, queue);
	}

	static class Tomato {

		public int x;
		public int y;

		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
