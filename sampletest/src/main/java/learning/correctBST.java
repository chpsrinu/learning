package learning;
//https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
public class correctBST {

	class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	class BinaryTree {
		Node first, middle, last, prev;
		// This function does inorder traversal 
	    // to find out the two swapped nodes. 
	    // It sets three pointers, first, middle 
	    // and last. If the swapped nodes are 
	    // adjacent to each other, then first  
	    // and middle contain the resultant nodes 
	    // Else, first and last contain the  
	    // resultant nodes 
		void correctBSTUtil(Node root) {
			if(root != null) {
				correctBSTUtil(root.left);
				
				// If this node is smaller than 
	            // the previous node, it's  
	            // violating the BST rule.
				if (prev != null && root.data < prev.data) {
					// If this is first violation, 
	                // mark these two nodes as 
	                // 'first' and 'middle'
					if (first == null) {
						first = prev;
						middle = root;
					} else {
						last = root;
					}
				}
				prev = root;
				correctBSTUtil(root.right);
			}
		}
		
		// A function to fix a given BST where  
	    // two nodes are swapped. This function  
	    // uses correctBSTUtil() to find out  
	    // two nodes and swaps the nodes to  
	    // fix the BST 
		void correctBST(Node root) {
			first = middle=last=prev=null;
			// Set the poiters to find out two nodes 
			correctBSTUtil(root);
			// Fix (or correct) the tree 
			if(first != null && last != null) {
				int temp = first.data;
				first.data = last.data;
				last.data = temp;
			}
			// Adjacent nodes swapped
			else if(first != null && middle != null) {
				int temp = first.data;
				first.data = middle.data;
				middle.data = temp;
			}
		}
		
		//utility function to print Inorder traversal
		void printInOrder(Node node) {
			if (node == null) return;
			
			printInOrder(node.left);
			System.out.println(" "+node.data);
			printInOrder(node.right);
		}
	}
		
		public static void main(String[] args) {
		/*   6 
            / \ 
           10  2 
          / \ / \ 
         1  3 7 12 
          
        10 and 2 are swapped 
        */
			Node root = new correctBST().new Node(6); 
	        root.left = new correctBST().new Node(10); 
	        root.right = new correctBST().new Node(2); 
	        root.left.left = new correctBST().new Node(1); 
	        root.left.right = new correctBST().new Node(3); 
	        root.right.right = new correctBST().new Node(12); 
	        root.right.left = new correctBST().new Node(7); 
	        
	        System.out.println("Inorder Traversal of the original tree");
	        BinaryTree tree = new correctBST().new BinaryTree();
	        tree.printInOrder(root);
	        tree.correctBST(root);
	        System.out.println("Inorder traversal of the corrected tree");
	        tree.printInOrder(root);
		}
	
}
