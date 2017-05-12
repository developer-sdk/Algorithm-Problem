package sdk.algo.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 정올, bfs, 2613
 * 토마토 
 * @author whitebeard-k
 *
 */
public class Problem2613 {

	public static void main(String[] args) {

		Queue<int[]> queue = new LinkedList<>();

		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt() + 1;
		int x = sc.nextInt() + 1;
		int[][] array = new int[x][y];
		for (int i = 1; i < x; i++) {
			for (int k = 1; k < y; k++) {
				array[i][k] = sc.nextInt();

				if (array[i][k] == 1) {
					queue.add(new int[] { i, k });
				}
			}
		}
		sc.close();

		bfs(queue, array);

		// 남은 토마토가 있는지 확인 
		for (int i = 1; i < x; i++)
			for (int k = 1; k < y; k++)
				if (array[i][k] == 0) {
					System.out.println(-1);
					System.exit(0);
				}

		System.out.println(count - 1);
	}

	// 상하좌우 이동을 위한 배열 
	static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int count = 1;

	public static void bfs(Queue<int[]> queue, int[][] array) {

		while (!queue.isEmpty()) {

			int size = queue.size();

			while (size-- > 0) {

				int[] current = queue.poll();

				for (int[] move : moves) {
					int x = current[0] + move[0];
					int y = current[1] + move[1];

					// 이동이 가능한지 확인하고, 가능하면 큐에 입력 
					if (0 < x && x < array.length && 0 < y && y < array[0].length && array[x][y] == 0) {
						queue.add(new int[] { x, y });
						array[x][y] = count;
					}
				}
			}

			if (!queue.isEmpty())
				count++;
		}
	}
}