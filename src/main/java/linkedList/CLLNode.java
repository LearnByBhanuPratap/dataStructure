package linkedList;

public class CLLNode {

	private CLLNode next;
	private int data;
	
	public CLLNode(int data) {
		this.data = data;
	}
	
	public CLLNode getNext() {
		return next;
	}
	public void setNext(CLLNode next) {
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}

}
