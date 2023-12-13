package LinkedList;

import java.util.ListIterator;

public class ULLIterator00 implements ListIterator<E> {
	ListNode currentNode;
	int ptr;
	int index;
	private int expectedModCount = modCount;
	
	public ULLIterator00(ListNode node, int ptr, int index) {
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
	
}
