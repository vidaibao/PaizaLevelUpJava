package LinkedListV2;

public class UnrolledCircularLinkedList<T> {

	private static final int NODE_CAPACITY = 3;
	//private int n;
	
	
	private class Node {
        private T[] elements;
        private int size;
        private Node next;

        @SuppressWarnings("unchecked")
        private Node() {
            elements = (T[]) new Object[NODE_CAPACITY];
            size = 0;
            next = null;
        }
    }

    private Node head;

    public UnrolledCircularLinkedList() {
        head = new Node();
        head.next = head; // Circular link to itself
    }

    public void add(T element) {
        Node current = head;// Start the search from the head node

        // Find the appropriate node to add the element (node full && not the last)
        while (current.size == NODE_CAPACITY && current.next != head) {
            current = current.next;// Move to the next node if the current one is full
        }

        // Add the element to the current node or create a new node if needed
        if (current.size < NODE_CAPACITY) {
        	// Add the element to the array in the current node
            current.elements[current.size] = element;
            current.size++;
        } else {
            Node newNode = new Node();
            newNode.elements[newNode.size] = element;
            newNode.size++;
            newNode.next = current.next;//head
            current.next = newNode;
        }
    }

    public void printList() {
        Node current = head;

        do {
            for (int i = 0; i < current.size; i++) {
                System.out.print(current.elements[i] + " ");
            }
            current = current.next;
        } while (current != head);

        System.out.println();
    }
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		UnrolledCircularLinkedList<Integer> unrolledList = new UnrolledCircularLinkedList<>();
		try {
			for (int i = 1; i <= 10; i++) {
	            unrolledList.add(i);
	        }
			System.out.print("Unrolled Circular Linked List: ");
			unrolledList.printList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
