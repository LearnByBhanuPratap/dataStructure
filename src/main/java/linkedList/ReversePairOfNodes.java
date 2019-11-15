package linkedList;

public class ReversePairOfNodes {
	// 1-->2-->3-->4-->null
	// 2-->1--->4-->3-->null
	
/**
 * Solution
 * 2-->1--->3-->4-->null
 * 2-->1--->4-->3-->null
 */
	public static ListNode reversePairOfNodes(ListNode head){
		ListNode temp1 = null;
		ListNode temp2 = null;
		ListNode temp3 = null;
		while(head!=null && head.getNext()!=null){ 
			if(temp1!=null){
				temp1.getNext().setNext(head.getNext());
			}
			temp1 = head.getNext();
			// in first iteration we are changing head.next to 
			// point to 3, instead of 2
			head.setNext(head.getNext().getNext());
			temp1.setNext(head);
			if(temp2 == null){
				temp2 = temp1;
			}
			head = head.getNext();
		}
		return temp2;
	}
	
	public static void display(ListNode node){
		System.out.print("[");
		while (node != null) {

			System.out.print(node.getData() + (node.getNext() != null ? "," : ""));

			node = node.getNext();
		}
		System.out.print("]");
	}
	

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insertAtBegin(new ListNode(4));
		linkedList.insertAtBegin(new ListNode(3));
		linkedList.insertAtBegin(new ListNode(2));
		linkedList.insertAtBegin(new ListNode(1));
		
		display(reversePairOfNodes(linkedList.getHead()));
	}
}
