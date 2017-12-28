package sdk.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐를 이용하여 스택 구현하기 
 * 큐 2개를 이용하여 스택을 구현하는 방법 
 * 
 * push 시점에는 inBox 큐에 입력
 * pop 시점에는 inBox 에 있는 데이터를 
 * outBox에 넣어서 출력한다. 
 * 
 * @author whitebeard
 *
 */
public class QueueStack {

	private Queue<Integer> inBox;
	private Queue<Integer> outBox;
	
	public QueueStack() {
		inBox = new LinkedList<>();
		outBox = new LinkedList<>();
	}
	
	public void push(int number) {
		inBox.add(number);
	}
	
	public int pop() {
		
		if(outBox.isEmpty()) {
			while(!inBox.isEmpty()) {
				outBox.add(inBox.poll());
			}
		}
		
		return outBox.poll();
	}
	
	public static void main(String[] args) {
		
		QueueStack stack = new QueueStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.pop());
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}