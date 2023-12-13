package LinkedList;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class UnrolledLinkedList<E> extends AbstractList<E> implements List<E>, Serializable {

	
	private int nodeCapacity;
	//The current size of this list
	private int size = 0;
	// The first node of this list
	private ListNode firstNode;
	// The last node
	private ListNode lastNode;
	// Constructs an empty list wth the specified capacity
	public UnrolledLinkedList(int nodeCapacity) throws IllegalArgumentException {
		if (nodeCapacity < 8) {
			throw new IllegalArgumentException("nodeCapacity < 8");
		}
		this.nodeCapacity = nodeCapacity;
		firstNode = new ListNode(nodeCapacity); // ???
		lastNode = firstNode;
	}
	
	public UnrolledLinkedList() {
		this(16);
	}
	
	

	@Override
	public int size() {
		return size;
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public boolean contains(Object o) {
		return (indexOf(o) != -1);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	public Iterator<E> iterator () {
		return new ULLIterator(firstNode, 0, 0);
	}




	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}



class ULLIterator implements ListIterator<E> {
	ListNode currentNode;
	int ptr;
	int index;
	private int expectedModCount = modCount;
	
	public ULLIterator(ListNode node, int ptr, int index) {
		super();
		this.currentNode = node;
		this.ptr = ptr;
		this.index = index;
	}

	@Override
	public boolean hasNext() {
		return index < size - 1;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E previous() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(LinkedList.E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(LinkedList.E e) {
		// TODO Auto-generated method stub
		
	}
	
}
