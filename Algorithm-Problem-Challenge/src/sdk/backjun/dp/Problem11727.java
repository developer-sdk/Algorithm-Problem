package sdk.backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2×n 타일링 2
 * 백준, 11727
 *
 */
public class Problem11727
{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(1);
            return;
        }

        if(N == 2) {
            System.out.println(3);
            return;
        }

        int[] memo = new int[N+1];

        memo[1] = 1;
        memo[2] = 3;

        for(int i = 3; i <= N; i++) {
            int type1 = memo[i-1];
            int type2 = memo[i-2];
            int type3 = memo[i-2];
            memo[i] = (type1 + type2 + type3) % 10007;
        }

        System.out.println(memo[N]);
    }
}