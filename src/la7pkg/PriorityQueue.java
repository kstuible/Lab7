package la7pkg;

public class PriorityQueue<E> {

	private Node<E> front = null;
	private Node<E> rear = null;
	E value;
	
	// Determine if the priority queue is empty.
	public boolean isEmpty() {
		
		return front == null;
	}
	
	// Add object received to the priority queue taking into consideration the rules governing priority.
	public void enqueue(E data) {
		if(rear != null) {
			rear.next = new Node<E>(data, null);
			rear = rear.next;
		}
		else {
			rear = new Node<E>(data, null);
			front = rear;
		}
	}
	
	// Remove the next object to be processed from the priority queue.
	public E dequeue() {
		
		value = front.value;
		front = front.next;
		if(front == null) {
			rear = null;
		}
		return value;
	}
	
	// Print the contents of the queue 
	public void Qprint() {	
		//StringBuilder buildr = new StringBuilder();
		
		Node<E> p = front;
		
		while(p != null) {
			System.out.println(p.toString());
			p = p.next;
		}
		//System.out.println(buildr.toString());
	}
}
