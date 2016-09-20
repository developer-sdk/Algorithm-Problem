package sdk.algo.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 정올, 다이나믹, 1539 가장높은 탑 쌓기
 * 
 * @author User
 *
 */
public class Problem1539 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[][] bricks = new int[N][4];
		for (int i = 0; i < N; i++) {
			bricks[i][0] = in.nextInt(); // 밑면의 넓이
			bricks[i][1] = in.nextInt(); // 벽돌의 높이
			bricks[i][2] = in.nextInt(); // 무게
			bricks[i][3] = i + 1; // 원래 인덱스(최종 출력을 위해 +1 처리)
		}
		in.close();

		// 테스트 데이터 #1
		// int N = 5;
		// int[][] bricks = {{ 25, 3, 4, 1 },
		// { 4, 4, 6 , 2},
		// { 9, 2, 3 , 3},
		// { 16, 2, 5 , 4},
		// { 1, 5, 2 , 5}};

		// 테스트 데이터 #2
		// int N = 10;
		// int[][] bricks = { { 114, 96, 290, 1 },
		// { 65, 74, 201, 2 },
		// { 261, 19, 105, 3 },
		// { 181, 60, 275, 4 },
		// { 90, 145, 254, 5 },
		// { 286, 118, 64, 6 },
		// { 16, 24, 205, 7 },
		// { 288, 128, 299, 8 },
		// { 96, 36, 74, 9 },
		// { 182, 5, 35, 10 }};
		
		// 밑면의 넓이 기준 정렬 
		Arrays.sort(bricks, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return (a[0] <= b[0]) ? -1 : 1;
			}
		});

		// 벽돌 정렬 결과 출력
		// for(int[] brick : bricks)
		// System.out.printf("%2d\t%2d\t%2d\t%2d\n", brick[0], brick[1],
		// brick[2], brick[3]);

		// 넓이가 가장 작은 벽돌 위에는 아무것도 올라갈 수 없으므로 result의 첫번째에는 첫번째 벽돌을 입력 
		int[][] result = new int[N][3];
		result[0][0] = 0; 				// 올라갈 인덱스
		result[0][1] = bricks[0][3]; 	// 원인덱스
		result[0][2] = bricks[0][1]; 	// 높이

		// 두번째 넓이의 벽돌부터 
		for (int i = 1; i < bricks.length; i++) {

			// 자신보다 작은 넓이의 벽돌을 순회하면서 확인 
			for (int k = 0; k < i; k++) {

				if (bricks[i][2] > bricks[k][2]) { // 무게가 작아 올라갈 수 있다면

					if (result[i][2] < bricks[i][1] + result[k][2]) {	
						// 현재 벽돌과 올라간 벽돌의 높이의 합이 이전에 가장 높은 벽돌의 높이보다 크다면
						result[i][0] = k;
						result[i][1] = bricks[k][3];
						result[i][2] = bricks[i][1] + result[k][2];
					}
				}
			}

			// 올라갈 수 있는 벽돌이 없으면 자신의 높이를 입력 
			if (result[i][2] == 0) {
				result[i][0] = i;
				result[i][1] = bricks[i][3];
				result[i][2] = bricks[i][1];
			}
		}

		// System.out.println("-------------------------");
		// for(int[] brick : result)
		// System.out.printf("%2d\t%2d\t%2d\n", brick[0], brick[1], brick[2]);

		// 최고 높이의 인덱스 확인 
		int maxHeight = 0;
		int maxIndex = 0;
		for (int i = 0; i < result.length; i++) {

			if (result[i][2] > maxHeight) {
				maxHeight = result[i][2];
				maxIndex = i;
			}
		}

		// 쌓여진 순서를 아래 벽돌부터 리스트에 입력 
		ArrayList<Integer> list = new ArrayList<>();
		list.add(bricks[maxIndex][3]);

		while (true) {

			// 자신의 위에 아무것도 없으면 종료 
			if (result[maxIndex][0] == maxIndex)
				break;

			maxIndex = result[maxIndex][0];
			list.add(bricks[maxIndex][3]);
		}

		// System.out.println("---------사이즈 출력-------------");
		System.out.println(list.size());

		// System.out.println("---------역순으로 위에서 부터 출력-------------");
		Collections.reverse(list);
		for (int n : list)
			System.out.println(n);
	}
}