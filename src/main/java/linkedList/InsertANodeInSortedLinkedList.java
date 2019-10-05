package linkedList;

public class InsertANodeInSortedLinkedList {

	public ListNode insertANodeInSortedLinkedList(ListNode head, ListNode newNode) {
		ListNode currentNode = head;
		if (head == null) {
			return newNode;
		}
		ListNode temp = null;
		while (currentNode != null && currentNode.getData() < newNode.getData()) {
			temp = currentNode;
			currentNode = currentNode.getNext();
		}
		temp.setNext(newNode);
		newNode.setNext(currentNode);
		return head;
	}
	
	public void display(ListNode node){
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

		InsertANodeInSortedLinkedList obj;
		obj = new InsertANodeInSortedLinkedList();

		ListNode node = obj.insertANodeInSortedLinkedList(linkedList.getHead(), new ListNode(3));
		obj.display(node);

	}
}
