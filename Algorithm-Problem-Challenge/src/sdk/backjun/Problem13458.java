package sdk.backjun;

import java.util.Scanner;

/**
 * 백준, 13458
 * 시험 감독관 
 * 
 * @author whitebeard-k
 *
 */
public class Problem13458 {

	static int N;
	static int B;
	static int C;
	static int[] person;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		person = new int[N];
		for (int i = 0; i < N; i++)
			person[i] = sc.nextInt();

		B = sc.nextInt();
		C = sc.nextInt();
		sc.close();

		long sum = 0;
		for (int num : person) {
			sum += 1;
			num -= B;

			if (num > 0) {
				int result = num / C;
				int mod = num % C;

				sum += result + (mod == 0 ? 0 : 1);
			}
		}

		System.out.println(sum);
	}
}
