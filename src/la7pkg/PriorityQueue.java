package la7pkg;

public class PriorityQueue<E extends Comparable<E>> {

	private Node<E> front = null;
	private Node<E> rear = null;
	E value;
	
	/**
	 * Checks if the 'front' node is empty
	 * 
	 * @return true/false
	 */
	public boolean isEmpty() {
		
		return front == null;
	}
	
	/**
	 * Checks if rear is null. If it is, 'data' is stored in 'rear', 
	 * and 'rear' is store in 'front'. If not, we loop through, moving
	 * the 'ref' and comparing the data with the compareTo function checking
	 * for a '1' meaning it takes priority. If the 'ref' is the front, adds a
	 * new node to the front. If not, we create a new node in the middle of
	 * the list.
	 * 
	 * @param data
	 */
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
	
	
	/**
	 * Removes the next object to be processed from the priority queue.
	 * 
	 * @return value
	 */
	public E dequeue() {
		
		value = front.value;
		front = front.next;
		if(front == null) {
			rear = null;
		}
		return value;
	}
	
	// Print the contents of the queue 
	/**
	 * 
	 */
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
