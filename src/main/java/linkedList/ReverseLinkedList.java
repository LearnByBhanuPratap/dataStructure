package linkedList;

public class ReverseLinkedList {

	public ListNode reverseLinkedList(ListNode head) {
		ListNode current = head;
		ListNode prev = null;
		ListNode next = head;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}

		return prev;
	}

	public void display(ListNode node) {
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
		linkedList.insertAtBegin(new ListNode(2));
		System.out.println(linkedList);

		ReverseLinkedList obj;
		obj = new ReverseLinkedList();
		obj.display(linkedList.getHead());
		
		ListNode node = obj.reverseLinkedList(linkedList.getHead());
		obj.display(node);

	}
}
