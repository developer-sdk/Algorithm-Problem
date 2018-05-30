package sdk.dovlet;

public class Koi_Seat {

    public static void main(String[] args) {
        
        int y = 7;
        int x = 6;
        int targetNumber = 11;
        int[][] array = new int[x][y];
        
        
        int round = 0;
        int prevNumber = 1;
        
        while(true) {
        	
        	x = x -(round * 2);
        	y = y -(round * 2);
        	
        	int number = x*2 + (y-2)*2;
        	if(prevNumber <= targetNumber && targetNumber <= number ) {
        		check(array, round, x, y, targetNumber);
        		break;
        	}
        	
        	prevNumber = number;
        	round++;
        	
        	if(x <= 0 || y <= 0)
        		break;
        }
        
        //int round = 2;
        
        //check(array, round, x, y, number);
    }
    
    public static void check(int[][] array, int round, int x, int y, int number) {
        
        int count = 1;
        int startX = round;
        int startY = round;
        
        // x 증가
        for(; startX < x-round; startX++) {
        	array[startX][startY] = count++;
        	
        	if(count == number) {
        		System.out.printf("%d %d", startX, startY);
        		return;
        	}
        }
            
        
        startX--;
        startY++;
        
        // y 증가
        for(; startY < y-round; startY++) {
        	array[startX][startY] = count++;
        	
        	if(count == number) {
        		System.out.printf("%d %d", startX, startY);
        		return;
        	}
        }
            
        
        startX--;
        startY--;
        
        // x 감소
        for(; startX > round; startX--) {
        	array[startX][startY] = count++;
        	
        	if(count == number) {
        		System.out.printf("%d %d", startX, startY);
        		return;
        	}
        }
            
        
        // y 감소
        for(; startY > round; startY--) {
        	array[startX][startY] = count++;
        	
        	if(count == number) {
        		System.out.printf("%d %d", startX, startY);
        		return;
        	}
        }
            
        
        for(int[] ys : array) {
            for(int yt : ys)
                System.out.printf("%2d ", yt);
            
            System.out.println();
        }
    }
}