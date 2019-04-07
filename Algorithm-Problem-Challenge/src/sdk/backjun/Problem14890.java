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

		int result = 0;

		result = checker(map);
		System.out.println("-------------");
		result += checker(reverseMap);
		System.out.println("-------------");
		System.out.println(result);
	}
	
	public static int checker(int[][] map) {
		
		boolean[][] isLadder = new boolean[N][N];
		
		int result = 0;
		
		for (int x = 0; x < N; x++) {

			boolean isEnable = true;
			
			for (int y = 0; y < N; y++) {

				if (y + 1 >= N)
					continue;

				int currentHeight = map[x][y];

				if (currentHeight == map[x][y + 1]) { 	// 현재 높이와 다음 높이가같으면 처리 없음 
					continue;
				} else if (currentHeight - map[x][y + 1] == 1) {	// 다음 높이가 1 낮으면 
					if (y + L < N && map[x][y + 1] == map[x][y + 2]) {	// 계단을 놓을 공간이 있고, 2개의 높이가 같으면 
						
						boolean isOk = true;
						for(int i = 2; i <= L; i++) {
							if(map[x][y+1] != map[x][y+i]) {
								isOk = false;
								break;
							}
						}
						
						if(isOk) {
							for(int i = 1; i <= L; i++) {
								isLadder[x][y+i] = true;
							}
							
							y += L-1;
							continue;
						}
						
					} else {
						isEnable = false;
						break;
					}
				} else if (currentHeight - map[x][y + 1] == -1) {	// 다음 높이가 1 높으면 
					if(y-L-1 >= 0) {
						
						boolean isOk = true;
						
						for(int i = 1; i < L; i++) {
							if(!(!isLadder[x][y-i] && currentHeight == map[x][y-i])) { 
								isOk = false;
								break;
							}
						}
						
						if(isOk) {
							for(int i = 0; i < L; i++) {
								isLadder[x][y-i] = true;
								continue;
							}
						}
						
					} else {
						isEnable = false;
						break;
					}
					
				} else if (Math.abs(currentHeight - map[x][y + 1]) >= 2) {
					isEnable = false;
					break;
				}
			}

			if(isEnable) {
				System.out.println(x);
				result++;
			}
				
		}
		
		return result;
	}
}
