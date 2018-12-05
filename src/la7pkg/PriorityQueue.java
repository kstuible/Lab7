package la7pkg;

public class PriorityQueue<E extends Comparable<E>> {

	private Node<E> front = null;
	private Node<E> rear = null;
	E value;
	
	// Determine if the priority queue is empty.
	public boolean isEmpty() {
		
		return front == null;
	}
	
	// Add object received to the priority queue taking into consideration the rules governing priority.
	public void enqueue(E data) {
		Node<E> ref = front;

	
		if(rear != null) {
			
			
			while((ref != null) && (data.compareTo(ref.getData()) <= 0)) {		
					ref = ref.next;	
					
			}
			
			if(ref == front) {
				Node<E> newNode = new Node<E>(data, front);
				front = newNode;
			} else {
				Node<E> index = front;
				while(index.next != ref) {
					index = index.next;
				}
				Node<E> newNode = new Node<E>(data, ref);
				index.next = newNode;
				
				
			}
			
			
			//front = new Node<E>(data, ref.next);
			//rear = rear.next;
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
			System.out.println(p.value);
			p = p.next;
		}
		//System.out.println(buildr.toString());
	}
}
