package sdk.jungol.sillyuk;

import java.util.Scanner;
import java.util.TreeSet;

public class Problem2255 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		in.close();

		int[] source = new int[n];
		for (int i = 0; i < n; i++) {
			source[i] = i + 1;
		}

		// 테스트 데이터
//		int n = 13;
//		int[] array = { 28, 160, 109, 26, 81, 124, 193, 42, 98, 4, 45, 73, 88, 198, 62, 96, 46, 120, 168, 150, 128, 112,
//				48, 156, 21, 30, 52, 145, 185, 158, 13, 55, 140, 143, 187, 58, 39, 130, 69, 126, 162, 127, 56, 71, 2,
//				183, 110, 95, 173, 178, 192, 29, 119, 111, 153, 104, 174, 146, 75, 54, 139, 199, 149, 201, 68, 44, 125,
//				37, 20, 189, 161, 101, 61, 3, 47, 60, 86, 121, 92, 84, 152, 57, 41, 74, 116, 195, 179, 82, 181, 83, 34,
//				59, 38, 53, 100, 80, 8, 154, 97, 7, 67, 182, 117, 144, 76, 177, 166, 31, 115, 6, 107, 132, 94, 175, 1,
//				90, 135, 65, 103, 194, 131, 19, 64, 25, 165, 91, 105, 89, 87, 15, 24, 18, 186, 172, 184, 151, 70, 12,
//				114, 136, 148, 22, 27, 200, 35, 50, 102, 147, 23, 123, 134, 43, 133, 10, 170, 36, 118, 32, 191, 190, 51,
//				155, 14, 78, 17, 176, 77, 129, 93, 169, 122, 79, 66, 163, 164, 106, 196, 40, 33, 5, 159, 108, 49, 188,
//				137, 16, 11, 9, 171, 157, 85, 142, 138, 141, 63, 167, 113, 197, 99, 72, 180 };

		process(array);
	}

	public static void process(int[] array) {

		// index 형태로(0부터 시작)
		for (int i = 0; i < array.length; i++) {
			array[i]--;
		}

		TreeSet<Integer> set = new TreeSet<Integer>();

		for (int i = 0; i < array.length; i++) {

			int count = 0;
			int temp = array[i];
			while (true) {

				count++;
				if (array[i] == array[temp]) {
					set.add(count);
					break;
				}
				temp = array[temp];
			}
		}

		int maxValue = set.last();

		for (int i = 1;; i++) {
			int value = maxValue * i;

			boolean isMatch = true;

			for (int g : set) {

				if (value % g != 0) {
					isMatch = false;
					break;
				}
			}

			if (isMatch) {
				System.out.println(value);
				break;
			}
		}
	}
}