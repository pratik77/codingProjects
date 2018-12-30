import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class HashMapUtil {
	Hashmap memo = new Hashmap();
	long longest = Long.MIN_VALUE;
	long longestAt = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMapUtil hm = new HashMapUtil();
		int n = sc.nextInt();
		for(long i = 2 ; i <= n ; i++) {
			int longest;
			if(hm.memo.get(i) != -1)longest = hm.memo.get(i) ;
			else {
				hm.memo.put(i, hm.findLongest(i));
				longest = hm.findLongest(i);
			}
			if(longest > hm.longest) {
				hm.longest = longest;
				hm.longestAt = i;
			}
		}
		System.out.println(hm.longest + " " + hm.longestAt);
	}
	private int findLongest(long i) {
		// TODO Auto-generated method stub
		if(i == 1) {
			return 1;
		}
		if(memo.get(i) != -1) return memo.get(i);
		
		
		if(i % 2 == 0) {
			if(memo.get(i / 2) != -1) memo.put(i, memo.get(i / 2) + 1);
			else {
				//System.out.println(i);
				memo.put(i, findLongest(i / 2) + 1);
			}
			return memo.get(i);
			
		}
		if(memo.get(3 * i + 1) != -1) memo.put(i, memo.get(3 * i + 1) + 1);
		//System.out.println(i);
		else memo.put(i, findLongest(3 * i + 1) + 1);
		return memo.get(i);
	}

}

class Node{
	long i;
	int longest;
	public Node(long i, int longest) {
		this.i = i;
		this.longest = longest;
	}
}

class Hashmap{
	
	int BUCKETS = 10000007 ;
	LinkedList<Node> buckets[] = new LinkedList[BUCKETS];
	
	public Hashmap() {
		for(int i = 0 ; i < BUCKETS ; i++) {
			buckets[i] = new LinkedList<Node>();
		}
	}
	
	public void put(long i, int longest) {
		
		long hash = getHash(i);
		buckets[(int)hash].add(new Node(i, longest));
		
	}
	
	public int get(long i) {
		long hash = getHash(i);
		//System.out.println(hash);
		for(Node node : buckets[(int)hash]) {
			if(node.i == i)return node.longest;
		}
		return -1;
	}

	private long getHash(long i) {
		// TODO Auto-generated method stub
		
		return i % (long)BUCKETS;
	}
}
