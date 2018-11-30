package la7pkg;

public class PriorityQueue<E> {

	Node<E> first;
	Node<E> last;
	
	// Determine if the priority queue is empty.
	public boolean isEmpty() {
		
		return first == null;
	}
	
	// Add object received to the priority queue taking into consideration the rules governing priority.
	public void enqueue(E data) {
		
	}
	
	// Remove the next object to be processed from the priority queue.
	public E dequeue() {
		return first.value;
	}
	
	// Print the contents of the queue 
	public void Qprint() {	
	
	}
}
