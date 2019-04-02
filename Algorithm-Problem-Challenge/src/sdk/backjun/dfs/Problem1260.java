package sdk.backjun.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준, 1260, DFS와 BFS
 * 
 * @author whitebeard-k
 *
 */
public class Problem1260 {

	public static int N; // 정점의 개수
	public static int M; // 간선의 개수
	public static int V; // 시작 정점 번호

	public static boolean[] visited;	// 방문여부 
	public static int[][] link;			// 간선 연결 

	public static StringBuilder builder;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		link = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			link[start][end] = 1;
			link[end][start] = 1;
		}

		builder = new StringBuilder();

		// DFS 탐색 
		dfs(V);
		System.out.println(builder.toString());

		// 초기화 
		builder.setLength(0);
		Arrays.fill(visited, false);

		// BFS 탐색 
		bfs(V);
		System.out.println(builder.toString());
	}

	public static void dfs(int vertex) {

		visited[vertex] = true;
		builder.append(vertex).append(" ");

		for (int i = 1; i <= N; i++) {
			if (link[vertex][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int start) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		builder.append(start).append(" ");

		while (!queue.isEmpty()) {

			int vertex = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (link[vertex][i] == 1 && !visited[i]) {
					builder.append(i).append(" ");
					visited[i] = true;
					queue.add(i);
				}
			}
		}

	}
}
