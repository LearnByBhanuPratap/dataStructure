package linkedList;

public class GetJosephusPosition {

	public static void getJosephusPosition(int n, int m){
		ListNode p, q;
		p = new ListNode();
		q = new ListNode();
		p.setData(1);
		q = p;
		for (int i = 2; i <= n; i++) {
			p = p.getNext();
			p.setData(i);
		}
		p.setNext(p);
	}
	
	public static void main(String[] args) {
		getJosephusPosition(4, 2);	
	}
}
