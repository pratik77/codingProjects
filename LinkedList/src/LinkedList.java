
class Node{
	int item;
	Node link;
}

public class LinkedList {
	Node head = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList items = new LinkedList();
		items.add(10);
		items.add(20);
		items.add(30);
		items.add(15);
		items.add(5);
		items.add(50);
		items.display();
		items.insertBefore(100,25);
		items.display();
		
	

	}
	private void insertBefore(int i, int j) {
		if(head == null)
			System.out.println("no items");
		else {
			Node p = head;
			while(p != null) {
				if(p == head && p.item==i) {
					Node temp= new Node();
					temp.item=j;
					temp.link=p;
					head=temp;
					break;
				}
				else if( p.link!=null) {
					if(p.link.item==i) {
					Node temp= new Node();
					temp.item=j;
					temp.link=p.link;
					p.link=temp;
					break;
					}
				}
				p=p.link;
			}
			if(p==null)
				System.out.println("no such item");
			
			
		}
		
		
	}
	private void display() {
		System.out.println("========");
		if(head == null)
			System.out.println("no items");
		else {
			Node p = head;
			while(p != null) {
				
				System.out.println(p.item);
				p=p.link;
			}
		}
		
	}
	private void add(int i) {
		// TODO Auto-generated method stub
		if(head == null) {
			head = new Node();
			Node temp= head;
			temp.item=i;
			temp.link=null;
		}
		else {
			Node p = head;
			Node temp = new Node();
			while(p.link != null)
				p=p.link;
			temp.item=i;
			temp.link=null;
			p.link=temp;
		}
			
		
	}

}
