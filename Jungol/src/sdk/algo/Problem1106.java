package sdk.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author whitebeard
 * @since 2016.07.22
 */
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
		
//		int n = 65;
//		int m = 75;
//		int r = 50;
//		int c = 11;
//		int s = 64;
//		int k = 56;
		
		xLength = n+1;
		yLength = m+1;

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { r, c, 0 });
		
		bfs(queue, s, k);
		
		System.out.println(min);
	}
	
	/**
	 * 
	 * 큐에 중복된 값이 있는지 확인 
	 * 
	 */
	public static boolean queueCheck(Queue<int[]> queue, int x, int y) {
		
		for(int[] item : queue) {
			if(item[0] == x && item[1] == y)
				return false;
		}
		
		return true;
	}
	
	/**
	 * x, y 값이 큐에입력될 수 있는 값인지 확인하고 입력한다. 
	 * min 을 넘어서는지도 확인한다. 
	 * 
	 */
	public static int check(int x, int y, int destX, int destY, int count,  Queue<int[]> queue) {
		if( 0 < x && x < xLength && 0 < y && y < yLength) {
			if(x == destX && y == destY) {
				min = min > count + 1? count + 1 : min;
				return 1;
			} else {
				if(min < count+1)
					return 1;
				
				if(queueCheck(queue, x, y))
					queue.add(new int[] { x, y, count+1 });
			}
		}
		
		return 0;
	}
	
	public static void bfs(Queue<int[]> queue, int destX, int destY) {
		
		int size = queue.size();
		
		// 장기말이 갈 수 있는 방향을 현재의 위치에 따라 구분하여 이동한다. 
		while(size-- > 0) {
			int[] location = queue.poll();
			int x = location[0];
			int y = location[1];
			int count = location[2];
			
			if(destX <= x && destY <= y) {
				check(x-2, y-1, destX, destY, count, queue);
				check(x-1, y-2, destX, destY, count, queue);
			}
			
			if(destX < x && destY == y) {
				check(x-1, y-2, destX, destY, count, queue);
				check(x-1, y+2, destX, destY, count, queue);
			}
			
			if(destX <= x && destY >= y) {
				check(x-2, y+1, destX, destY, count, queue);
				check(x-1, y+2, destX, destY, count, queue);
			}
			
			if(destX == x && destY > y) {
				check(x-2, y+1, destX, destY, count, queue);
				check(x+2, y+1, destX, destY, count, queue);
			}
			
			if(destX >= x && destY >= y) {
				check(x+2, y+1, destX, destY, count, queue);
				check(x+1, y+2, destX, destY, count, queue);
			}
			
			if(destX > x && destY == y) {
				check(x+1, y-2, destX, destY, count, queue);
				check(x+1, y+2, destX, destY, count, queue);
			}
			
			if(destX >= x && destY <= y) {
				check(x+2, y-1, destX, destY, count, queue);
				check(x+1, y-2, destX, destY, count, queue);
			}
			
			if(destX == x && destY < y) {
				check(x-2, y-1, destX, destY, count, queue);
				check(x+2, y-1, destX, destY, count, queue);
			}
		}
		
		if(min != Integer.MAX_VALUE)
			return;
		
		bfs(queue, destX, destY);
	}
}
