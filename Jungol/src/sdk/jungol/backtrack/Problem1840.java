package sdk.jungol.backtrack;

import java.util.Scanner;

/**
 * 정올, 1840, 치즈
 * 백트래킹 
 * 
 * @author whitebeard
 *
 */
public class Problem1840 {

	static int xLength;
	static int yLength;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		xLength = in.nextInt();
		yLength = in.nextInt();
		int[][] array = new int[xLength][yLength];
		for (int x = 0; x < xLength; x++) {
			for (int y = 0; y < yLength; y++) {
				array[x][y] = in.nextInt();
			}
		}
		in.close();

		// int[][] array = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		// { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		// { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
		// { 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0 },
		// { 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
		// { 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0 },
		// { 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0 },
		// { 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0 },
		// { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
		// { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
		// { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
		// { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
		// { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};

		int last = 0;
		int count = 0;

		while (true) {

			int remain = 0;

			checkAir(array, 0, 0);

			for (int x = 0; x < xLength; x++) {
				for (int y = 0; y < yLength; y++) {

					if (array[x][y] == 1) {
						if (array[x - 1][y] == 9 || array[x + 1][y] == 9 || array[x][y - 1] == 9
								|| array[x][y + 1] == 9) {
							array[x][y] = 2;
							remain++;
						}
					}

				}
			}

			for (int x = 0; x < xLength; x++) {
				for (int y = 0; y < yLength; y++) {
					if (array[x][y] == 9 || array[x][y] == 2)
						array[x][y] = 0;	// 이번에 없어져야 하는 부분을 0으로 설정 
				}
			}

			// 더이상 처리할 부분이 없으면 0으로 설정 
			if (remain == 0)
				break;

			count++;
			last = remain;
		}

		System.out.println(count);
		System.out.println(last);
	}

	/**
	 * 공기가 되는 부분을 9로 설정 
	 * 2로 설정된 부분은 없어져야 할 부분 
	 */
	public static void checkAir(int[][] array, int x, int y) {

		if (array[x][y] == 0 || array[x][y] == 2) {

			array[x][y] = 9;

			if (x - 1 >= 0)
				checkAir(array, x - 1, y);

			if (x + 1 < xLength)
				checkAir(array, x + 1, y);

			if (y - 1 >= 0)
				checkAir(array, x, y - 1);

			if (y + 1 < yLength)
				checkAir(array, x, y + 1);
		}
	}
}
