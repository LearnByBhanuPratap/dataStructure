package linkedList;

public class FindLoopExistsInLinkedList {

	
	public boolean findLoopExists(CLLNode head){
		CLLNode slownode = head;
		CLLNode fastNode = head;
		while(fastNode!=null && fastNode.getNext()!=null){
			fastNode = fastNode.getNext().getNext();
			slownode = slownode.getNext();
			if(slownode == fastNode){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		CircularLinkedList circularLinkedList = new CircularLinkedList();
		circularLinkedList.addHead(1);
		circularLinkedList.addHead(2);
		circularLinkedList.addHead(3);
		circularLinkedList.addHead(4);
		circularLinkedList.addHead(5);
		circularLinkedList.addHead(6);
		System.out.println(circularLinkedList);
		FindLoopExistsInLinkedList obj;
		obj = new FindLoopExistsInLinkedList();
		System.out.println(obj.findLoopExists(circularLinkedList.getTail()));
	}
}
