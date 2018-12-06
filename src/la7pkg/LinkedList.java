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
	
	
	/**
	 * Determines if the LinkedList is empty.
	 * 
	 * @return true/false   boolean
	 */
	public boolean isEmpty() {
		return head == null;
		
	}
	
	/**
	 * Adds object either as the first node or adds a node following the previous
	 * 
	 * @param item   type E
	 */
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
	
	/**
	 * checks if index is empty, then if index is zero, it creates and inserts a new node.
	 * 
	 * @param index   int
	 * @param item   type E
	 */
	public void insert(int index, E item) {
		if(index < 0 || index > size()) {
			System.out.println("Invalid Index");
		}
		if(index == 0) {
			head = new Node<E>(item, head);
			if(tail == null) {
				tail = head;
			}
		} else {
			Node<E> prev = head;
			for(int i = 1; i <= index - 1; i ++) {
				prev = prev.next;
			}
			prev.next = new Node<E>(item, prev.next);
		
			if(prev.next.next == null) {
				tail = prev.next;
			}	
		}
	}
	
	/**
	 *returns the ref value if the position given is valid
	 * 
	 * @param position   int, current position
	 * @return value  new value of ref
	 */
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
	
	/**
	 * counts the size of the list using a counter.
	 * 
	 * @return count   size
	 */
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
