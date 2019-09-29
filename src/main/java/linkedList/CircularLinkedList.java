package linkedList;

public class CircularLinkedList {

	private CLLNode tail;
	private int length;

	CircularLinkedList() {
		tail = null;
		length = 0;
	}

	public CLLNode getTail() {
		return tail;
	}

	public int getLength() {
		return length;
	}

	public void addHead(int data) {
		CLLNode newNode = new CLLNode(data);
		if (tail == null) {
			// here don't do tail.setNext(newNode); you will get NPE
			// since tail is null in beginning
			tail = newNode;
			newNode.setNext(tail);
		} else {
			// first change newnode point to tail
			newNode.setNext(tail.getNext());
			// then tail should point ot newnode
			tail.setNext(newNode);

		}
		length++;
	}

	public void addTail(int data) {
		addHead(data);
		tail = tail.getNext();
	}

	public int returnTailData() {
		return tail.getData();
	}

	public int returnHeadData() {
		return tail.getNext().getData();
	}

	public int removeFromhead() {
		// Just after tail node we have head node
		CLLNode temp = tail.getNext();
		if (tail == tail.getNext()) {
			tail = null;
		} else {
			// we need to sift tail node to point ahead of head node
			tail.setNext(temp.getNext());
			// set temp point to null
			temp.setNext(null);
		}
		return temp.getData();
	}

	public int removeFromEnd() {
		CLLNode temp = tail;
		while (temp.getNext() != tail) {
			temp = temp.getNext();
		}
		// this condition will work when there is only one node in
		// circular linked list
		if (temp == tail) {
			tail = null;
		} else {
			temp.setNext(tail.getNext());
			tail = temp;
		}
		length--;
		return temp.getData();

	}

	public int removeMatched(int data) {
		if (tail == null) {
			return Integer.MAX_VALUE;
		}
		// store temp with tail.next
		CLLNode temp = tail.getNext();
		CLLNode preTemp = tail;
		// check data with temp data
		for (int i = 0; i < length && (temp.getData() != data); i++) {
			preTemp = temp;
			temp = temp.getNext();
		}
		if(temp.getData() == data){
			if(tail == tail.getNext()){
				tail = null;
			}
			else{
				// if temp points to tail then we need
				// to remove current tail and make previous
				// to tail node as tail
				if(temp == tail){
					tail = preTemp;
				}
				preTemp.setNext(temp.getNext());
			}
			temp.setNext(null);
			length--;
			return temp.getData();
		}
		preTemp.setNext(temp.getNext());
		preTemp.setNext(null);
		return preTemp.getData();
	}

	@Override
	public String toString() {
		String result = "[";
		if (tail == null) {
			result = result + "]";
		}
		CLLNode temp = tail;
		result = result + temp.getData();
		temp = temp.getNext();
		while (temp != tail && temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";

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
		System.out.println(circularLinkedList.removeMatched(1));
		System.out.println(circularLinkedList);
	}
}
