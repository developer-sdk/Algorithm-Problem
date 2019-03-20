package sdk.backjun.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준, 11505
 * 구간 곱 구하기 
 * 
 * @author whitebeard-k
 *
 */
public class Problem11505 {

	static int N;
	static int M;
	static int K;

	static int[] nums;
	static long[] tree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		nums = new int[N];

		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());

		int treeHeight = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = (int) Math.pow(2, treeHeight + 1);
		tree = new long[treeSize];

		init(1, 0, N - 1);

		int T = M + K;

		while (T-- > 0) {

			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			if (type == 1) {
				update(1, 0, N - 1, i - 1, j);
				nums[i - 1] = j;
			} else {
				long result = query(1, 0, N - 1, i - 1, j - 1);
				System.out.println(result);
			}
		}
	}

	public static void init(int node, int start, int end) {

		if (start == end) {
			tree[node] = nums[start] % 1000000007;
		} else {
			int half = (start + end) / 2;
			init(node * 2, start, half);
			init(node * 2 + 1, half + 1, end);

			tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % 1000000007;
		}
	}

	public static long query(int node, int start, int end, int i, int j) {

		if (j < start || end < i)
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
			return (m1 * m2) % 1000000007;
	}

	public static void update(int node, int start, int end, int index, int newValue) {

		if (start <= index && index <= end) {
			if (start == end) {
				tree[node] = newValue % 1000000007;
			} else {
				int half = (start + end) / 2;
				update(node * 2, start, half, index, newValue);
				update(node * 2 + 1, half + 1, end, index, newValue);

				tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % 1000000007;
			}
		}
	}
}