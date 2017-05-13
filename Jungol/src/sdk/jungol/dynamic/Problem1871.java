package sdk.jungol.dynamic;

import java.util.Scanner;

/**
 * 정올, 다이나믹, 1871
 * 줄세우기
 * 
 * @author whitebeard-k
 *
 */
public class Problem1871 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] students = new int[n];
		for(int i = 0; i < n; i++) {
			students[i] = sc.nextInt();
		}
		sc.close();
		
//		int[] students = { 3, 7, 5, 2, 6, 1, 4 };
		int[] memo = new int[students.length];
		memo[students.length-1] = 1;
		int LCS = -1;
		
		// 뒤에서부터 순착적으로 앞으로 오면서 나보다 큰 숫자들중 
		// 가장 정렬이 많이 되어 있는 숫자에 +1 을 하여 가장 많이 정렬되어 있는 숫자를 찾는다.  
		for(int i = students.length - 1; i >= 0; i--) {
			
			int pivot = students[i];
			int max = 0;
			
			for(int k = i+1; k < students.length; k++) {
				
				if(pivot < students[k] && max < memo[k]) {
					max = memo[k];
				}
			}
			
			memo[i] = max+1;
			
			if(LCS < memo[i]) {
				LCS = memo[i];
			}
		}
		
		System.out.println(students.length - LCS);
	}
}