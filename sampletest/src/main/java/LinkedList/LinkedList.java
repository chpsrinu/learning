package LinkedList;

public class LinkedList<T extends  Comparable<T>> implements List<T> {

	private Node<T> root;
	private int sizeOfList;
	
	@Override
	public void insert(T data) {
		++this.sizeOfList;
		
		if(root == null) {
			 this.root = new Node<>(data);
		} else {
			insertDataAtBeginning(data);
		}
	}
	
	// O(1)
	private void insertDataAtBeginning(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.setNextNode(root);
		this.root = newNode;
	}
	
	//O(n)
	private void insertDataAtEnd(T data, Node node) {
		if (node.getNextNode() != null) {
			insertDataAtEnd(data, node.getNextNode());
		} else {
			Node<T> newNode = new Node<>(data);
			node.setNextNode(newNode);
		}
	}

	@Override
	public void remove(T data) {
		if(this.root == null) return;
		--this.sizeOfList;
		
		if( this.root.getData().compareTo(data) == 0) {
			this.root = this.root.getNextNode();
		} else {
			remove(data, root, root.getNextNode());
		}
	}
	
	private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
		while(actualNode != null) {
			if(actualNode.getData().compareTo(data) == 0) {
				previousNode.setNextNode(actualNode.getNextNode());
				actualNode = null;
				return;
			}
			
			previousNode = actualNode;
			actualNode = actualNode.getNextNode();
		}
	}

	@Override
	public void traversalList() {
		Node<T> node = root;
		if(this.root == null) return;
		
		while(node != null) {
			System.out.print(node.getData());
			node = node.getNextNode();
		}
		
		
	}

	@Override
	public int size() {
		return this.sizeOfList;
	}

	@Override
	public Node<T> getMiddleNode() {
		Node<T> fastPointer = this.root;
		Node<T> slowPointer = this.root;
		
		while (fastPointer.getNextNode() != null && fastPointer.getNextNode().getNextNode() != null) {
			slowPointer = slowPointer.getNextNode();
			fastPointer = fastPointer.getNextNode().getNextNode();
		}
		return slowPointer;
	}

	@Override
	public void reverse() {
		
		Node<T> prevNode = null;
		Node<T> currNode = this.root;
		Node<T> nextNode = null;
		
		while (currNode != null) {
			nextNode = currNode.getNextNode();
			currNode.setNextNode(prevNode);
			prevNode = currNode;
			currNode = nextNode;
		}
		
		this.root = prevNode;
		
	}

	@Override
	public int sizeOfList() {
		int size = 0;
		Node<T> node = this.root;
		while (node!=null) {
			size++;
			node = node.getNextNode();
		}
		return size;
	}

	@Override
	public boolean isCyclic() {
		Node<T> fast = this.root;
		Node<T> slow = this.root;
		
		while(fast != null && fast.getNextNode() != null) {
			
			if(fast == slow) {
				return true;
			}
			
			fast = fast.getNextNode().getNextNode();
			slow = slow.getNextNode();
		}
		return false;
	}
	//detectcycle II
	public Node detectCycle(Node head) {
		Node slow = head, fast = head;
		while(fast != null && fast.getNextNode() != null) {
			fast = fast.getNextNode().getNextNode();
			slow = slow.getNextNode();
			if (slow == fast) {
				while (head != slow) {
					head = head.getNextNode();
					slow = slow.getNextNode();
				}
				return slow;				
			}
		}			
		return null;
	}
	
	//Nth Node From end list
	public Node removeNthFromEnd(Node head, int n) {
		Node dummy = new Node(0);
		dummy.setNextNode(head);
		Node first =dummy, second=dummy;
		for(int i=1;i<=n+1;i++) {
			first = first.getNextNode();
		}
		while(first!=null) {
			second = second.getNextNode();
			first = first.getNextNode();
		}
		second.setNextNode(second.getNextNode().getNextNode());
		return dummy.getNextNode();
	}
	
	//merge two sorted lists
	public Node megeTwoLists(Node l1, Node l2) {
		Node head = new Node(0);
		Node p=head;
		
		Node p1=l1;
		Node p2=l2;
		while(p1!=null && p2!=null) {
			if(p1.getData() < p2.getData()) {
				p.setNextNode(p1);
				p1 = p1.getNextNode();
			} else {
				p.setNextNode(p2);
				p2 = p2.getNextNode();
			}
			p=p.getNextNode();
		}
		if(p1!=null)
			p.setNextNode(p1);;
		if(p2!=null)
			p.setNextNode(p2);
		return head.getNextNode();
	}

}
