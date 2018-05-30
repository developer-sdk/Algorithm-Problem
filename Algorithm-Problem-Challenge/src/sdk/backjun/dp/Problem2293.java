package sdk.backjun.dp;

import java.util.Scanner;

/**
 * 백준, 동전 1, 2293
 * 
 * @author whitebeard-k
 *
 */
public class Problem2293 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coins = new int[N+1];
		for(int i = 1; i <= N; i++) 
			coins[i] = sc.nextInt();
		sc.close();
		
		int[] dp = new int[K+1];
		dp[0] = 1;
		
		for(int i = 1; i <= N; i++ ){ 
			
			for(int j = 0; j <= K; j++ ){
				if(j - coins[i] >= 0) {
					dp[j] += dp[j-coins[i]];
				}
			}
			
//			System.out.printf("coin %d\n", coins[i]);
//			for(int n : dp) 
//				System.out.printf("%d ", n);
//			System.out.println();
		}
		
		System.out.println(dp[K]);
	}
}
