package LinkedList;

public class ListNode {
	ListNode next;
	ListNode prev;
	int numElements = 0;
	Object[] elements;
	public ListNode(int nodeCapacity) {
		elements = new Object[nodeCapacity];
	}
}
