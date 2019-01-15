package sdk.backjun;

import java.util.Scanner;

/**
 * 백준, 14889
 * 스타트와 링크 
 * 
 * @author whitebeard-k
 *
 */
public class Problem14889 {

	static int MIN = Integer.MAX_VALUE;
	static int N;
	static int[][] ability;
	static int[] team;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		team = new int[N + 1];
		ability = new int[N + 1][N + 1];

		for (int x = 1; x <= N; x++)
			for (int y = 1; y <= N; y++)
				ability[x][y] = sc.nextInt();

		sc.close();

		selectTeam(1, 0);
		System.out.println(MIN);
	}

	// 팀선택
	public static void selectTeam(int pivot, int count) {

		if (count == N / 2) {
			// 인원수 만큼 선택하면 계산
			calcAbility();
			return;
		}

		for (int i = pivot; i <= N; i++) {

			team[i] = 1;
			selectTeam(i + 1, count + 1);
			team[i] = 0;

			// 첫번째 선택은 한번만 돌면 팀선택은 완료됨
			if (count == 0)
				break;
		}
	}

	public static void calcAbility() {
		int teamA = 0;
		int teamB = 0;

		for (int player = 1; player <= N; player++) {
			int x = team[player];

			for (int coPlayer = 1; coPlayer <= N; coPlayer++) {

				int y = team[coPlayer];

				if (x == y && x == 0) {
					teamA += ability[player][coPlayer];
				} else if (x == y && x == 1) {
					teamB += ability[player][coPlayer];
				}
			}
		}

		MIN = Math.min(MIN, Math.abs(teamA - teamB));
	}
}
