package sdk.backjun.tree;

import java.util.Scanner;

/**
 * 백준, 6549
 * 히스토그램에서 가장 큰 직사각형 
 * 
 * @author whitebeard-k
 *
 */
public class Problem6549 {

	static int N;
	static int[] nums;
	static int[] tree;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			N = sc.nextInt();

			if (N == 0)
				break;

			nums = new int[N];

			for (int i = 0; i < N; i++)
				nums[i] = sc.nextInt();

			int treeHeight = (int) Math.ceil(Math.log(N) / Math.log(2));
			int treeSize = (int) Math.pow(2, treeHeight + 1);
			tree = new int[treeSize];
			init(1, 0, N - 1);

			long ans = largest(0, N - 1);
			System.out.println(ans);
		}

		sc.close();
	}

	public static void init(int node, int start, int end) {

		if (start == end) {
			tree[node] = start;
		} else {
			int half = (start + end) / 2;
			int left = node * 2;
			int right = left + 1;
			init(left, start, half);
			init(right, half + 1, end);

			if (nums[tree[left]] <= nums[tree[right]]) {
				tree[node] = tree[left];
			} else {
				tree[node] = tree[right];
			}
		}
	}

	public static int query(int node, int start, int end, int i, int j) {
		if (i > end || j < start) {
			return -1;
		}
		
		if (i <= start && end <= j) {
			return tree[node];
		}
		
		int half = (start + end) / 2;
		int m1 = query(2 * node, start, half, i, j);
		int m2 = query(2 * node + 1, half + 1, end, i, j);
		
		if (m1 == -1) 
			return m2;
		else if (m2 == -1) 
			return m1;
		else {
			if (nums[m1] <= nums[m2]) {
				return m1;
			} else {
				return m2;
			}
		}
	}

	public static long largest(int start, int end) {

		int m = query(1, 0, N - 1, start, end);
		
		long area = (long) (end - start + 1) * (long) nums[m];
		
		if (start <= m - 1) {
			long temp = largest(start, m - 1);
			if (area < temp) {
				area = temp;
			}
		}
		
		if (m + 1 <= end) {
			long temp = largest(m + 1, end);
			if (area < temp) {
				area = temp;
			}
		}
		
		return area;
	}
}
