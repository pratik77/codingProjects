import java.util.HashMap;

public class LoopInLinkedList {
	static Node head = null;
	static Node firstRef = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		createLinkedList(2);
		createLinkedList(3);
		createLinkedList(4);
		createLinkedList(5);
		createLinkedList(6);
		createLinkedList(7);
		createLinkedList(8);
		createLinkedList(9);
		display();
		if(isLinkedListLooped()) {
			firstRef.link = null;
		}
		System.out.println();
		display();
		
		

	}

	private static boolean isLinkedListLooped() {
		Node slowRef = head;
		HashMap<Node, Node> loopChecker = new HashMap<Node, Node>();
		while(slowRef.link != null) {
			if(loopChecker.containsKey(slowRef.link)) {
				firstRef = slowRef;
				return true;
			}
			loopChecker.put(slowRef, slowRef);
			slowRef = slowRef.link;
		}
		return false;
		
	}

	private static void display() {
		if(head == null) {
			System.out.println("Nothing to display");
			
		}
		else {
			Node headTemp = head;
			int i = 0;
			System.out.print(headTemp.item + " ");
			while(headTemp.link != null) {
				headTemp = headTemp.link;
				System.out.print(headTemp.item + " ");
				i++;
				if(i == 50)break;
			}
			
//			while(i <= 50) {
//				headTemp = headTemp.link;
//				System.out.print(headTemp.item + " ");
//				i++;
//			}
		}
	}

	private static void createLinkedList(int item) {
		// TODO Auto-generated method stub
		
		if(head == null) {
			Node temp = new Node();
			temp.item = item;
			temp.link = null;
			head = temp;
			
		}
		else if(item == 9) {
			Node headTemp5 = head;
			while(headTemp5.item != 5) {
				headTemp5 = headTemp5.link;
			}
			Node headTemp = head;
			while(headTemp.link != null) {
				headTemp = headTemp.link;
			}
			Node temp = new Node();
			temp.item = item;
			temp.link = headTemp5;
			headTemp.link = temp; 
		}
		else {
			Node headTemp = head;
			while(headTemp.link != null) {
				headTemp = headTemp.link;
			}
			
			Node temp = new Node();
			temp.item = item;
			temp.link = null;
			headTemp.link = temp;
			
		}
		
	}

}
