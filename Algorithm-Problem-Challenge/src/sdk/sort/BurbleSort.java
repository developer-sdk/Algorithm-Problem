package sdk.sort;

public class BurbleSort {
	public void sort(int[] data) {
		int temp = 0;
		for (int i = data.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (data[j] > data[j + 1]) {
					temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
			
			for(int n : data) 
				System.out.printf("%d ", n);
			System.out.println();
		}
	}

	public static void main(String[] args) {

		BurbleSort bubble = new BurbleSort();

		int data[] = { 66, 10, 1, 34, 5 };

		bubble.sort(data);

		for (int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "] : " + data[i]);
		}
	}
}
