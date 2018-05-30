package sdk.backjun.graph;

import java.util.Scanner;

/**
 * 백준, 11404
 * 플로이드
 * 
 * @author whitebeard-k
 *
 */
public class Problem11404 {
	static int N;
	static int M;
	
	static int[][] maps;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		maps = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			
			// 거리중 최소값으로 입력 
			if(maps[from][to] == 0) {
				maps[from][to] = cost;
			} else {
				maps[from][to] = Math.min(cost, maps[from][to]);
			}
		}
		
		sc.close();
		
		for(int mid = 1; mid <= N; mid++){ 
			
			for(int start = 1; start <= N; start++){ 
				
				if(maps[start][mid] == 0)	// 연결이 안되면 처리 안함 
					continue;
				
				for(int end = 1; end <= N; end++){ 
					
					if(maps[mid][end] == 0 || start == end)
						continue;
					
					// 중간 경로를 거쳐 가는 것이 그냥 가는것보다 빠르면 수정 
					if(maps[start][end] == 0 || maps[start][end] > maps[start][mid] + maps[mid][end]) {
						maps[start][end] = maps[start][mid] + maps[mid][end];
					}
				}
			}
		}
		
		for(int x = 1; x <= N; x++){ 
			for(int y = 1; y <= N; y++) {
				System.out.printf("%d ", maps[x][y]);
			}
			
			System.out.println();
		}
	}
}
