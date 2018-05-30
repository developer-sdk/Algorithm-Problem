package sdk.jungol.level.level1;

import java.util.Scanner;

public class Problem1034 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String str = in.next();
		in.close();
		
//		String str = "ABCDE";
		char[] chars = str.toCharArray();
		int[] ints = new int[chars.length];
		
		for(int i= 0; i < chars.length; i++) {
			ints[i] = (int) chars[i] - (int)'A';
		}
		
//		for(int i : intØßs) {
//			System.out.printf("%d ", i);
//		}
//		System.out.println();;
//		for(int i : ints) {
//			System.out.printf("%s", (char) (i + (int)'A'));
//		}
//		System.out.println();;
		
		
		int last = ints[chars.length-1];
		for(int i = chars.length - 2; i >= 0; i--) {
			if(last > ints[i]) {
				
				for(int k = chars.length-1; k > i; k--) {
					ints[k] = ints[k-1];
				}
				ints[i] = last;
				
				nextPermutation(ints);
				
				break;
			}
		}
		
//		int[] array = {0, 1, 1, 1, 4};
		
		
//		for(int i : ints) {
//			System.out.printf("%d ", i);
//		}
//		System.out.println();
		for(int i : ints) {
			System.out.printf("%s", (char) (i + (int)'A'));
		}
	}
	
	static boolean nextPermutation(int[] array) {
	    // Find longest non-increasing suffix
	    int i = array.length - 1;
	    while (i > 0 && array[i - 1] >= array[i])
	        i--;
	    // Now i is the head index of the suffix
	    
	    // Are we at the last permutation already?
	    if (i <= 0)
	        return false;
	    
	    // Let array[i - 1] be the pivot
	    // Find rightmost element that exceeds the pivot
	    int j = array.length - 1;
	    while (array[j] <= array[i - 1])
	        j--;
	    // Now the value array[j] will become the new pivot
	    // Assertion: j >= i
	    
	    // Swap the pivot with j
	    int temp = array[i - 1];
	    array[i - 1] = array[j];
	    array[j] = temp;
	    
	    // Reverse the suffix
	    j = array.length - 1;
	    while (i < j) {
	        temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	        i++;
	        j--;
	    }
	    
	    // Successfully computed the next permutation
	    return true;
	}

}
