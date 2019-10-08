package linkedList;

import java.util.Stack;

public class PrintLinkedListFromEnd {

	public static void printLinkedListFromEnd(ListNode head) {
		ListNode temp = head;
		Stack<ListNode> stack = new Stack<ListNode>();
		while (temp != null) {
			stack.push(temp);
			temp = temp.getNext();
		}
		while (stack.size() >0) {
			System.out.println(stack.pop().getData());
		}

	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insertAtBegin(new ListNode(6));
		linkedList.insertAtBegin(new ListNode(5));
		linkedList.insertAtBegin(new ListNode(4));
		linkedList.insertAtBegin(new ListNode(20));

		PrintLinkedListFromEnd.printLinkedListFromEnd(linkedList.getHead());
	}
}
