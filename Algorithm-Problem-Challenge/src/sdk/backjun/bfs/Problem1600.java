package sdk.backjun.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 말이 되고픈 원숭이
 * 
 * @author User
 *
 */
public class Problem1600 {

	static int[][] moveMonkey = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] moveHorse = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 },
			{ -2, 1 } };

	static int K; // 말이 되어 움직인 횟수
	static int W; // 가로, y
	static int H; // 세로, x
	static int[][] map;
	static int[][][] min;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();

		map = new int[H][W];
		min = new int[K + 1][H][W];

		for (int x = 0; x < H; x++) {
			for (int y = 0; y < W; y++) {
				map[x][y] = sc.nextInt();

				for (int k = 0; k < K + 1; k++) {
					min[k][x][y] = Integer.MAX_VALUE;
				}
			}
		}

		sc.close();

		Monkey start = new Monkey(0, 0, 0, 0);
		int result = move(start);

		System.out.println(result);
	}

	// 원숭이 움직임 
	public static int move(Monkey start) {

		Queue<Monkey> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {

			Monkey current = queue.poll();

			// 원숭이 움직임 
			moveMonkey(current, queue);

			// 말로 움직일 횟수가 남아있으면 
			if (current.k < K)
				moveHorse(current, queue);
		}

		return min();
	}

	// 최저 이동 횟수 확인 
	private static int min() {
		int result = Integer.MAX_VALUE;
		for (int k = 0; k < K + 1; k++) {
			result = Math.min(result, min[k][H - 1][W - 1]);
		}

		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private static void moveHorse(Monkey current, Queue<Monkey> queue) {
		move(current, moveHorse, current.k + 1, queue);
	}

	private static void moveMonkey(Monkey current, Queue<Monkey> queue) {
		move(current, moveMonkey, current.k, queue);
	}

	private static void move(Monkey current, int[][] moveArr, int nextK, Queue<Monkey> queue) {
		for (int[] move : moveArr) {
			int nextX = current.x + move[0];
			int nextY = current.y + move[1];
			int nextCount = current.c + 1;

			if (isMoveable(nextX, nextY, nextK, nextCount)) {
				queue.add(new Monkey(nextX, nextY, nextK, nextCount));
				min[nextK][nextX][nextY] = nextCount;
			}
		}
	}

	private static boolean isMoveable(int x, int y, int k, int c) {
		// 이동 가능 확인, min 보다 작은 카운트 일때만 이동 가능 
		if (0 <= x && x < H && 0 <= y && y < W && map[x][y] != 1 && min[k][x][y] > c)
			return true;

		return false;
	}
}

class Monkey {
	public int x;
	public int y;
	public int k;	// 말로 이동 횟수 
	public int c;	// 이동 횟수 

	public Monkey(int x, int y, int k, int c) {
		super();
		this.x = x;
		this.y = y;
		this.k = k;
		this.c = c;
	}
}