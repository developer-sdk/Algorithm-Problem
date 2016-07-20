package sdk.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1106 {

	static int min = Integer.MAX_VALUE;
	static int xLength = 0;
	static int yLength = 0;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int r = in.nextInt();
		int c = in.nextInt();
		int s = in.nextInt();
		int k = in.nextInt();
		in.close();
		
//		int n = 9;
//		int m = 9;
//		int r = 3;
//		int c = 5;
//		int s = 2;
//		int k = 8;
		
		xLength = n+1;
		yLength = m+1;
//		int[][] array = new int[n+1][m+1];
//		array[r][c] = 1;
//		array[s][k] = 2;
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { r, c, 0 });
		
		bfs(queue, s, k);
		
//		for(int[] num : array) {
//			for(int ns : num) {
//				System.out.printf("%d ", ns);
//			}
//			System.out.println();
//		}
		
		System.out.println(min);
	}
	
	
	public static int check(int x, int y, int destX, int destY, int count,  Queue<int[]> queue) {
		if( 0 < x && x < xLength && 0 < y && y < yLength) {
			if(x == destX && y == destY) {
				min = min > count + 1? count + 1 : min;
				return 1;
			} else {
				if(min < count+1)
					return 1;
				
				queue.add(new int[] { x, y, count+1 });
			}
		}
		
		return 0;
	}
	
	public static void bfs(Queue<int[]> queue, int destX, int destY) {
		
		int size = queue.size();
		
		while(size-- > 0) {
			int[] location = queue.poll();
			int x = location[0];
			int y = location[1];
			int count = location[2];
			
			if(destX <= x && destY <= y) {
				// 좌상1
				if(check(x-2, y-1, destX, destY, count, queue) == 1) 
					return;
				
				if(check(x-1, y-2, destX, destY, count, queue) == 1)
					return;
			}
			
			if(destX <= x && destY >= y) {
				// 우
				if(check(x-2, y+1, destX, destY, count, queue) == 1)
					return;
				
				if(check(x-1, y+2, destX, destY, count, queue) == 1)
					return;
			}
			
			if(destX >= x && destY >= y) {
				if(check(x+2, y+1, destX, destY, count, queue) == 1)
					return;
				
				if(check(x+1, y+2, destX, destY, count, queue) == 1)
					return;
			}
			
			if(destX >= x && destY <= y) {
				if(check(x+2, y-1, destX, destY, count, queue) == 1)
					return;
				
				if(check(x+1, y-2, destX, destY, count, queue) == 1)
					return;
			}
		}
		
		bfs(queue, destX, destY);
	}
}
