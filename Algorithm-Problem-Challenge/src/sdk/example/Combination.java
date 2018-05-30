package sdk.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 리스트를 이용한 조합 예 
 * 0, 1, 2 세가지 숫자에서 2가지 숫자를 선택하여 만들 수 있는 수의 조합 
 * 
 * @author whitebeard-k
 *
 */
public class Combination {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		combination(list, 3, 2, 0);
		
		combi_for();
	}

	
	/**
	 * 리스트와 재귀를 이용한 조합 생성 
	 * 
	 * @param list
	 * @param length 집합의 개수 
	 * @param r 선택하는 부분집합의 개수 
	 * @param pivot 기준 위치 
	 */
	public static void combination(List<Integer> list, int length, int r, int pivot) {

		if (r == 0) {
			for (int n : list)
				System.out.print(n);

			System.out.println();
			return;
		}

		for (int i = pivot; i < length; i++) {

			list.add(i);
			combination(list, length, r - 1, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	/**
	 * for 문을 이용한 조합 
	 */
	public static void combi_for() {
		
		for(int i = 0; i < 3; i++) {
			for(int j = i+1; j < 3; j++) {
				System.out.printf("%d %d\n", i, j);
			}
		}
	}
}
