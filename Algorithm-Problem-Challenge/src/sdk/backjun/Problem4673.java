package sdk.backjun;

/**
 * 백준, 4673
 * 셀프 넘버 
 * 
 * @author whitebeard-k
 *
 */
public class Problem4673 {

	static int N = 10000;
	static int[] hasConst = new int[N + 1];

	public static void main(String[] args) {

		for (int i = 1; i <= N; i++) {
			checkSelfNumber(i);
		}

		for (int i = 1; i <= N; i++) {
			if (hasConst[i] == 0)
				System.out.println(i);
		}
	}

	// number가 생성자인 숫자 체크 
	public static void checkSelfNumber(int number) {

		int sum = number;

		while (number != 0) {
			int mod = number % 10;
			number /= 10;
			sum += mod;
		}

		if (sum <= N)
			hasConst[sum] = 1;
	}
}
