package linkedList;

/**
 * 
 * @author Bhanu Pratap Singh
 * https://www.youtube.com/c/learnbybhanu
 *
 */
public class LinkedList {
	
	private int length;
	ListNode head;


	LinkedList() {
		length = 0;
	}

	public ListNode getHead() {
		return head;
	}

	// At First Head is null
	public void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

	public void insertAtEnd(ListNode newNode) {
		if (head == null) {
			head = newNode;
		} else {
			ListNode start;
			ListNode nextNode;
			for (start = head; ((nextNode = start.getNext()) != null); start = nextNode) {
			}
			start.setNext(newNode);
			// here we don't need to set next for newNode,
			// since we are adding node at end so newNode
			// next would be already pointing to NULL
			length++;
		}
	}

	public void insertAtPosition(int data, int position) {
		if (position > length) {
			position = length;
		}
		if (head == null) {
			head = new ListNode(data);
		}
		// here position 0 does not mean we don't have node
		// in Linked list. and we know that first Node in Linked
		// list is Head node. so first temp should point to head
		// and then we need to change the head to point to temp
		else if (position == 0) {
			ListNode temp = new ListNode(data);
			temp.setNext(head);
			head = temp;
		} else {
			ListNode temp = head;
			for (int i = 1; i < position; i++) {
				temp = temp.getNext();
			}
			ListNode newNode = new ListNode(data);
			// first set NewNode next pointer to temp next pointer
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
			length++;
		}
	}

	public ListNode removeNodeFromBeging() {
		ListNode temp = head;
		if (temp != null) {
			head = temp.getNext();
			temp.setNext(null);
		}
		return temp;
	}

	public ListNode removeFromEnd() {
		if (head == null) {
			return null;
		}
		ListNode temp = head;
		if (temp.getNext() == null) {
			return head;
		}
		ListNode node1 = null;
		ListNode node2 = null;
		while ((node1 = temp.getNext()) != null) {
			node2 = temp;
			temp = node1;
		}
		node2.setNext(null);
		return temp;
	}

	public ListNode removeMatchedNode(ListNode node) {
		if (head == null) {
			return null;
		}
		if (node.equals(head)) {
			ListNode temp = head;
			head = head.getNext();
			return temp;
		}
		ListNode temp = head;
		ListNode temp1;
		while ((temp1 = temp.getNext()) != null) {
			if (node.equals(temp1)) {
				temp.setNext(temp1.getNext());
				return temp1;
			}
			temp = temp1;
		}
		return null;

	}

	public ListNode removePosition(int position) {
		if (position > length) {
			position = length;
		}
		if (position == 0) {
			ListNode temp = head;
			head = head.getNext();
			return temp;
		} else {
			ListNode a = head, b = head;
			for (int i = 1; i < position; i++) {
				a = b;
				b = b.getNext();
			}
			a.setNext(a.getNext().getNext());
			return a;
		}
	}


	@Override
	public String toString() {
		return "LinkedList [head=" + head + "]";
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insertAtEnd(new ListNode(5));
		linkedList.insertAtEnd(new ListNode(3));
		ListNode node = new ListNode(50);
		linkedList.insertAtEnd(node);
		System.out.println(linkedList);

	}

}

//LinkedList linkedList = new LinkedList();
//linkedList.insertAtBegin(new ListNode(5));
//linkedList.insertAtBegin(new ListNode(3));
//linkedList.insertAtBegin(new ListNode(2));
//ListNode node = new ListNode(50);
//linkedList.insertAtBegin(node);
//linkedList.insertAtPosition(200, 3);
//linkedList.insertAtEnd(new ListNode(60));
//linkedList.insertAtEnd(new ListNode(70));
//System.out.println(linkedList);
// linkedList.removeMatchedNode(node);
// linkedList.removeNodeFromBeging();
// linkedList.removeFromEnd();
// linkedList.removeFromEnd();
// linkedList.removeFromEnd();
//System.out.println(linkedList);
//linkedList.removePosition(4);
//System.out.println(linkedList);
