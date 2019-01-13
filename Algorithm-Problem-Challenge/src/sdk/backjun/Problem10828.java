package sdk.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준, 10828
 * 스택 
 * 
 * @author whitebeard-k
 *
 */
public class Problem10828 {

	public static int[] stack = new int[10000];
	public static int current = -1;

	public static void push(int number) {
		stack[++current] = number;
	}

	public static int pop() {
		if(current == -1)
			return current;
		
		int res = stack[current--];
		return res;
	}

	public static int size() {
		return current + 1;
	}

	public static int empty() {
		return current == -1 ? 1 : 0;
	}

	public static int top() {

		return (current == -1) ? -1 : stack[current];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		for (int i = 0; i < size; i++) {
			String[] command = br.readLine().split(" ");
			
			switch (command[0]) {
			case "push":
				push(Integer.parseInt(command[1]));
				break;
			case "pop":
				System.out.println(pop());
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "top":
				System.out.println(top());
				break;
			}
		}
	}
}