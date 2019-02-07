package sdk.backjun.bfs;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준, 14501
 * 퇴사 
 * 
 * @author whitebeard-k
 *
 */
public class Problem14501 {

	public static int N;
	public static int[][] point; // 0: 기간, 1: 금액
	public static int[] maxs;
	public static Queue<Profit> queue = new LinkedList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		N = sc.nextInt();
		point = new int[2][N + 1];
		maxs = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			point[0][i] = sc.nextInt();
			point[1][i] = sc.nextInt();
		}

		sc.close();

		queue.add(new Profit(1, 0)); // 시작 위치
		bfs();
		System.out.println(maxs[N + 1]);
	}

	public static void bfs() {

		while (!queue.isEmpty()) {

			Profit current = queue.poll();
			int location = current.location;

			// 퇴사날에 도달하면 처리 안함
			if (location == N + 1)
				continue;

			// 현재위치의 상담 기간과 이익
			int locations_duration = point[0][current.location];
			int locations_profit = point[1][current.location];

			// 일을 할 때
			int nextLocation = location + locations_duration;
			int nextProfit = current.profit + locations_profit;

			work(nextLocation, nextProfit);

			// 일을 하지 않을 때
			nextLocation = location + 1;
			nextProfit = current.profit;

			work(nextLocation, nextProfit);
		}
	}

	public static void work(int nextLocation, int nextProfit) {
		if (nextLocation <= N + 1 && maxs[nextLocation] <= nextProfit) {
			queue.add(new Profit(nextLocation, nextProfit));
			maxs[nextLocation] = nextProfit;
		}
	}
}

class Profit {
	public int location;
	public int profit;

	public Profit(int location, int profit) {
		this.location = location;
		this.profit = profit;
	}

	@Override
	public String toString() {
		return location + " " + profit;
	}
}