package sdk.dovlet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Koi_Delivery {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		int m = in.nextInt();
		
		int[][] array = new int[m][3];
		for(int i = 0; i < m; i++) {
			array[i][0] = in.nextInt();
			array[i][1] = in.nextInt();
			array[i][2] = in.nextInt();
		}
		in.close();
		
//		int n = 4; 
//		int c = 40;
//		int m = 6;
//		int[][] array = { 	{ 3, 4, 20 },
//							{ 1, 2, 10 },
//							{ 1, 3, 20 },
//							{ 1, 4, 30 },
//							{ 2, 3, 10 },
//							{ 2, 4, 20 } };
		
		// 도착지점 기준으로 정렬 
		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return (a[1] <= b[1]) ? -1 : 1;
			}
		});
		
		// 남은 용량 확인을 위한 배열 
		int[] capacity = new int[n+1];
		Arrays.fill(capacity, c);
		
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			
			int dept = array[i][0];
			int arri = array[i][1];
			int box = array[i][2];
			
			sum += getBox(capacity, dept+1, arri, box);
		}
		
		System.out.println(sum);
	}
	
	public static int getBox(int[] capacity, int start, int end, int box) {
		
		// 시작점에서 종료까지 남은 최저값 확인 
		int min = Integer.MAX_VALUE;
		for(int i = start; i <= end; i++) {
			if(capacity[i] < min) {
				min = capacity[i];
			}
		}
		
		// 최저값과 배송할 값을 비교하여 실을 값 확인 
		int result = 0;
		if(min > box) {
			result = box;
		} else {
			result = min;
		}
		
		// 남은 용량에서 제거 
		for(int i = start; i <= end; i++) {
			capacity[i] -= result;
		}
		
		return result;
	}
}
