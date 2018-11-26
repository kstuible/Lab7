package la7pkg;

public class Node<E> implements INode {

	static Node next;
	E value;
	
	// Constructor
	Node(E dataValue){
		value = dataValue;
		next = null;
	}
	
	// Constructor
	Node(E dataValue, Node<E> nextNode){
		value = dataValue;
		next = nextNode;
	}
	
	@Override
	public E getData() {
		
		return value;
	}
 
	@Override
	public Node getNext() {
		return next;
	}

	@Override
	public void setNext(Node next) {
		Node.next = next;
	}

	

}
