package sdk.jungol.backtrack;

import java.util.Scanner;

/**
 * 백트래킹, 좋은수열
 * 
 * @author whitebeard
 *
 */
public class Problem1027 {

	public static boolean isEnd = false;
	public static int N = 7;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		in.close();
		
		perm("", 0);
	}
	
	public static void perm(String path, int size) {
		
		// 좋은 수열인지 체크 
		if(!check(path, path.length()/2)) {
			return;
		}
		
		// 원하는 사이즈를 확인하면 종료 
		if(size == N) {	
			System.out.println(path);
			isEnd = true;
			return;
		}
		
		for(int i = 1; i < 4; i++) {
			
			perm(path + i, size+1);
			
			if(isEnd)
				return;
		}
	}
	
	public static boolean check(String path, int checkSize) {
		
		if(checkSize == 0 || path.length() == 1)
			return true;
		
		// 뒤에서 부터 1, 2, 3... 순서대로 나눠서 좋은 수열인지 확인한다. 
		if(path.substring(path.length()-checkSize, path.length()).equals(path.substring(path.length()-(checkSize*2), path.length()-checkSize))) {
			return false;
		} else 
			return check(path, checkSize-1);
	}
}
