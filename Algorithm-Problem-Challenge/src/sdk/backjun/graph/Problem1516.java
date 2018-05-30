package sdk.backjun.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 게임개발, 위상정렬 1516
 * 
 * @author whitebeard-k
 *
 */
public class Problem1516 {

	static int N;
	static int[] in;
	static int[] cost;
	static int[] time;
	static LinkedList<Integer>[] list;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		in = new int[N + 1];
		cost = new int[N + 1];
		time = new int[N + 1];
		list = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			cost[i] = sc.nextInt();

			while (true) {
				int need = sc.nextInt();

				if (need == -1)
					break;

				list[need].add(i);
				in[i]++;
			}
		}
		sc.close();

		Queue<Integer> queue = new LinkedList<>();

		// 인입 간선이 0인 노드로 초기화
		for (int i = 1; i <= N; i++) {
			if (in[i] == 0) {
				queue.add(i);
				time[i] = cost[i];
			}
		}

		while (!queue.isEmpty()) {

			int from = queue.poll();

			for (int to : list[from]) {

				if (time[to] < time[from] + cost[to])
					time[to] = time[from] + cost[to];

				if (--in[to] == 0) {
					queue.add(to);
				}
			}
		}

		for (int i = 1; i <= N; i++)
			System.out.println(time[i]);
	}
}
