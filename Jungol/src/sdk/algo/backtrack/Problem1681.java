package sdk.algo.backtrack;

import java.util.Scanner;

/**
 * 
 * 1681, 백트래킹, 해밀턴 순환회로
 * 
 * @author ADMIN
 *
 */
public class Problem1681 {

	static int min = Integer.MAX_VALUE;

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
		// int[][] array = { { 0, 14, 4, 10, 20 },
		// {14, 0, 7, 8, 7 },
		// { 4, 5, 0, 7, 16 },
		// {11, 7, 9, 0, 2 },
		// {18, 7, 17, 4, 0 }};

		// int n = 6;
		// int[][] array = {{ 0, 93, 23, 32, 39, 46 },
		// { 0, 0, 7, 58, 59, 13 },
		// { 40, 98, 0, 14, 33, 98 },
		// { 3, 39, 0, 0, 13, 16 },
		// { 51, 25, 19, 88, 0, 47 },
		// { 65, 81, 63, 0, 6, 0 } };

		int start = 0;
		int[] visited = new int[n];
		visited[start] = 1;

		move(array, visited, start, 0, 1);
		// moveWithPath(array, visited, start, 0, String.valueOf(start) + " ");

		System.out.println(min);
	}

	public static void move(int[][] array, int[] visited, int location, int sum, int count) {

		if (count == visited.length) {
			if (array[location][0] == 0)
				return;

			sum += array[location][0];
			min = min < sum ? min : sum;
			return;
		}

		for (int i = 0; i < visited.length; i++) {

			if (visited[i] == 0 && array[location][i] != 0) {
				visited[i] = 1;
				move(array, visited, i, sum + array[location][i], count + 1);
				visited[i] = 0;
			}
		}
	}

	public static void moveWithPath(int[][] array, int[] visited, int location, int sum, String path) {

		int r = 0;
		for (int a : visited) {
			if (a == 0)
				break;

			r += a;
		}

		if (r == visited.length) {
			if (array[location][0] == 0)
				return;

			System.out.printf("%s : %d\n", path, sum);

			sum += array[location][0];

			min = min < sum ? min : sum;
			return;
		}

		for (int i = 0; i < visited.length; i++) {

			if (visited[i] == 0 && array[location][i] != 0) {
				visited[i] = 1;
				moveWithPath(array, visited, i, sum + array[location][i], path + String.valueOf(i) + " ");
				visited[i] = 0;
			}
		}
	}
}
