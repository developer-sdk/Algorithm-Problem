package sdk.algo.dnq;

import java.util.Scanner;

/**
 * 정올, 분할정복, 1335
 * 색종이만들기 
 * 
 * @author whitebeard-k
 *
 */
public class Problem1335 {

	// count0, count1 로 색종이의 색을 구분한다. 
	static int count0 = 0;
	static int count1 = 0;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] square = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				square[i][j] = in.nextInt();
			}
		}
		in.close();
		
		// int n = 4;
		// int[][] square = { { 1, 1, 0, 1 },
		// { 1, 1, 0, 0 },
		// { 0, 0, 1, 0 },
		// { 1, 0, 0, 1 } };

		// int n = 8;
		// int[][] square = { { 1, 1, 0, 0, 0, 0, 1, 1 },
		// { 1, 1, 0, 0, 0, 0, 1, 1 },
		// { 0, 0, 0, 0, 1, 1, 0, 0 },
		// { 0, 0, 0, 0, 1, 1, 0, 0 },
		// { 1, 0, 0, 0, 1, 1, 1, 1 },
		// { 0, 1, 0, 0, 1, 1, 1, 1 },
		// { 0, 0, 1, 1, 1, 1, 1, 1 },
		// { 0, 0, 1, 1, 1, 1, 1, 1 } };

		check(square, 0, 0, n);

		System.out.println(count0);
		System.out.println(count1);
	}

	/**
	 * @param square 사각형 배열 
	 * @param x1 사각형의 시작점 x 좌표 
	 * @param y1 사각형의 시작점 y 좌표 
	 * @param n 사각형의 길이 
	 */
	public static void check(int[][] square, int x1, int y1, int n) {

		int value = square[x1][y1];
		
		// 길이가 1이면 바로 체크 
		if (n == 1) {
			if (value == 0) {
				count0++;
			} else {
				count1++;
			}

			return;
		}

		boolean isOne = true;

		// 사각형이 하나의 색인지 체크 
		for (int i = x1; i < x1 + n; i++) {
			for (int j = y1; j < y1 + n; j++) {

				if (value != square[i][j]) {
					isOne = false;
					break;
				}
			}

			if (!isOne) {
				break;
			}
		}

		// 하나의 색이면 색에 따라 체크 
		if (isOne) {
			if (value == 0) {
				count0++;
			} else {
				count1++;
			}

			return;
		} else {
			// 하나의 색이 아니면 4조각으로 나누어서 계산 
			check(square, x1, y1, n / 2);
			check(square, x1 + n / 2, y1, n / 2);
			check(square, x1, y1 + n / 2, n / 2);
			check(square, x1 + n / 2, y1 + n / 2, n / 2);
		}
	}
}
