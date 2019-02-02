import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Node{
    int val;
    Node left;
    Node right;
    long lSize;
    long lHeight;
    public Node(int val){
        this.val = val;
        left = null;
        right = null;
        lSize = 0;
        lHeight = 0;
    }
}
public class Solution {
	static long size = 0;
	static Node root = null;
    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
    	int len = arr.length;
    	root = new Node(arr[len - 1]);
    	for(int i = len - 2 ; i >= 0 ; i--) {
    		root = insertAndCountSwaps(root, root.lSize, arr[i]);
    	}
    	return size;
    }

    private static Node insertAndCountSwaps(Node root, long lSize, int val) {
    	
    	if(root == null) {
    		Node temp = new Node(val);
    		temp.lSize = lSize;
    		size += lSize;
    		return temp;
    	}
    	if(val <= root.val) {
    		root.lHeight += 1;
    		root.left = insertAndCountSwaps(root.left, lSize, val);
    		return root;
    	}
    	else {
    		root.lSize = lSize;
    		root.right = insertAndCountSwaps(root.right, root.lSize + root.lHeight + 1, val);
    	}
    	return root;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] result = new long[t];
        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            String[] arrItems = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }
            size = 0;
            result[tItr] = countInversions(arr);
            
        }
        for(int i = 0 ; i < t ; i++) {
        	System.out.println(result[i]);
        }


        scanner.close();
    }
}
