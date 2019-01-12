package sdk.backjun.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준, 14502
 * 연구소 
 * 
 * @author whitebeard-k
 *
 */
public class Problem14502 {

	static int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static int N; // 세로 x
	static int M; // 가로 y
	static int[][] map; // 0: 빈칸, 1: 벽, 2: 바이러스, 3: 임시벽
	static int[][] tempMap;
	static int emptyCount;
	static int maxSafetyCount;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				map[x][y] = sc.nextInt();

				if (map[x][y] == 0 || map[x][y] == 2)
					emptyCount++;
			}
		}
		sc.close();

		buildWall(0, 0);
		System.out.println(maxSafetyCount);
	}

	// 임시 벽(3)을 생성, 
	public static void buildWall(int next, int count) {

		if (count == 3) {
			int virusCount = calcVirusZone();
			int safetyZone = emptyCount - virusCount - 3;
			maxSafetyCount = Math.max(maxSafetyCount, safetyZone);
			return;
		}

		for (int location = next; location < N * M; location++) {

			int currentX = location / M;
			int currentY = location % M;

			if (map[currentX][currentY] == 0) {
				map[currentX][currentY] = 3;
				buildWall(location+1, count + 1);
				map[currentX][currentY] = 0;
			}
		}

	}

	// spreadVirus()로 바이러스 영역을 확장하여 바이러스 총 개수 반환 
	private static int calcVirusZone() {
		tempMap = new int[N][M];
		int virusCount = 0;

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (map[x][y] == 2 && tempMap[x][y] == 0) {
					virusCount += spreadVirus(new VirusPoint(x, y));
				}
			}
		}

		return virusCount;
	}

	// 바이러스 영역 확장 
	private static int spreadVirus(VirusPoint start) {

		int virusCount = 1;

		Queue<VirusPoint> queue = new LinkedList<VirusPoint>();
		queue.add(start);
		tempMap[start.x][start.y] = 1;

		while (!queue.isEmpty()) {
			VirusPoint current = queue.poll();

			for (int[] move : moves) {
				int nextX = current.x + move[0];
				int nextY = current.y + move[1];

				if (isMoveable(nextX, nextY)) {
					tempMap[nextX][nextY] = 1;
					queue.add(new VirusPoint(nextX, nextY));
					virusCount++;
				}
			}

		}

		return virusCount;
	}

	private static boolean isMoveable(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M && tempMap[x][y] == 0 && map[x][y] == 0)
			return true;

		return false;
	}
}

class VirusPoint {
	public int x;
	public int y;

	public VirusPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("x: %d y: %d", x, y);
	}
}