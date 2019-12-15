package sdk.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem6603 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		while (true) {
			String str = br.readLine();

			if (str.equals("0"))
				break;
			else {
				String result = lotto(str);
				sb.append(result).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	public static String lotto(String str) {
		StringBuffer sb = new StringBuffer();
		pick(sb, "", str.split(" "), 0, 0);
		return sb.toString();
	}

	public static void pick(StringBuffer sb, String str, String[] strs, int index, int length) {
		if (length == 6) {
			sb.append(str).append("\n");
			return;
		}

		for (int i = index + 1; i < strs.length; i++) {

			if (length == 0) {
				pick(sb, strs[i], strs, i, length + 1);
			} else {
				pick(sb, str + " " + strs[i], strs, i, length + 1);
			}
		}
	}
}
