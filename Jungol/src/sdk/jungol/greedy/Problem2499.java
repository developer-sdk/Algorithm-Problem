package sdk.jungol.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Problem2499 {

	static TreeSet<Integer> set = new TreeSet<>();

	public static void main(String[] args) {

		int n = 7;
		int[] array = { 3, 1, 6, 2, 7, 30, 1 };

		Arrays.sort(array);

		for (int num : array)
			set.add(num);

		int[] testArray = { 1, 2, 3, 4, 5 };
		int[] visited = new int[5];

		combi(testArray, visited, 0, 3);
	}

	static ArrayList<Integer> list = new ArrayList<>();

	public static void combi(int[] array, int[] visited, int pivot, int size) {

		if (size == 0) {
			for (int num : list)
				System.out.printf("%2d", num);

			System.out.println();
			return;
		}

		for (int i = pivot; i < array.length; i++) {
			if (visited[i] == 1)
				continue;

			list.add(array[i]);
			visited[i] = 1;
			combi(array, visited, pivot + 1, size - 1);

			list.remove(list.size() - 1);

			visited[i] = 0;
		}
	}
}