package sdk.jungol.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 정올, 2261
 * 경로 찾기 
 * 
 * @author whitebeard
 *
 */
public class Problem2261 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		String[] array = new String[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.next();
		}
		int start = in.nextInt();
		int end = in.nextInt();
		in.close();

//		 int n = 5;
//		 int k = 3;
//		
//		 String[] array = { "000",
//		 "111",
//		 "010",
//		 "110",
//		 "001"};
//		 int start = 1;
//		 int end = 2;

		// 경로 표현을 위한 리스트 
		ArrayList<Integer> path = new ArrayList<>();
		path.add(start - 1);
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(start - 1, path));
		
		// 방문한 곳 처리를 위한 배열 
		int[] visit = new int[n];
		visit[start-1] = 1;
		
		// 검색 시작 
		bfs(array, queue, visit, end - 1);
	}

	public static void bfs(String[] array, Queue<Node> queue, int[] visit, int end) {

		int size = queue.size();

		if (size == 0) {
			// 더이상 갈 곳이 없으면 종
			System.out.println("-1");
			return;
		}

		while (size-- > 0) {

			Node location = queue.poll();
			String aa = array[location.i];

			for (int i = 0; i < array.length; i++) {
				
				// 자신의 위치, 방문한곳, 해밍코드가 아니면 처리 안함 
				if (i == location.i || visit[i] == 1 || checkPrev(location.path, i) || isHaming(aa, array[i]))
					continue;

				if (end == i) {
					location.path.add(i);
					for (int num : location.path)
						System.out.printf("%d ", num + 1);

					return;
				}

				visit[i] = 1;
				ArrayList<Integer> path = new ArrayList<>();
				path.addAll(location.path);
				path.add(i);
				queue.add(new Node(i, path));
			}
		}

		bfs(array, queue, visit, end);
	}

	private static boolean checkPrev(ArrayList<Integer> path, int i) {
		for (int num : path)
			if (num == i)
				return true;

		return false;
	}

	// 해밍 코드인지 확인 
	public static boolean isHaming(String a, String b) {

		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();

		int count = 0;

		for (int i = 0; i < aa.length; i++) {
			if (aa[i] != bb[i]) {
				count++;
				
				if(count >= 2)
					break;
			}
				
		}

		if(count == 1)
			return false;
		
		return true;
	}
}

class Node {
	public int i = -1;
	public ArrayList<Integer> path = new ArrayList<>();

	public Node(int i, ArrayList<Integer> path) {
		this.i = i;
		this.path = path;
	}
}