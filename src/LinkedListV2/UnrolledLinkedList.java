package LinkedListV2;

import java.util.LinkedList;
import java.util.List;

public class UnrolledLinkedList<T> {
/*
 * One of the biggest advantages of linked lists over arrays is that inserting an element at any
location takes only O(1) time. However, it takes O(n) to search for an element in a linked list.
There is a simple variation of the singly linked list called unrolled linked lists.
An unrolled linked list stores multiple elements in each node (let us call it a block for our
convenience). In each block, a circular linked list is used to connect all nodes
*/
	//The maximum number of elements that can be stored in a single node
	//
	private int nodeCapacity;
	
	private class Node {
		private List<T> elements;
		private Node next;
		
		private Node () {
			elements = new LinkedList<>();
			next = null;
		}
	}
	
	private Node head;
	
	public UnrolledLinkedList(int nodeCapacity) {
		this.nodeCapacity = nodeCapacity;
		head = new Node();
	}
	
	public void add(T element) {
		Node current = head;
		// move to the end
		while (current.next != null && current.elements.size() == nodeCapacity) {
			current = current.next;
		}
		
		// till slot
		if (current.elements.size() < nodeCapacity) {
			current.elements.add(element);
		} else {
			Node newNode = new Node();
			newNode.elements.add(element);
			newNode.next = current.next;
			current.next = newNode;
		}
	}
	
	public void prinList() {
		Node current = head;
		while (current != null) {
			System.out.println(current.elements + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static final int NODE_CAPACITY = 3;
	
	public static void main(String[] args) {
		
		UnrolledLinkedList<Integer> unrolledList = new UnrolledLinkedList<Integer>(NODE_CAPACITY);
		
		for (int i = 0; i < 10; i++) {
			unrolledList.add(i);
		}

		System.out.println("Unrolled Linked List:");
		unrolledList.prinList();
	}

}
