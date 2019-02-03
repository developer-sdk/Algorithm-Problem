package sdk.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준, 11003, 최소값 찾기 
 * https://www.acmicpc.net/problem/11003
 * 
 * @author whitebeard-k
 *
 */
public class Problem11003 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Deque<Node> deque = new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());	// N개의 수 
		int L = Integer.parseInt(st.nextToken());	// L개의 수 중 최소값 

		st = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < N; i++) {

			Node node = new Node(array[i], i);

			if (!deque.isEmpty() && deque.peekFirst().index <= i - L) {	// 인덱스를 넘어가면 앞쪽에서 제거 
				deque.removeFirst();
			}

			while (!deque.isEmpty() && deque.peekLast().value > node.value) {	// 인덱스안이면 뒤쪽에서부터 자기보다 큰 값을 제거 
				deque.removeLast();
			}

			deque.addLast(node);
			buffer.append(deque.peekFirst().value).append(" ");	// 출력을 위한 최소값을 계속 추가 

		}

		System.out.println(buffer);
	}

	public static class Node {
		int index;
		int value;

		public Node(int value, int index) {
			this.index = index;
			this.value = value;
		}
	}
}