package linkedList;

public class FindLengthOfLoopInLinkedList {
	
	public int findLengthOfLoopInLinkedList(CLLNode head){
		CLLNode slownode = head;
		CLLNode fastNode = head;
		boolean loopExists = false;
		while(fastNode!=null && fastNode.getNext()!=null){
			fastNode = fastNode.getNext().getNext();
			slownode = slownode.getNext();
			if(slownode == fastNode){
				loopExists = true;
				break;
			}
		}
		int length = 0;
		if(loopExists){
			slownode = slownode.getNext();
			while(fastNode !=slownode){
				length++;
				slownode = slownode.getNext();
			}	
		}
		
		return length;
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
		FindLengthOfLoopInLinkedList obj;
		obj = new FindLengthOfLoopInLinkedList();
		System.out.println(obj.findLengthOfLoopInLinkedList(circularLinkedList.getTail()));
	}
}
