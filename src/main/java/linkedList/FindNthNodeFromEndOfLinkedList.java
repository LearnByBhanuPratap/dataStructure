package linkedList;

import java.util.Hashtable;

/**
 * 
 * @author Bhanu Pratap Singh
 *
 */
public class FindNthNodeFromEndOfLinkedList {

	
	
	public int findNthNodeFromLast(ListNode head, int nthNode){
		int length = 0;
		ListNode temp = head;
		// get total number of length
		while(temp!=null){
			length++;
			temp = temp.getNext();
		}
		
		// length-nthNode plus 1 will be equal to 
		// nth node from last
		// e.g if linked list has 5 node and when we want 2 node
		// from last means (5-2)+1 = will be 4th node from begin.
		int nodeFromBeging = (length-nthNode)+1;
		ListNode node = head;
		for (int i = 1; i < nodeFromBeging; i++) {
			node = node.getNext();
		}
		return node.getData();
	}
	
	public int findNthNodeFromLastUsingHashTable(ListNode head, int nthNode){
		int length = 0;
		ListNode temp = head;
		Hashtable<Integer, ListNode> table = new Hashtable<Integer, ListNode>();
		int key = 1;
		// get total number of length
		while(temp!=null){
			length++;
			table.put(key, temp);
			temp = temp.getNext();
			key++;
		}
		System.out.println(table);
		// length-nthNode plus 1 will be equal to 
		// nth node from last
		// e.g if linked list has 5 node and when we want 2 node
		// from last means (5-2)+1 = will be 4th node from begin.
		int nodeFromBeging = (length-nthNode)+1;
		ListNode node = table.get(nodeFromBeging);
		return node.getData();
	}
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insertAtBegin(new ListNode(5));
		linkedList.insertAtBegin(new ListNode(3));
		linkedList.insertAtBegin(new ListNode(2));
		linkedList.insertAtBegin(new ListNode(20));
		linkedList.insertAtBegin(new ListNode(200));
		System.out.println(linkedList);
		FindNthNodeFromEndOfLinkedList findNthNodeFromEndOfLinkedList = new FindNthNodeFromEndOfLinkedList();
		int data = findNthNodeFromEndOfLinkedList.findNthNodeFromLast(linkedList.getHead(), 4);
		System.out.println(data);
		
		data = findNthNodeFromEndOfLinkedList.findNthNodeFromLastUsingHashTable(linkedList.getHead(), 4);
		System.out.println("data="+data);
	}
}
