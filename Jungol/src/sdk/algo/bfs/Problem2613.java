package sdk.algo.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BFS, 토마토(고) 
 * 
 * @author whitebeard
 *
 */
public class Problem2613 {

	public static int count = 0;
	public static int tomato = 0;
	
	public static int X;
	public static int Y;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int y = in.nextInt();
		int x = in.nextInt();

		X = x;
		Y = y;
		
		int[][] array = new int[x][y];
		Queue<int[]> queue = new LinkedList<int[]>();

		int totalSize = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				array[i][j] = in.nextInt();

				if (array[i][j] == 0)
					totalSize++;
				else if (array[i][j] == 1)
					queue.add(new int[] { i, j });
			}
		}
		in.close();

//		 int y = 6;
//		 int x = 4;
//		 
//		 X = x;
//		 Y = y;
//		 Queue<int[]> queue = new LinkedList<int[]>();
//		 
//		 int[][] array = { { 0, 0, 0, 0, 0, 0 },
//		 { 0, 0, 0, 0, 0, 0 },
//		 { 0, 0, 0, 0, 0, 0 },
//		 { 0, 0, 0, 0, 0, 1 } };
//
//		 int totalSize = 23;
//		 queue.add(new int[] { 3, 5 });

		bfs(array, queue);

		if (tomato == totalSize)
			System.out.println(count);
		else
			System.out.println(-1);
	}

	public static void bfs(int[][] array, Queue<int[]> queue) {

		int size = queue.size();

		while (size-- > 0) {

			int[] node = queue.poll();
			int x = node[0];
			int y = node[1];

			input(x-1, y, array, queue);
			input(x+1, y, array, queue);
			input(x, y-1, array, queue);
			input(x, y+1, array, queue);	
		}

		if (queue.size() != 0) {
			count++;
			bfs(array, queue);
		}
	}
	
	public static void input(int x, int y, int[][] array, Queue<int[]> queue) {
		
		if( 0 <= x && x < X && 0 <= y && y < Y && array[x][y] == 0 && !checkDup(x, y, queue)) {
			queue.add(new int[] { x, y });
			array[x][y] = 1;
			tomato++;
		}
	}

	public static boolean checkDup(int x, int y, Queue<int[]> queue) {
		for (int[] num : queue) {
			if (num[0] == x && num[1] == y)
				return true;
		}

		return false;
	}
}