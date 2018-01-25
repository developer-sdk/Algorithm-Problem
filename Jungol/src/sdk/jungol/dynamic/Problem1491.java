package sdk.jungol.dynamic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem1491 {

	static int CAR_DIST;
	static int N;
	static int[] dist;
	static int[] time;
	static int[] dpTime;
	static int[] dpStation;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CAR_DIST = sc.nextInt();
		N = sc.nextInt();

		int distSum = 0;
		dist = new int[N + 2];
		for (int i = 1; i <= N + 1; i++) {
			dist[i] = sc.nextInt();
			distSum += dist[i];
		}

		time = new int[N + 2];
		for (int i = 1; i <= N; i++)
			time[i] = sc.nextInt();

		dpTime = new int[N + 2];
		dpStation = new int[N + 2];
		sc.close();

		if (CAR_DIST >= distSum) {
			System.out.println(0);
			return;
		}

		for (int i = 1; i < dist.length; i++) {

			int currentDist = CAR_DIST - dist[i];
			int currentTime = time[i];
			int min = Integer.MAX_VALUE;

			for (int j = i - 1; j >= 0; j--) {

				if (currentDist < 0)
					break;

				if (currentDist >= 0 && min >= dpTime[j] + currentTime) {
					min = dpTime[j] + currentTime;
					dpStation[i] = j;
				}

				currentDist -= dist[j];
			}

			dpTime[i] = min;
		}

		// System.out.println("dist -------------");
		//
		// for (int n : dist)
		// System.out.printf("%3d ", n);
		//
		// System.out.println("\ntime -------------");
		//
		// for (int n : time)
		// System.out.printf("%3d ", n);
		//
		// System.out.println("\ndpTime -------------");
		//
		// for (int n : dpTime)
		// System.out.printf("%3d ", n);
		//
		// System.out.println("\ndpStation -------------");
		//
		// for (int n : dpStation)
		// System.out.printf("%3d ", n);

		System.out.println(dpTime[N + 1]);

		LinkedList<Integer> list = new LinkedList<>();
		int index = N + 1;
		while (true) {

			int station = dpStation[index];

			if (station == 0)
				break;

			list.add(station);
			index = station;
		}

		System.out.println(list.size());
		Collections.reverse(list);

		for (int n : list)
			System.out.printf("%d ", n);
	}
}