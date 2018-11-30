package la7pkg;

public class Node<E> implements INode<E> {

	Node<E> next;
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
	public Node<E> getNext() {
		return next;
	}

	@Override
	public void setNext(Node<E> nextNode) {
		next = nextNode;
	}

	

}
