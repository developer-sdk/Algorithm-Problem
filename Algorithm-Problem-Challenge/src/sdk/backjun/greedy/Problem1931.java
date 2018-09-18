package sdk.backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Problem1931 {

	static int size;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		int[][] meetings  = new int[size][2];
		
		// 데이터 입력 
		for(int i = 0; i < size; i++) {
			String[] datas = br.readLine().split(" ");
			
			meetings[i][0] = Integer.parseInt(datas[0]);
			meetings[i][1] = Integer.parseInt(datas[1]);
		}
		
		// 종료 시간으로 정렬 
		Arrays.sort(meetings, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				
				if(a[1] < b[1]) {
					return -1;
				} else if(a[1] == b[1]) {
					return a[0] <= b[0] ? -1 : 1;
				} 
				
				return 1;
			}
			
		});
		
		int count = 1;
		int[] prev = meetings[0];
		for(int i = 1; i < size; i++) {
			
			if(prev[1] <= meetings[i][0]) {
				count++;
				prev = meetings[i];
			}
		}
		
		System.out.println(count);
	}
}