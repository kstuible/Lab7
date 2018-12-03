package la7pkg;

public class LinkedList<E> {

	private Node<E> head;
	private Node<E> tail;
	private E value;
	
	LinkedList<E> list;
	
	public LinkedList() {
		head = null;
		tail = null;
		value = null;
		//size = 0;
	}
	
	
	// Determine if the LinkedList is empty.
	public boolean isEmpty() {
		return head == null;
		
	}
	
	// Add object received to the linked list if he/she has the priority.
	public void add(E item) {
		if(isEmpty()) {
			head = new Node<E>(item);
			tail = head;
		}
		else {
			tail.next = new Node<E>(item);
			tail = tail.next;
		}
	}
	
	// get the object in specific position in the LinkedList used to print the 
	// enrolled student contents inside the Course class and return the name
	public E get(int position) {
		if(position >= size() || position < 0) {
			System.out.print("Invalid Index: Returning ");
			return null;
		}
		else {
			Node<E> ref = head;
			for(int i = 0; i < position; i++) {
				value = ref.value;
				ref = ref.next;
			}
			return ref.value;
		}
	}
	
	// Return number of elements in the list.
	public int size() {
		int count = 0;
		Node<E> p = head;
		
		while(p != null) {
			count++;
			p = p.next;
		}
		
		return count;
		
	}

}
