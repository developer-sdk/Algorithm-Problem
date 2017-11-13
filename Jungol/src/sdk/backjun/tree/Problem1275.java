package sdk.backjun.tree;

import java.util.Scanner;

/**
 * 백준, 1275 
 * 커피숍2 
 * 
 * @author whitebeard-k
 *
 */
public class Problem1275 {

	static int N;
	static int Q;
	static long[] nums;
	static long[] tree;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Q = sc.nextInt();

		// 배열 초기화 
		nums = new long[N];
		for (int i = 0; i < N; i++)
			nums[i] = sc.nextLong();

		// 트리 초기화 
		int treeHeight = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = (int) Math.pow(2, treeHeight + 1);
		tree = new long[treeSize];
		init(1, 0, N - 1);

		while (Q-- > 0) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int a = sc.nextInt() - 1;
			long b = sc.nextInt();

			if (x > y) {
				int tmp = x;
				x = y;
				y = tmp;
			}

			System.out.println(query(1, 0, N - 1, x, y));
			update(1, 0, N - 1, a, b - nums[a]);
			nums[a] = b;
		}

		sc.close();
	}

	public static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = nums[start];
		} else {
			int half = (start + end) / 2;
			init(node * 2, start, half);
			init(node * 2 + 1, half + 1, end);

			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
	}

	public static void update(int node, int start, int end, int index, long diff) {

		if (!(start <= index && index <= end))
			return;

		tree[node] += diff;

		if (start != end) {
			int half = (start + end) / 2;
			update(node * 2, start, half, index, diff);
			update(node * 2 + 1, half + 1, end, index, diff);
		}
	}

	public static long query(int node, int start, int end, int i, int j) {

		if (i > end || j < start)
			return -1;

		if (i <= start && end <= j)
			return tree[node];

		int half = (start + end) / 2;
		long m1 = query(node * 2, start, half, i, j);
		long m2 = query(node * 2 + 1, half + 1, end, i, j);

		if (m1 == -1)
			return m2;
		else if (m2 == -1)
			return m1;
		else
			return m1 + m2;	// 범위 안의 값을 더해줌 
	}

}