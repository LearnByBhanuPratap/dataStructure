package linkedList;

/**
 * 
 * @author Bhanu Pratap Singh
 *
 */
public class DoublyLinkedList {
	
	private DLLNode head;
	private DLLNode tail;
	private int length;
	
	private DoublyLinkedList(){
		head = new DLLNode(Integer.MAX_VALUE, null, null);
		tail = new DLLNode(Integer.MAX_VALUE, head, null);
		head.setNext(tail);
		length++;
	} 
	
	public void insertAtBeging(int data){
		DLLNode newNode = new DLLNode(data, head, head.getNext());
		newNode.getNext().setPrev(newNode);
		head.setNext(newNode);
		length++;
	}
	
	public void insertAtTail(int data){
		DLLNode newNode = new DLLNode(data, tail.getPrev(), tail);	
		newNode.getPrev().setNext(newNode);
		tail.setPrev(newNode);
		length++;
	}
	
	public void insertAtPosition(int data, int position){
		if(position > length){
			position = 0;
		}
		if(position == 0){
			insertAtBeging(data);
		}
		DLLNode temp = head;
		for (int i = 1; i < position; i++) {
			temp = temp.getNext();
		}
		DLLNode newNode = new DLLNode(data);
		newNode.setNext(temp.getNext().getNext());
		temp.getNext().getNext().setPrev(newNode);
		temp.setNext(newNode);
		newNode.setPrev(temp);
		length++;
		
	}
	
	public int getPosition(int data){
		DLLNode temp = head;
		int position = 0;
		while(temp!=null){
			if(data == temp.getData()){
				return position;
			}
			position++;
			temp = temp.getNext();
		}
		return Integer.MAX_VALUE;
		
	}
	
	public int removeFromBeging(){
		if(length == 0){
			return Integer.MAX_VALUE;
		}
		DLLNode temp = head.getNext();
		head.setNext(temp.getNext());
		temp.getNext().setPrev(head);
		length--;
		return temp.getData();
	}
	
	public int removeFromEnd(){
		if(length == 0){
			return Integer.MAX_VALUE;
		}
		DLLNode temp = tail.getPrev();
		tail.setPrev(temp.getPrev());
		temp.getPrev().setNext(tail);
		length--;
		return temp.getData();
	}
	
	public int removePosition(int position){
		if(position > length){
			position = length;
		}
		if(position == 0){
			removeFromBeging();
		}
		DLLNode temp = head;
		for (int i = 1; i < position; i++) {
			temp = temp.getNext();
		}
		temp.getNext().getNext().setPrev(temp);
		temp.setNext(temp.getNext().getNext());
		length--;
		return temp.getData();
	}
	
	@Override
	public String toString() {
		String result = "[]";
		if(length == 0){
			return null;
		}
		result = "["+head.getData();
		DLLNode temp = head.getNext();
		while(temp!=null){
			result = result+","+temp.getData();
			temp = temp.getNext();
		}
		return result+"]";
	}

	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.insertAtBeging(4);
		doublyLinkedList.insertAtBeging(5);
		doublyLinkedList.insertAtBeging(6);
		doublyLinkedList.insertAtTail(8);
		doublyLinkedList.insertAtPosition(100, 2);
		doublyLinkedList.insertAtPosition(1000, 0);
		System.out.println(doublyLinkedList);
		System.out.println(doublyLinkedList.removeFromBeging());
		System.out.println(doublyLinkedList);
		System.out.println(doublyLinkedList.removeFromEnd());
		System.out.println(doublyLinkedList);
		System.out.println(doublyLinkedList.removePosition(3));
		System.out.println(doublyLinkedList);
	}
	
	
}
