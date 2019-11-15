package linkedList;

public class MergeTwoList {

	public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
		ListNode head = new ListNode(0);
		ListNode temp = head;
		while (head1 != null && head2 != null) {
			if (head1.getData() <= head2.getData()) {
				temp.setNext(head1);
				// change the temp reference
				temp = temp.getNext();
				head1 = head1.getNext();
			} else {
				temp.setNext(head2);
				temp = temp.getNext();
				head2 = head2.getNext();
			}
		}
        // at end at least one list will not be be null
		if (head1 != null) {
			temp.setNext(head1);
		} else if(head2!=null){
			temp.setNext(head2);
		}

		return head.getNext();
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
		linkedList.insertAtBegin(new ListNode(1));
		linkedList.insertAtBegin(new ListNode(2));
		linkedList.insertAtBegin(new ListNode(3));
		linkedList.insertAtBegin(new ListNode(4));

		LinkedList linkedList1 = new LinkedList();
		linkedList1.insertAtBegin(new ListNode(5));
		linkedList1.insertAtBegin(new ListNode(6));
		linkedList1.insertAtBegin(new ListNode(7));
		linkedList1.insertAtBegin(new ListNode(8));

		ListNode head = MergeTwoList.mergeTwoList(linkedList.getHead(), linkedList1.getHead());
		display(head);
	}
}
