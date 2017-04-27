package sdk.algo.dynamic;

import java.util.Scanner;

/**
 * 정올, 1411, 다이나믹
 * 두 줄로 타일 깔기 
 * 
 * @author whitebeard-k
 *
 */
public class Problem1411 {

	public static int[] memo = new int[1000001];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		memo[1] = 1;
		memo[2] = 3;
		
		for(int i = 3; i <= n; i++) {
			memo[i] = ((memo[i-1]) + (2*memo[i-2]))%20100529; 
		}
		
		System.out.println(memo[n]);
	}
}
