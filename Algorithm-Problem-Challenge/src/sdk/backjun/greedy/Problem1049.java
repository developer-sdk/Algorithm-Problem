package sdk.backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준, 기타줄, 1049
 * 
 * @author whitebeard-k
 *
 */
public class Problem1049 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int minPackage = Integer.MAX_VALUE;
		int minOne = Integer.MAX_VALUE;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			
			minPackage = Math.min(minPackage, Integer.parseInt(st.nextToken()));
			minOne = Math.min(minOne, Integer.parseInt(st.nextToken()));
		}
		
		if(minOne * 6 < minPackage)
			minPackage = minOne * 6;
		
		int result = (N/6) * minPackage + Integer.min((N%6) * minOne, minPackage);
		
		System.out.println(result);
	}
}
