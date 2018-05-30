package sdk.dovlet;

import java.util.Scanner;

public class Koi_Align {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		in.close();
		
		// 테스트용 데이터 
//		 int[] array = { 5, 2, 4, 1, 3 };
//		 int[] array = { 5, 2, 3, 4, 7, 1, 6 };

		int maxSequence = 0;
		
		// 배열의 인덱스 사용의 편의성을 위해 0을 사용하지 않고 1부터 시작 
		int[] sequence = new int[array.length + 1];
		// 배열의 첫번째 값 셋팅 
		sequence[array[0]] = 1;
		
		for (int i = 1; i < array.length; i++) {
			// 배열의 순서는 앞에 있는 데이터가 있는지 보고, 
			// 그앞의 데이터의 값에 +1을 하면 현재 데이터의 순서값이다. 
			int pivot = array[i];
			sequence[pivot] = sequence[pivot - 1] + 1;
			maxSequence = Math.max(maxSequence, sequence[pivot - 1] + 1);
		}

		System.out.println(array.length - maxSequence);
	}
}