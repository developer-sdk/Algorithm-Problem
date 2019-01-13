package sdk.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준, 2003
 * 수들의 합 2 
 * 
 * @author whitebeard-k
 *
 */
public class Problem2003 {

	static int N;	// 수열의 개수 
	static int M;	// 합 
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;	// M이 되는 경우의 수 
		int sum = 0;
		int end = 0;
		for(int start = 0; start < N; start++) { 
			
			// sum에 값을 더함 
			sum += array[start];
			
			if(sum == M) {
				// M 값이 되면 count 증가 
				// sum에서 end위치의 값을 빼고, end 증가  
				count++;
				sum -= array[end++];
				
			} else if(sum > M) {
				// sum이 M을 넘어가면, M보다 작아질때까지 end위치의 값을 빼고, end 증가 
				while(sum > M) {
					sum -= array[end++];
					
					if(sum == M) 
						count++;
				}
			}
		}
		
		System.out.println(count);
	}
}