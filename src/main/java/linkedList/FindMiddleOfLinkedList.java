package linkedList;

import java.util.Hashtable;

public class FindMiddleOfLinkedList {

	public ListNode findMiddleOfLinkedList(ListNode head) {
		int length = 1;
		Hashtable<Integer, ListNode> table = new Hashtable<Integer, ListNode>();
		ListNode current = head;
		int i = 1;
		while (current != null) {
			table.put(i++, current);
			length++;
			current = current.getNext();
		}
		
		int mid = length/2;
		System.out.println("middle index="+mid);
		return table.get(mid);

	}
	
	public ListNode findMiddleOfLinkedListAlternet(ListNode head) {
		ListNode slowNode = head, fastNode = head.getNext();
		while(fastNode.getNext()!=null){
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}
		return slowNode;

	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insertAtBegin(new ListNode(6));
		linkedList.insertAtBegin(new ListNode(5));
		linkedList.insertAtBegin(new ListNode(4));
		linkedList.insertAtBegin(new ListNode(20));
		linkedList.insertAtBegin(new ListNode(21));
		linkedList.insertAtBegin(new ListNode(22));
		linkedList.insertAtBegin(new ListNode(23));
		linkedList.insertAtBegin(new ListNode(24));
		System.out.println(linkedList);
		
		FindMiddleOfLinkedList obj = new FindMiddleOfLinkedList();
		ListNode node = obj.findMiddleOfLinkedList(linkedList.getHead());
		System.out.println(node.getData());
		
		ListNode node1 = obj.findMiddleOfLinkedListAlternet(linkedList.getHead());
		System.out.println(node1.getData());
	}
}
