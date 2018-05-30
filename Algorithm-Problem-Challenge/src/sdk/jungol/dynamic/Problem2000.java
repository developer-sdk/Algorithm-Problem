package sdk.jungol.dynamic;

import java.util.Scanner;

/**
 * 2000, 다이나믹
 * 동전교환
 * 
 * @author whitebeard
 *
 */
public class Problem2000 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int N = in.nextInt();	// 동전의 단계수 
        int[] coins = new int[N];	// 동전 
        for (int i = 0; i < N; i++) {
            coins[i] = in.nextInt();
        }
        int W = in.nextInt();	// 잔돈 
        in.close();
 
        int[] values = new int[W + 1];
 
        for (int currentValue = 1; currentValue < values.length; currentValue++) {
 
            int MIN = Integer.MAX_VALUE;
 
            for (int k = 0; k < N; k++) {
 
            	// 동전의 값과 일치하면 1로 설정 
                if (currentValue == coins[k]) {
                    MIN = 1;
                    break;
                } else if (currentValue > coins[k] && currentValue - coins[k] > 0) {
                	// 현재의 동전의 뺀값에 동전이 존재하면 현재보다 작은지 확인하여 최소값이면 MIN으로 설정 
                    if (values[currentValue - coins[k]] != 0)
                        MIN = (values[currentValue - coins[k]] + 1 < MIN) ? values[currentValue - coins[k]] + 1 : MIN ;
                }
            }
 
            // 최소값을 설정 
            values[currentValue] = MIN == Integer.MAX_VALUE ? 0 : MIN;
        }
 
//      for(int n : values)
//          System.out.printf("%d ", n );
         
        System.out.println(values[W] == 0 ? "impossible" : values[W]);
	}
}
