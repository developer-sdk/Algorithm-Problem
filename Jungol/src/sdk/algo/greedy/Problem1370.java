package sdk.algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 정올, 문제은행
 * 그리디 알고리즘
 * 1370 회의실 배정 문제 
 * 
 * @author seo
 *
 */
public class Problem1370 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] rooms = new int[n][3];
		for(int i = 0; i < n; i++) {
			rooms[i][0] = in.nextInt();
			rooms[i][1] = in.nextInt();
			rooms[i][2] = in.nextInt();
		}
		in.close();
		
//		int n = 6;
//		int[][] rooms = { { 1, 1, 10 },
//							{ 2, 5, 6 },
//							{ 3, 13, 15 },
//							{ 4, 14, 17 },
//							{ 5, 8, 14 },
//							{ 6, 3, 12 } };
		
		// 종료시간을 기준으로 오름차순으로 정렬 
		Arrays.sort(rooms, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[2] <= b[2] ? -1 : 1;
			}
		});
		
//		for(int[] room : rooms)
//			System.out.printf("%d %2d %2d\n", room[0], room[1], room[2]);
		
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(rooms[0]);
		
		for(int i = 1; i < rooms.length; i++) {
			
			if(list.get(list.size()-1)[2] <= rooms[i][1]) {
				list.add(rooms[i]);
			}
		}
		
		System.out.println(list.size());
		for(int[] room : list)
			System.out.printf("%d ", room[0]);
	}
}
