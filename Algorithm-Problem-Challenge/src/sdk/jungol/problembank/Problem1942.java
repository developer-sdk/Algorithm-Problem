package sdk.jungol.problembank;

import java.util.Scanner;

/**
 * 정올, 문제은행 
 * 하얀모자 
 * 
 * @author whitebeard
 *
 */
public class Problem1942 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] caps = new int[N];
		for (int i = 0; i < caps.length; i++) {
			caps[i] = in.nextInt();
		}
		in.close();

		// int N = 3;
		// int[] caps = { 0, 0, 0 };

		int sum = 0;
		for (int n : caps)
			sum += n;

		if (sum == 0) {
			System.out.println(0);
			return;
		}

		int[] value = new int[N + 1];

		for (int i = 0; i < caps.length; i++) {
			value[caps[i]]++;
			value[caps[i] + 1]++;
		}

		int maxIndex = -1;
		int maxValue = -1;
		for (int i = 0; i < value.length; i++) {

			if (value[i] >= maxValue) {
				maxValue = value[i];
				maxIndex = i;
			}
		}

		System.out.println(maxIndex);
		// System.out.println(maxValue);
	}
}
