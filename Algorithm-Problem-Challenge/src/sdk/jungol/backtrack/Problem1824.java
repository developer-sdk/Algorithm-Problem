package sdk.jungol.backtrack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 정올, 백트래킹1, 1824, 스도쿠
 * 
 * @author User
 *
 */
public class Problem1824 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[][] array = new int[9][9];

		for (int x = 0; x < 9; x++)
			for (int y = 0; y < 9; y++)
				array[x][y] = in.nextInt();
		in.close();

//		 int[][] array = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 }};

		// 0으로 입력된 데이터를 따로 리스트에 입력 
		ArrayList<int[]> list = new ArrayList<>();
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if (array[x][y] == 0)
					list.add(new int[] { x, y });
			}
		}

		check(array, list, 0);
	}

	public static void check(int[][] array, ArrayList<int[]> list, int index) {

		// index 가 입력 가능한 값까지 가면 종료 
		if (index == list.size()) {
			for (int[] ss : array) {
				for (int n : ss) {
					System.out.printf("%d ", n);
				}
				System.out.println();
			}

			System.exit(1);
			return;
		}

		// 다음으로 테스트해야 할 데이터 확인 
		int[] loc = list.get(index);
		int x = loc[0];
		int y = loc[1];

		// 입력 가능한 값을 확인 
		for (int i = 1; i < 10; i++) {
			if (isAvailable(array, x, y, i)) {
				// 입력가능하면 체크하고 다음 인덱스로 진행 
				array[x][y] = i;
				check(array, list, index + 1);
				array[x][y] = 0;
			}
		}
	}

	/**
	 * 해당값이 입력이 가능한지 확인 
	 */
	public static boolean isAvailable(int[][] sudoku, int x, int y, int target) {

		// 가로, 세로 확인 
		for (int xx = 0; xx < sudoku.length; xx++) {
			if (sudoku[xx][y] == target || sudoku[x][xx] == target)
				return false;
		}

		// 해당 지점이 존재하는 사각형 안에 같은 값이 존재하는지 확인 
		int xk = x / 3 * 3;
		int yk = y / 3 * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sudoku[xk + i][yk + j] == target)
					return false;
			}
		}

		return true;
	}
}