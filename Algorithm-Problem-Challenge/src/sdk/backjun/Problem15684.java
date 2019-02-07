package sdk.backjun;

import java.util.Scanner;

/**
 * 백준, 15684
 * 사다리 조작 
 * 
 * @author whitebeard-k
 *
 */
public class Problem15684 {

	public static int N; // 세로선의 개수
	public static int M; // 가로선의 개수
	public static int H; // 놓을 수 있는 선의 개수

	public static int[][] ladder; // 사다리. 1: 제시한 사다리, 2: 선택한 사다리

	public static int MIN = Integer.MAX_VALUE; // 완전 탐색의 최소 개수 선택을 위해서 처리

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();

		ladder = new int[H + 1][N + 1];

		for (int x = 0; x < M; x++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			ladder[a][b] = 1;
		}

		sc.close();

		for (int i = 1; i <= 3; i++) {
			select(0, 1, i);

			if (MIN != Integer.MAX_VALUE) {
				System.out.println(MIN);
				return;
			}

		}

		System.out.println(-1);
		// System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
	}

	// 사다리 선택
	public static void select(int count, int num, int selectCount) {

		// 선택한 가로선이 3이하이면 가능여부 체크
		if (count <= selectCount && check()) {
			MIN = Math.min(MIN, count);
		}

		if (count == selectCount)
			return;

		int startX = num / N;
		int startY = num % N;

		if (startX == 0)
			startX = 1;

		if (startY == 0)
			startY = 1;

		for (int x = startX; x <= H; x++) {
			for (int y = 1; y <= N; y++) {
				num++;

				if (isAvailable(x, y)) {
					ladder[x][y] = 2;
					select(count + 1, num, selectCount);
					ladder[x][y] = 0;
				}
			}
		}
	}

	// 사다리 선택 여부 체크
	private static boolean isAvailable(int i, int j) {

		// 이미 선택된 사다리는 제외
		if (ladder[i][j] == 1 || ladder[i][j] == 2)
			return false;

		// 1번 라인일때
		if (j == 1 && ladder[i][j] == 0 && ladder[i][j + 1] == 0)
			return true;

		// N번 라인은 선택 안됨
		if (j == N)
			return false;

		// 좌우에 선택된 사다리가 없을때 사다리 선택 가능
		if (2 <= j && j < N) {
			if (ladder[i][j + 1] == 0 && ladder[i][j - 1] == 0)
				return true;
		}

		return false;
	}

	// 사다리 이동
	private static boolean check() {
		int[] location = new int[N + 1];

		for (int i = 1; i <= N; i++)
			location[i] = i;

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				if (ladder[i][j] == 1 || ladder[i][j] == 2)
					swap(location, i, j);
			}
		}

		for (int i = 1; i <= N; i++)
			if (i != location[i])
				return false;

		return true;
	}

	private static void swap(int[] location, int i, int j) {
		int temp = location[j];
		location[j] = location[j + 1];
		location[j + 1] = temp;
	}
}