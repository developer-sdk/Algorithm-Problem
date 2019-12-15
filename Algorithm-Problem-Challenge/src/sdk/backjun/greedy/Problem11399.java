package sdk.backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem11399 {

	public static int N;
	public static int[] times;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		times = new int[N];

		String strTimes = br.readLine();
		String[] strs = strTimes.split(" ");
		for (int i = 0; i < N; i++)
			times[i] = Integer.parseInt(strs[i]);

		Arrays.sort(times);
		int sum = 0;
		int temp = 0;
		for (int time : times) {
			temp += time;
			sum += temp;
		}

		System.out.println(sum);
	}

}
