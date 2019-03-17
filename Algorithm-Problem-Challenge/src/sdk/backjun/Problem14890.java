package sdk.backjun;

import java.util.Scanner;

/**
 * 백준, 14890, 경사로
 * 
 * @author whitebeard-k
 *
 */
public class Problem14890 {

	static int[][] map;
	static int N;
	static int L;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();

		map = new int[N][N];

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				map[x][y] = sc.nextInt();
			}
		}

		int result = 0;
//		int prevHeight = 0;

		for (int x = 0; x < N; x++) {

			boolean isEnable = true;
			
			for (int y = 0; y < N; y++) {

				if (y + 1 >= N)
					continue;

				int currentHeight = map[x][y];

				if (currentHeight == map[x][y + 1]) {
					continue;
				} else if (Math.abs(currentHeight - map[x][y + 1]) == 1) {
					if (y + 2 < N && map[x][y + 1] == map[x][y + 2]) {
						y += 2;
						continue;
					} else {
						isEnable = false;
						break;
					}
				} else if (Math.abs(currentHeight - map[x][y + 1]) >= 2) {
					isEnable = false;
					break;
				}
			}

			if(isEnable) {
				System.out.println(x);
				result++;
			}
				
		}

		System.out.println(result);
	}
}
