package sdk.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 정올, 1695
 * 단지 번호 붙이기
 * 
 * 배열을 확인하면서, 1(집이 있는곳)을 만나면 9로 변경하면서 
 * 위, 아래, 좌, 우 위치의 값을 확인한다. 
 * 그리고 확인한 값을 list 에 넣어서 최종적으로 오름차순으로 보여준다. 
 * 
 * @author seo
 *
 */
public class Problem1695 {

	public static void main(String[] args) {
		
      Scanner in = new Scanner(System.in);
      int n = Integer.parseInt(in.nextLine());
      int[][] array = new int[n][n];
      for(int i = 0; i < n; i++) {
          String str = in.nextLine();
          char[] chars = str.toCharArray();
          
          for(int j = 0; j < chars.length; j++) {
        	  array[i][j] = Integer.parseInt(String.valueOf(chars[j]));
          }
      }
      in.close();
      
      
//		int n = 7;
//		int[][] array = { 	{ 0, 1, 1, 0, 1, 0, 0 },
//							{ 0, 1, 1, 0, 1, 0, 1 },
//							{ 1, 1, 1, 0, 1, 0, 1 },
//							{ 0, 0, 0, 0, 1, 1, 1 },
//							{ 0, 1, 0, 0, 0, 0, 0 },
//							{ 0, 1, 1, 1, 1, 1, 0 },
//							{ 0, 1, 1, 1, 0, 0, 0 } };
		
//		int n = 5;
//		int[][] array = {{ 1,1,1,0,0 },
//				{ 0,1,0,0,0 },
//				{ 1,1,0,1,0 },
//				{ 0,1,0,1,0 },
//				{ 0,0,1,1,1 }};
      	
      	// 입력값 확인
		System.out.println(n);
		for (int[] a : array) {
			for (int num : a) {
				System.out.printf("%d ", num);
			}
			System.out.println();
		}

		System.out.println("--------");

		// 최종 결과 저장을 위한 리스트 
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (array[i][j] == 1) {
					int result = checker(array, i, j);
					list.add(result);
				}
			}
		}

		System.out.println(list.size());
		Collections.sort(list);

		for (int number : list)
			System.out.println(number);
	}

	public static int checker(int[][] array, int x, int y) {

		if (x < 0 || x >= array.length || y < 0 || y >= array.length) {
			return 0;
		} else if (array[x][y] != 1) {
			return 0;
		}

		// 집을 체크하면 1 -> 9로 설정
		array[x][y] = 9;

		int result = 0;
		result += checker(array, x - 1, y);
		result += checker(array, x + 1, y);
		result += checker(array, x, y - 1);
		result += checker(array, x, y + 1);

		return result + 1;
	}
}
