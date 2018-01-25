package sdk.backjun.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Problem1176 {

	static int N; // 문제의 수
	static int M; // 정보의 개수

	static LinkedList<Integer>[] list;
	static int[] in;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		in = new int[N + 1];

		list = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			list[from].add(to);
			in[to]++; // 인입 개수 확인
		}
		sc.close();

		Queue<Integer> queue = new PriorityQueue<>();
		for (int i = 1; i < N + 1; i++) {
			if (in[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int from = queue.poll();

			System.out.print(from + " ");

			for (int to : list[from]) {
				if (--in[to] == 0) {
					queue.add(to);
				}
			}
		}
	}
}