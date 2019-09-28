package linkedList;

public class TranverseTheList {

	public int findListLength(ListNode head) {
		int length = 0;
		ListNode currentNode = head;
		while (currentNode != null) {
			currentNode = currentNode.getNext();
			length++;
		}
		return length;
	}
}
