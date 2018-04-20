package sdk.backjun.graph;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 백준, 1922
 * MST 최소 스패닝 트리, 프림 알고리즘 
 * 
 * @author whitebeard-k
 *
 */
public class Problem1922 {

	static int N;
	static int M;

	static boolean checked[];
	static LinkedList<PrimNode> list[];

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		list = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new LinkedList<>();

		checked = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();

			list[from].add(new PrimNode(to, cost));
			list[to].add(new PrimNode(from, cost));
		}

		sc.close();

		checked[1] = true;

		int selected = 1;
		int sum = 0;

		while (selected != N) {

			PrimNode minNode = null;

			for (int i = 1; i <= N; i++) {

				if (checked[i]) {

					for (PrimNode node : list[i]) {

						if (!checked[node.to]) {
							if (minNode == null)
								minNode = node;
							else {
								if (minNode.cost > node.cost)
									minNode = node;
							}
						}
					}
				}
			}

			checked[minNode.to] = true;
			sum += minNode.cost;
			selected++;
		}

		System.out.println(sum);
	}
}

class PrimNode {

	int to;
	int cost;

	public PrimNode(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}
}
