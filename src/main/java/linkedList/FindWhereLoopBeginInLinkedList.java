package linkedList;

public class FindWhereLoopBeginInLinkedList {

	public int findWhereLoopBegin(CLLNode head){
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
		if(loopExists){
			slownode = head;
			while(slownode != fastNode){
				slownode = slownode.getNext();
				fastNode = fastNode.getNext();
			}
			
		}
		return slownode.getData();
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
		FindWhereLoopBeginInLinkedList obj;
		obj = new FindWhereLoopBeginInLinkedList();
		System.out.println(obj.findWhereLoopBegin(circularLinkedList.getTail()));
	}

}
