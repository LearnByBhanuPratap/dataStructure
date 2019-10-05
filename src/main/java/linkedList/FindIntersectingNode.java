package linkedList;

import java.util.Hashtable;
import java.util.Stack;

public class FindIntersectingNode {

	public ListNode findIntersectingNode(ListNode head1, ListNode head2) {
		ListNode current = head1;
		ListNode current1 = head2;
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		while (current != null) {
			table.put(current.hashCode(), current.getData());
			current = current.getNext();
		}
		while (current1 != null) {
			if (table.containsKey(current1.hashCode())) {
				break;
			} else {
				current1 = current1.getNext();
			}
		}
		return current1;
	}

	public ListNode solveThisWithStack(ListNode head1, ListNode head2) {
		Stack<ListNode> stack1 = new Stack<ListNode>();
		Stack<ListNode> stack2 = new Stack<ListNode>();
		ListNode temp1 = head1;
		ListNode temp2 = head2;
		while (temp1 != null) {
			stack1.push(temp1);
			temp1 = temp1.getNext();
		}

		while (temp2 != null) {
			stack2.push(temp2);
			temp2 = temp2.getNext();
		}
		ListNode temp = null;

		while (stack1.peek() == stack2.peek()) {
			temp = stack1.peek();
			stack1.pop();
			stack2.pop();
		}
		return temp;
	}

	public int alternetWayToSolve(ListNode head1, ListNode head2) {
		ListNode temp1 = head1;
		ListNode temp2 = head2;
		int length1 = 0, length2 = 0, diff = 0;
		while (temp1 != null) {
			temp1 = temp1.getNext();
			length1++;
		}
		while (temp2 != null) {
			temp2 = temp2.getNext();
			length2++;
		}

		if (length1 > length2) {
			temp1 = head1;
			temp2 = head2;
			diff = length1 - length2;
		} else {
			temp1 = head2;
			temp2 = head1;
			diff = length2 - length1;
		}
		for (int i = 0; i < diff; i++) {
			temp1 = temp1.getNext();
		}
		while (temp1 != null && temp2 != null) {
			if (temp1 == temp2) {
				return temp1.getData();
			}
			temp1 = temp1.getNext();
			temp2 = temp2.getNext();
		}
		return 0;
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
		// System.out.println(linkedList);

		LinkedList linkedList1 = new LinkedList();
		linkedList1.insertAtBegin(new ListNode(8));
		linkedList1.insertAtBegin(new ListNode(9));
		linkedList1.insertAtBegin(new ListNode(10));

		ListNode current1 = linkedList.getHead();
		while (current1.getNext() != null) {
			current1 = current1.getNext();
		}
		current1.setNext(linkedList1.getHead());

		LinkedList linkedList2 = new LinkedList();
		linkedList2.insertAtBegin(new ListNode(11));
		linkedList2.insertAtBegin(new ListNode(12));
		linkedList2.insertAtBegin(new ListNode(13));
		linkedList2.insertAtBegin(new ListNode(14));
		// System.out.println(linkedList);

		ListNode current2 = linkedList2.getHead();
		while (current2.getNext() != null) {
			current2 = current2.getNext();
		}

		current2.setNext(linkedList1.getHead());

		FindIntersectingNode obj = new FindIntersectingNode();
		obj.display(linkedList.getHead());
		System.out.println();
		obj.display(linkedList2.getHead());
		System.out.println();
		int data = obj.findIntersectingNode(linkedList.getHead(), linkedList2.getHead()).getData();
		System.out.println(data);

		ListNode node = obj.solveThisWithStack(linkedList.getHead(), linkedList2.getHead());
		System.out.println(node.getData());
		
		System.out.println(obj.alternetWayToSolve(linkedList.getHead(), linkedList2.getHead()));
	}
}
