package sdk.backjun.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준, 1005, ACM Craft
 * 
 * @author whitebeard
 *
 */
public class Problem1005 {

	static int T; 	// 테스트 케이스 개수
	static int N; 	// 건물의 개수
	static int K; 	// 건설 순서 규칙
	static int W;	// 최종 생성 건물 

	static int[] cost;	// 비
	static int[] in;	// 인입간
	static int[] value;	// 메모 

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		while (T-- > 0) {
			N = sc.nextInt();
			K = sc.nextInt();

			cost = new int[N + 1];
			in = new int[N + 1];
			value = new int[N + 1];

			for (int i = 1; i <= N; i++)
				cost[i] = sc.nextInt();

			LinkedList<Integer>[] list = new LinkedList[N + 1];
			for (int i = 1; i <= N; i++)
				list[i] = new LinkedList<Integer>();	// 리스트 초기화 

			for (int i = 0; i < K; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				list[from].add(to);	// from -> to 간선 표현 
				in[to]++;	// 인입간선 
			}

			W = sc.nextInt();

			Queue<Integer> queue = new LinkedList<>();

			// 시작 정점 설정 
			for (int i = 1; i < N + 1; i++) {
				if (in[i] == 0) {
					queue.add(i);
					value[i] = cost[i];
				}
			}

			while (!queue.isEmpty()) {

				int from = queue.poll();

				for (int to : list[from]) {

					// 다음 건물의 생성 시간을 설정 
					// from 까지 걸린 시간과 to 건물을 생성하는데 걸리는 시간의 합을 구하여 to 건물 생성에 걸린시간을 처리 
					value[to] = Math.max(value[to], value[from] + cost[to]);

					if (--in[to] == 0)
						queue.add(to);

				}

			}

			System.out.println(value[W]);
		}
		
		sc.close();
	}
}