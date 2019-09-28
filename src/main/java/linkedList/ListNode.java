package linkedList;

public class ListNode {
	
	private int data;
	private ListNode next;
	
	ListNode(){
	}

	/**
	 * Constructor which will take node data as an argument
	 * @param data
	 */
	ListNode(int data){
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	
	@Override
	public String toString() {
		return "data--->" + data + " and next--->" + next;
	}

}
