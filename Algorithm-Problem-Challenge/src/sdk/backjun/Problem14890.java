package sdk.backjun;

import java.util.Scanner;

/**
 * 백준, 14890, 경사로
 * 
 * @author whitebeard-k
 *
 */
public class Problem14890 {

	static boolean[][] isLadder;
	static int[][] map;
	static int[][] reverseMap;
	static int N;
	static int L;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();

		map = new int[N][N];
		reverseMap = new int[N][N];
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				map[x][y] = sc.nextInt();
				reverseMap[y][x] = map[x][y]; 
			}
		}
		
		sc.close();

		int result = 0;
		result = checker(map);
		result += checker(reverseMap);
		System.out.println(result);
	}
	
	public static int checker(int[][] map) {
		
		int result = 0;
		
		for (int x = 0; x < N; x++) {
			result += innserChecker(map[x]);	// 이중배열의 한 행만 전달 
		}
		
		return result;
	}

	private static int innserChecker(int[] is) {
		
		boolean[] isLadder = new boolean[N];
		
		for(int i = 0; i < N-1; i++) {
			
			int current = is[i];
			
			if(current == is[i+1]) {
				continue;
			} else {
				if(Math.abs(current - is[i+1]) != 1) {	// 높이차가 1이 아니면 종료 
					return 0;
				} else {
					
					if(current - is[i+1] == 1) {	// 낮아지면
						
						if(i + L >= N)
							return 0;
						
						for(int k = 1; k <= L; k++) {
							if(is[i+1] != is[i+k]) {
								return 0;
							}
						}
						
						for(int k = 1; k <= L; k++) {
							isLadder[i+k] = true;
						}
						
						i += L-1;
					} else {	// 높아지면 
						
						if(i - L + 1 < 0)
							return 0;
						
						for(int k = 0; k < L; k++) {
							if(isLadder[i-k] || is[i] != is[i-k]) {
								return 0;
							}
						}
						
						for(int k = 0; k < L; k++) {
							isLadder[i-k] = true;
						}
					}
				}
			}
		}
		
		return 1;
	}
}