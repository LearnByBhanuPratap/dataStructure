package linkedList;

public class Reverse_k_nodes {

	public static ListNode reverseKNodes(ListNode head, int k) {
		ListNode current = head;
		ListNode prevTail = null;
		ListNode prevCurrent = head;
		while (current != null) {
			int count = k;
			ListNode tail = null;
			while (current != null && count > 0) {
				ListNode next = current.getNext();
				current.setNext(tail);
				tail = current;
				current = next;
				count--;
			}
			if (prevTail != null) {
				prevTail.setNext(tail);
			} else {
				head = tail;
			}
			prevTail = prevCurrent;
			prevCurrent = current;
		}
		return head;
	}

	public static void display(ListNode node) {
		System.out.print("[");
		while (node != null) {

			System.out.print(node.getData() + (node.getNext() != null ? "," : ""));

			node = node.getNext();
		}
		System.out.print("]");
	}
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insertAtBegin(new ListNode(6));
		linkedList.insertAtBegin(new ListNode(5));
		linkedList.insertAtBegin(new ListNode(4));
		linkedList.insertAtBegin(new ListNode(3));
		linkedList.insertAtBegin(new ListNode(2));
		linkedList.insertAtBegin(new ListNode(1));
		
		display(reverseKNodes(linkedList.getHead(), 2));
	}

}
