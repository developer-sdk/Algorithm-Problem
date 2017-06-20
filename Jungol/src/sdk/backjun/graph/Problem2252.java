package sdk.backjun.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준, 2252, 위상정렬, 줄세우기
 * 
 * @author whitebeardk
 *
 */
public class Problem2252 {

	static int N; // 문제의 수
	static int M; // 정보의 개수
	static HashMap<Integer, LinkedList<Integer>> maps = new HashMap<>();
	static int[] in;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		in = new int[N + 1];

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			if (!maps.containsKey(from)) {
				LinkedList<Integer> list = new LinkedList<>();
				maps.put(from, list);
			}

			maps.get(from).add(to);
			in[to]++;
		}
		sc.close();

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (in[i] == 0)
				queue.offer(i);
		}

		while (true) {
			if (queue.size() == 0)
				break;

			int from = queue.poll();

			System.out.print(from + " ");

			if (maps.containsKey(from)) {
				for (int to : maps.get(from)) {

					if (--in[to] == 0)
						queue.add(to);

				}
			}
		}

	}
}