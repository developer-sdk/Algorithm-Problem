package sdk.example;

public class Fibo {

	public void fibo(int index ) {
		
		int[] fibo = new int[10];
		fibo[0] = 1;
		fibo[1] = 1;
		fibo[2] = 2;
		
		for(int i = 3; i < fibo.length; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
	}
	
	public int fibo(int[] fibo, int index) {
		
		if(index == 0 || index == 1) {
			return 1;
		} else if(index == 2)
			return 2;
		
		return fibo[index-1] + fibo[index -2];
	}
}
