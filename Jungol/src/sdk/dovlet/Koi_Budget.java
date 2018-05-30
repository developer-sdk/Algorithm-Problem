package sdk.dovlet;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://59.23.113.171/pool/koi_budget/koi_budget.php?pname=koi_budget
 * 더블릿, 예산 
 * 
 * @author whitebeard
 *
 */
public class Koi_Budget {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        
        for(int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        
        int m = in.nextInt();
        in.close();
        
//        int n = 5;
//        int[] array = { 6765, 13607, 19375, 26673, 30390 };
//        int m = 96812;
        
        // 정렬
        Arrays.sort(array);
        
        int sum = 0;
        for(int i = 0; i < n; i++) {
            
            array[i] -= sum;
            int num = n-i;
            int minBudget = array[i];
            
            // 최소 예산 * 남은 예산안이 예산 총액보다 크면 
            // 남은 예산안으로 나누어 주고 종료
            if(num*minBudget > m) {
                minBudget = m/num;
                sum += minBudget;
                break;
            }
            
            // 최소 예산안을 나누어 준다.
            sum += minBudget;
            m -= num*minBudget;
            array[i] -= sum;
            
            System.out.printf("%3d %3d %3d %3d\n", num, minBudget, sum, m);
        }
        
        System.out.println(sum);
    }
}
