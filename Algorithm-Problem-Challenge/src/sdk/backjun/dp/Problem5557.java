package sdk.backjun.dp;

import java.util.Scanner;

/**
 * 백준, 5557
 * 1학년 
 * 
 * @author whitebeard-k
 *
 */
public class Problem5557 {

	static int N;
	static int[] nums;
	static long[][] memo;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		nums = new int[N+1];
		memo = new long[21][N+1];	// 20 이하의 수만 처리 
		
		for(int i = 1; i <= N; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
		
		memo[nums[1]][1] = 1;
		
		for(int y = 1; y < N-1; y++){ 
			
			for(int num = 0; num <= 20; num++) {
				
				if(memo[num][y] != 0) {
					
					if(num + nums[y+1] <= 20) {
						memo[num + nums[y+1]][y+1] += memo[num][y];
					}
					
					if(0 <= num - nums[y+1]) {
						memo[num - nums[y+1]][y+1] += memo[num][y];
					}
				}
			}
		}
		
		System.out.println(memo[nums[N]][N-1]);
	}
}
