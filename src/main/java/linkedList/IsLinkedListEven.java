package linkedList;

public class IsLinkedListEven {

	public static boolean isLinkedListEven(ListNode head) {
		ListNode temp = head;
		while (temp != null && temp.getNext() != null) {
			temp = temp.getNext().getNext();
		}
		if (temp == null) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insertAtBegin(new ListNode(6));
		//linkedList.insertAtBegin(new ListNode(5));
		linkedList.insertAtBegin(new ListNode(4));
		linkedList.insertAtBegin(new ListNode(20));
		
		System.out.println(IsLinkedListEven.isLinkedListEven(linkedList.getHead()));
	}
}
