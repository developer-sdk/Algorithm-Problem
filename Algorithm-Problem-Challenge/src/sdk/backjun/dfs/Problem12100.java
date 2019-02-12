package sdk.backjun.dfs;

import java.util.Scanner;

/**
 * 백준, 12100 
 * 2048(Easy)
 * 
 * @author whitebeard-k
 *
 */
public class Problem12100 {

	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;

	static int N;
	static int[][] map;
	static int MAX = Integer.MIN_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];

		for (int x = 0; x < N; x++)
			for (int y = 0; y < N; y++)
				map[x][y] = sc.nextInt();

		sc.close();

		move(0, UP, map);
		move(0, DOWN, map);
		move(0, LEFT, map);
		move(0, RIGHT, map);

		System.out.println(MAX);
	}

	public static void move(int count, int direction, int[][] map) {

		int[][] tempMap = moveMap(direction, map);
		tempMap = mergeMap(direction, tempMap);
		tempMap = moveMap(direction, tempMap);

		if (++count == 5) {
			checkMaxValue(tempMap);
			return;
		}

		move(count, UP, tempMap);
		move(count, LEFT, tempMap);
		move(count, RIGHT, tempMap);
		move(count, DOWN, tempMap);
	}

	// 최대값 확인
	private static void checkMaxValue(int[][] tempMap) {

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				MAX = Math.max(MAX, tempMap[x][y]);
			}
		}
	}

	// 병합
	private static int[][] mergeMap(int direction, int[][] moveMap) {

		switch (direction) {
			case UP:
				for (int y = 0; y < N; y++) {
					int prev = 0;
					for (int x = 0; x < N; x++) {
						if (prev == 0 || (prev != 0 && prev != moveMap[x][y]))
							prev = moveMap[x][y];
						else if (prev == moveMap[x][y]) {
							moveMap[x][y] += prev;
							moveMap[x - 1][y] = 0;
							prev = 0;
						}
					}
				}
				break;
			case DOWN:
				for (int y = N - 1; y >= 0; y--) {
					int prev = 0;
					for (int x = N - 1; x >= 0; x--) {
						if (prev == 0 || (prev != 0 && prev != moveMap[x][y]))
							prev = moveMap[x][y];
						else if (prev == moveMap[x][y]) {
							moveMap[x][y] += prev;
							moveMap[x + 1][y] = 0;
							prev = 0;
						}
					}
				}
				break;
			case LEFT:
				for (int x = 0; x < N; x++) {
					int prev = 0;
					for (int y = 0; y < N; y++) {
						if (prev == 0 || (prev != 0 && prev != moveMap[x][y]))
							prev = moveMap[x][y];
						else if (prev == moveMap[x][y]) {
							moveMap[x][y] += prev;
							moveMap[x][y - 1] = 0;
							prev = 0;
						}
					}
				}
				break;
			case RIGHT:
				for (int x = N - 1; x >= 0; x--) {
					int prev = 0;
					for (int y = N - 1; y >= 0; y--) {
						if (prev == 0 || (prev != 0 && prev != moveMap[x][y]))
							prev = moveMap[x][y];
						else if (prev == moveMap[x][y]) {
							moveMap[x][y] += prev;
							moveMap[x][y + 1] = 0;
							prev = 0;
						}
					}
				}
				break;
		}

		return moveMap;
	}

	// 이동
	private static int[][] moveMap(int direction, int[][] originMap) {

		int[][] moveMap = new int[N][N];

		switch (direction) {
			case UP:
				for (int y = 0; y < N; y++) {
					int newX = 0;
					for (int x = 0; x < N; x++) {
						if (originMap[x][y] != 0)
							moveMap[newX++][y] = originMap[x][y];
					}
				}
				break;
			case DOWN:
				for (int y = N - 1; y >= 0; y--) {
					int newX = N - 1;
					for (int x = N - 1; x >= 0; x--) {
						if (originMap[x][y] != 0)
							moveMap[newX--][y] = originMap[x][y];
					}
				}
				break;
			case LEFT:
				for (int x = 0; x < N; x++) {
					int newY = 0;
					for (int y = 0; y < N; y++) {
						if (originMap[x][y] != 0)
							moveMap[x][newY++] = originMap[x][y];
					}
				}
				break;
			case RIGHT:
				for (int x = N - 1; x >= 0; x--) {
					int newY = N - 1;
					for (int y = N - 1; y >= 0; y--) {
						if (originMap[x][y] != 0)
							moveMap[x][newY--] = originMap[x][y];
					}
				}
				break;
		}

		return moveMap;
	}
}