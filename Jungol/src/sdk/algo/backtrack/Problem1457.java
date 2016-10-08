package sdk.algo.backtrack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 정올, 백트래킹, 1457, 영역구하기
 * 
 * @author whitebeard
 *
 */
public class Problem1457 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int k = in.nextInt();
		int[][] squares = new int[k][4];
		for (int i = 0; i < k; i++)
			for (int j = 0; j < 4; j++)
				squares[i][j] = in.nextInt();

		in.close();

		// int m = 5;
		// int n = 7;
		// int k = 3;
		//
		// int[][] squares = { { 0, 2, 4, 4 },
		// { 1, 1, 2, 5 },
		// { 4, 0, 6, 2 } };

		// int m = 1;
		// int n = 2;
		// int k = 1;
		//
		// int[][] squares = { { 0, 0, 1, 1 } };

		int[][] paper = new int[m][n];

		for (int[] square : squares) {

			for (int i = square[0]; i < square[2]; i++) {
				for (int j = square[1]; j < square[3]; j++) {
					paper[j][i] = 1;
				}
			}
		}

		int counter = 100;
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				int number = paper[x][y];

				if (number == 0)
					checker(paper, x, y, counter++);
			}
		}

		int[] result = new int[counter - 100];
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				int number = paper[x][y];

				if (number != 1) {
					result[counter - number - 1]++;
				}
			}
		}

		// for(int a = 0; a < m; a++) {
		// for(int b = 0; b < n; b++) {
		// System.out.format("%3d ", paper[a][b]);
		// }
		// System.out.println();
		// }

		Arrays.sort(result);

		System.out.println(counter - 100);
		for (int i : result)
			System.out.format("%d ", i);
	}

	public static void checker(int[][] squares, int x, int y, int value) {

		if (x < 0 || y < 0 || x >= squares.length || y >= squares[0].length) {
			return;
		}

		int number = squares[x][y];

		if (number == 0) {
			squares[x][y] = value;
			checker(squares, x - 1, y, value);
			checker(squares, x + 1, y, value);
			checker(squares, x, y - 1, value);
			checker(squares, x, y + 1, value);
		}
	}

}