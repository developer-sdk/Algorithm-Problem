package sdk.algo.greedy;

import java.util.Scanner;

/**
 * 정올, 그리디, 최소비용 신장트리 프림알고리즘
 * 
 * @author User
 *
 */
public class Problem1060 {

	static int cost = 0;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] array = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = in.nextInt();
			}
		}
		in.close();

		// int n = 5;
		// int[][] array = { { 0, 5, 10, 8, 7, },
		// { 5, 0, 5, 3, 6, },
		// { 10, 5, 0, 1, 3, },
		// { 8, 3, 1, 0, 1, },
		// { 7, 6, 3, 1, 0, } };

		int[] visited = new int[n];
		visited[0] = 1;

		prim(array, visited, 0);

		System.out.println(cost);
	}

	
	/**
	 * 프림 알고리즘을 이용하여 처리 
	 */
	public static void prim(int[][] array, int[] visited, int depth) {

		// 모든 노드에 도달하면 종료 
		if (depth == visited.length - 1) {
			return;
		}

		int min = Integer.MAX_VALUE;
		int indexX = 0;
		int indexY = 0;

		for (int i = 0; i < visited.length; i++) {

			// 연결된 노드라면 처리 
			if (visited[i] == 1) {
				for (int j = 0; j < array.length; j++) {

					if (i == j)
						continue;

					if (visited[j] == 1)
						continue;

					// 연결되지 않은 노드중 가장 작은 값을 가지는 노드를 추가 
					if (array[i][j] < min) {
						min = array[i][j];
						indexX = i;
						indexY = j;
					}
				}
			}
		}

		visited[indexX] = 1;
		visited[indexY] = 1;
		cost += min;

		prim(array, visited, depth + 1);
	}
}
