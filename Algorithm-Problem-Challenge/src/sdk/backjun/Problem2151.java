package sdk.backjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준, 2151
 * 거울설치 
 * 
 * @author whitebeard-k
 *
 */
public class Problem2151 {

	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;
	public static final int LEFT = 4;

	public static int MIRROR = '!';
	public static int WALL = '*';
	public static int DOOR = '#';

	public static int N;
	public static int[][] map;
	public static int[][] memo;

	public static int startX;
	public static int startY;

	public static int endX;
	public static int endY;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();

		boolean door = true;
		map = new int[N][N];
		memo = new int[N][N];

		for (int x = 0; x < N; x++) {
			String line = sc.nextLine();

			char[] chars = line.toCharArray();

			for (int y = 0; y < N; y++) {
				map[x][y] = chars[y];
				memo[x][y] = Integer.MAX_VALUE;

				// 문을 시작위치, 종료위치로 각각 입력 
				if (map[x][y] == DOOR) {
					if (door) {
						startX = x;
						startY = y;
						door = false;
					} else {
						endX = x;
						endY = y;
					}
				}
			}

		}

		sc.close();

		// 상하좌우 모두로 이동 
		Queue<Location> queue = new LinkedList<>();
		queue.add(new Location(UP, 0, startX, startY));
		queue.add(new Location(RIGHT, 0, startX, startY));
		queue.add(new Location(DOWN, 0, startX, startY));
		queue.add(new Location(LEFT, 0, startX, startY));

		bfs(queue);

		System.out.println(memo[endX][endY]);
	}

	public static void bfs(Queue<Location> queue) {

		while (!queue.isEmpty()) {

			Location current = queue.poll();

			// 방향에 따라 이동가능한 위치 선택 
			switch (current.direction) {
				case UP:
					left(queue, current, 1);
					up(queue, current, 0);
					right(queue, current, 1);
					break;
				case RIGHT:
					up(queue, current, 1);
					right(queue, current, 0);
					down(queue, current, 1);
					break;
				case DOWN:
					left(queue, current, 1);
					down(queue, current, 0);
					right(queue, current, 1);
					break;
				case LEFT:
					up(queue, current, 1);
					left(queue, current, 0);
					down(queue, current, 1);
					break;
			}
		}

	}

	private static void down(Queue<Location> queue, Location current, int count) {

		int currentX = current.x;
		int nextY = current.y;
		int nextCount = current.count + count;

		for (int nextX = currentX + 1; nextX < N; nextX++) {
			if (map[nextX][nextY] == WALL)
				return;

			if (isMoveable(nextX, nextY, nextCount)) {
				queue.add(new Location(DOWN, nextCount, nextX, nextY));
				memo[nextX][nextY] = nextCount;
			}
		}
	}

	private static void right(Queue<Location> queue, Location current, int count) {

		int nextX = current.x;
		int currentY = current.y;
		int nextCount = current.count + count;

		for (int nextY = currentY + 1; nextY < N; nextY++) {
			if (map[nextX][nextY] == WALL)
				return;

			if (isMoveable(nextX, nextY, nextCount)) {
				queue.add(new Location(RIGHT, nextCount, nextX, nextY));
				memo[nextX][nextY] = nextCount;
			}
		}
	}

	private static void up(Queue<Location> queue, Location current, int count) {

		int currentX = current.x;
		int nextY = current.y;
		int nextCount = current.count + count;

		for (int nextX = currentX - 1; 0 <= nextX; nextX--) {
			if (map[nextX][nextY] == WALL)
				return;

			if (isMoveable(nextX, nextY, nextCount)) {
				queue.add(new Location(UP, nextCount, nextX, nextY));
				memo[nextX][nextY] = nextCount;
			}
		}
	}

	private static void left(Queue<Location> queue, Location current, int count) {

		int nextX = current.x;
		int currentY = current.y;
		int nextCount = current.count + count;

		for (int nextY = currentY - 1; 0 <= nextY; nextY--) {
			if (map[nextX][nextY] == WALL)
				return;

			if (isMoveable(nextX, nextY, nextCount)) {
				queue.add(new Location(LEFT, nextCount, nextX, nextY));
				memo[nextX][nextY] = nextCount;
			}
		}
	}

	private static boolean isMoveable(int nextX, int nextY, int nextCount) {

		if (map[nextX][nextY] == MIRROR && nextCount < memo[nextX][nextY] || (map[nextX][nextY] == DOOR && nextX == endX && nextY == endY) && nextCount < memo[nextX][nextY]) {
			return true;
		}

		return false;
	}

}

class Location {
	public int direction;
	public int count;
	public int x;
	public int y;

	public Location(int direction, int count, int x, int y) {
		super();
		this.direction = direction;
		this.count = count;
		this.x = x;
		this.y = y;
	}
}