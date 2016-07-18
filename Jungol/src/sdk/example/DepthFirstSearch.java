package sdk.example;

/**
 * 1 > 2
 * 1 > 3
 * 2 > 4
 * 3 > 4
 * 의 간선을 가지는 그래프를 DFS를 이용하여 처리할 
 * 
 * @author whitebeard
 *
 */
public class DepthFirstSearch {

	public static void main(String[] args) {
		
		int[][] array = {	{ 0, 1, 1, 0 },
							{ 1, 0, 0, 1 },
							{ 1, 0, 0, 1 },
							{ 0, 1, 1, 0 } };
		
		int[] visited = new int[4];
		visited[0] = 1;
		dfs(array, visited, 0, String.valueOf(0));
	}
	
	public static void dfs(int[][] array, int[] visited, int location, String path) {
		
		System.out.println(path);
		
		for(int i = 0; i < array.length; i++) {
			
			if(array[location][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				dfs(array, visited, i, path + String.valueOf(i));
			}
		}
	}
}
