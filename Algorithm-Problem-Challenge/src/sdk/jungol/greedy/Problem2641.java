package sdk.jungol.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 그리디, 2641 택배
 * 
 * @author whitebeard
 *
 */
public class Problem2641 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		int m = in.nextInt();

		int[][] array = new int[m][3];
		for (int i = 0; i < m; i++) {
			array[i][0] = in.nextInt();
			array[i][1] = in.nextInt();
			array[i][2] = in.nextInt();
		}
		in.close();

		// int n = 4;
		// int c = 40;
		// int m = 6;
		// int[][] array = { { 3, 4, 20 },
		// { 1, 2, 10 },
		// { 1, 3, 20 },
		// { 1, 4, 30 },
		// { 2, 3, 10 },
		// { 2, 4, 20 } };

		// int n = 6;
		// int c = 60;
		// int m = 5;
		// int[][] array = { { 1, 2, 30 },
		// { 2, 5, 70 },
		// { 5, 6, 60 },
		// { 3, 4, 40 },
		// { 1, 6, 40 } };

		// 배열을 도착지점 순서로 정렬하여 
		// 도착지점에 따라 용량을 제거해 준다. 
		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return (a[1] <= b[1]) ? -1 : 1;
			}
		});

		// for(int[] a : array)
		// System.out.printf("%d %d %2d\n", a[0], a[1], a[2]);

		// 거리별 용량을 담기 위한 배열 
		int[] capacity = new int[n + 1];
		Arrays.fill(capacity, c);

		int sum = 0;
		for (int i = 0; i < array.length; i++) {

			int dept = array[i][0];
			int arri = array[i][1];
			int box = array[i][2];

			sum += getBox(capacity, dept + 1, arri, box);
		}

		System.out.println(sum);
	}

	public static int getBox(int[] capacity, int start, int end, int box) {

		int min = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			if (capacity[i] < min) {
				min = capacity[i];
			}
		}

		int result = 0;
		if (min > box) {
			result = box;
		} else {
			result = min;
		}

		for (int i = start; i <= end; i++) {
			capacity[i] -= result;
		}

		return result;
	}
}