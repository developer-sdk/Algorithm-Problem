package sdk.example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1 > 2
 * 1 > 3
 * 2 > 4
 * 3 > 4
 * 의 간선을 가지는 그래프를 BFS를 이용하여 처리할 
 * 
 * @author whitebeard
 *
 */
public class BredthFirstSearch {

	public static void main(String[] args) {
		
		int[][] array = {	{ 0, 1, 1, 0 },
							{ 1, 0, 0, 1 },
							{ 1, 0, 0, 1 },
							{ 0, 1, 1, 0 } };
		
		int[] visited = new int[4];
		visited[0] = 1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		
		bfs(array, visited, queue, String.valueOf(0));
	}
	
	public static void bfs(int[][] array, int[] visited, Queue<Integer> queue, String path) {
		
		int size = queue.size();
		
		while(size-- > 0) {
			int location = queue.poll();
			for(int i = 0; i < array.length; i++) {
				
				if(array[location][i] == 1 && visited[i] == 0) {
					queue.add(i);
					visited[i] = 1;
					path += String.valueOf(i);
				}
			}
		}
		
		if(queue.size() != 0)
			bfs(array, visited, queue, path);
		else 
			System.out.println(path);
	}
}
