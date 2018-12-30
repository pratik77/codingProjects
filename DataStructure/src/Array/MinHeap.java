package Array;

public class MinHeap {

	int[] heap;
	int size;
	int maxSize;
	
	public MinHeap(int maxSize) {
		this.size = 0;
		this.maxSize = maxSize;
		this.heap = new int[maxSize];
		this.heap[0] = Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MinHeap mn = new MinHeap(20);
		mn.insert(7);
		mn.insert(6);
		mn.insert(4);
		mn.insert(5);
		mn.insert(2);
		int key;
		key = mn.extract(0);
		System.out.println(key);
		System.out.println();
		key = mn.extract(0);
		System.out.println(key);
		
	}

	private int extract(int index) throws Exception {
		// TODO Auto-generated method stub
		if(size == 0)throw new Exception("No elements to extract");
		int key = heap[index];
		heap[index] = heap[size - 1];
		while(heap[index] > heap[2 * index + 1 ]) {
			swap(2 * index + 1);
			index = 2 * index + 1;
		}
		size--;
		return key;
		
	}

	private void delete(int i) {
		// TODO Auto-generated method stub
		
	}

	private void insert(int i) {
		
		heap[size++] = i ;
		int current = size - 1;
		while(heap[current] < heap[(current - 1) / 2]) {
			swap(current);
			current = (current - 1) / 2;
		}
		
	}

	private void swap(int current) {
		heap[(current - 1) / 2] = heap[(current - 1) / 2] - heap[current];
		heap[current] = heap[current] + heap[(current - 1) / 2];
		heap[(current - 1) / 2] = heap[current] - heap[(current - 1) / 2];
		
	}

}
