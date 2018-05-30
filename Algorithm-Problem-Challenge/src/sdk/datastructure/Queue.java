package sdk.datastructure;

/**
 * Java를 이용한 큐 구현
 * 
 * @author whitebeard 
 *
 */
public class Queue {

	private int[] array;
	private int head;
	private int tail;

	public Queue(int size) {
		array = new int[size];
		head = -1;
		tail = -1;
	}

	/**
	 * 데이터 입력 
	 * 
	 * @param number
	 */
	public void enQueue(int number) {

		if (tail == array.length - 1)
			throw new RuntimeException("큐가 다 찼습니다.");

		// 입력시에 tail을 증가 
		array[++tail] = number;
	}

	/**
	 * 데이터 반환 
	 * 
	 * @return
	 */
	public int deQueue() {

		if (tail == -1)
			throw new RuntimeException("큐에 데이터가 없습니다.");

		// 메모리 반환을 위한 초기화 
		int temp = array[++head];
		array[head] = -1;

		// head, tail이 같다면 인덱스 초기화 
		if (head == tail) {
			head = -1;
			tail = -1;
		}

		return temp;
	}

	public static void main(String[] args) {
		Queue queue = new Queue(5);

		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);

		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}
}