package sdk.backjun.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준, 14888
 * 연산자 끼워넣기
 *  
 * @author whitebeard-k
 *
 */
public class Problem14888 {

	static int MIN = Integer.MAX_VALUE;
	static int MAX = Integer.MIN_VALUE;

	static int N;
	static int[] numbers;
	static int[] operators;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(reader.readLine());
		numbers = new int[N];
		operators = new int[4];

		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < 4; i++)
			operators[i] = Integer.parseInt(st.nextToken());

		calc(numbers[0], 1);

		System.out.println(MAX);
		System.out.println(MIN);
	}

	// prevResult는 이전 산의 결과, index는 현재 선택하는 숫자 
	public static void calc(int prevResult, int index) {

		for (int i = 0; i < 4; i++) {

			if (operators[i] != 0) {
				operators[i]--;
				int result = calcNumber(i, prevResult, numbers[index]);

				// 모두 선택하면 결과를 계산 
				if (index + 1 == N) {
					MIN = Math.min(MIN, result);
					MAX = Math.max(MAX, result);
				} else
					calc(result, index + 1);

				operators[i]++;
			}
		}
	}

	// operators 배열의 타입에 따라 연산 처리 
	// 0: +, 1: -, 2: *, 3: /
	private static int calcNumber(int i, int prevResult, int currentNumber) {

		switch (i) {
		case 0:
			return prevResult + currentNumber;
		case 1:
			return prevResult - currentNumber;
		case 2:
			return prevResult * currentNumber;
		case 3:
			return prevResult / currentNumber;
		}

		return 0;
	}
}