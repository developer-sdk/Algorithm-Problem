package sdk.jungol.greedy;

import java.util.Scanner;

/**
 * 동전자판기 하 
 * 
 * 가지고 있는 동전으로 구할 수 있는 최대 개수의 동전을 구하고 
 * 남은 동전이 최소의 동전 개수이다. 
 * 
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=466&sca=3020
 * http://m.blog.naver.com/skyblue_2002/220631970001
 * 
 * @author whitebeard
 *
 */
public class Problem1183 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] coins = new int[6];
		for(int i = 0; i < 6; i++) 
			coins[i] = in.nextInt();
		in.close();
		
//		int n = 212;
//		int[] coins = { 4, 2, 0, 4, 3, 4 };
		
		int[] values = { 500, 100, 50, 10, 5, 1 };
		int max = 0;
		for(int i = 0; i < 6; i++ ) {
			max += values[i] * coins[i];
		}
		max -= n;
		
		int index = 0;
		while(true) {
			
			if(max <= 0) {
				break;
			}
			
			if(coins[index] == 0 || max < values[index]) {
				index++;
				continue;
			}
				
			max -= values[index];
			coins[index]--;
		}
		
		int sum = 0;
		for(int coin : coins)
			sum += coin;
		
		System.out.println(sum);
		for(int coin : coins)
			System.out.printf("%d ", coin);
	}
}
