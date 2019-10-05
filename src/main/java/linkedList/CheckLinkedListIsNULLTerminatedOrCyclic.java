package linkedList;

import java.util.Hashtable;

// check weather given linked list is NULL terminated or cyclic
public class CheckLinkedListIsNULLTerminatedOrCyclic {

	public boolean checkNullTerminated(CLLNode head) {
		CLLNode temp = head;
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		int counter = 1;
		while (temp != null) {
			if(table.containsKey(temp.hashCode())){
				return false;
			}
			table.put(temp.hashCode(), counter);
			temp = temp.getNext();
			counter++;
		}
		return true;
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
		CheckLinkedListIsNULLTerminatedOrCyclic obj;
		obj = new CheckLinkedListIsNULLTerminatedOrCyclic();
		System.out.println(obj.checkNullTerminated(circularLinkedList.getTail()));
	}
}
