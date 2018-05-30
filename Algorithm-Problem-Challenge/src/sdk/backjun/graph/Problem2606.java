package sdk.backjun.graph;

import java.util.Scanner;

/**
 * 백준, 2606
 * 바이러스
 * 유니온 파인드로 해결
 * 
 * @author whitebeard-k
 *
 */
public class Problem2606 {

	static int N;
	static int M;
	static int[] parent;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		while (M-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			union(x, y);
		}

		sc.close();

		int count = 0;
		int root = find(1);
		for (int i = 2; i <= N; i++)
			if (find(i) == root)
				count++;

		System.out.println(count);
	}

	public static int find(int x) {

		if (x == parent[x])
			return x;

		int root = find(parent[x]);
		parent[x] = root;
		return root;
	}

	public static void union(int x, int y) {

		x = find(x);
		y = find(y);

		if (x != y)
			parent[y] = x;
	}
}
