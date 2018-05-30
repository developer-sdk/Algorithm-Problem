package sdk.backjun.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 트리, 11725
 * 트리의 부모 찾기 
 * 
 * @author whitebeard-k
 *
 */
public class Problem11725 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Node[] nodes = new Node[N + 1];

		for (int i = 0; i < N - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (nodes[x] == null)
				nodes[x] = new Node();
			if (nodes[y] == null)
				nodes[y] = new Node();

			nodes[x].link.add(y);
			nodes[y].link.add(x);
		}
		sc.close();

		// 부모노드 표시를 위한 배열 
		int[] parent = new int[N + 1];
		parent[1] = 1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		

		while (true) {

			int size = queue.size();

			while (size-- > 0) {

				int current = queue.poll();

				LinkedList<Integer> link = nodes[current].link;

				for (int i : link) {

					if (nodes[current].link.contains(i) && parent[current] != i && parent[i] == 0) {
						parent[i] = current;
						queue.add(i);
					}
				}
			}

			if (queue.isEmpty())
				break;
		}

		for (int i = 2; i < parent.length; i++) {
			System.out.println(parent[i]);
		}
	}
}

class Node {
	LinkedList<Integer> link = new LinkedList<>();
}