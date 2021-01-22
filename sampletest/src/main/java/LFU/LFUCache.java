package LFU;

import java.util.HashMap;
import java.util.Map;

//https://www.dineshonjava.com/least-frequently-used-lfu-cache-implementation/
public class LFUCache {
	
	Node head;
	Node tail;
	Map<Long, Node> map = null;
	int capacity = 0;
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Long, Node>();
	}
	
	public long get(long key) {
		
		if (map.get(key) == null) {
			return -1;
		}
		
		Node item = map.get(key);
		// move to right position according to frequency
		removeNode(item);
		item.frequency = item.frequency+1;
		addNodeWithUpdateFrequency(item);
		
		return item.value;
	}
	
	public void put(Long key, int value) {
		if (map.containsKey(key)) {
			Node item = map.get(key);
			item.value = value;
			item.frequency = item.frequency+1;
			//move to right position according to frequency
			removeNode(item);
			addNodeWithUpdateFrequency(item);
		} else {
			if (map.size() >= capacity) {
				//delete head with least frequency and least recently used
				map.remove(head.key);
				removeNode(head);
			}
			
			//move to right posisiton according to frequency
			Node node = new Node(key, value, 1);
			addNodeWithUpdateFrequency(node);
			map.put(key, node);
		}
	}
	
	private void removeNode(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}
		
		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}
	}
	
	private void addNodeWithUpdateFrequency(Node node) {
		if (tail != null && head != null) {
			Node temp = head;
			while(temp!= null) {
				if (temp.frequency > node.frequency) {
					if (temp == head) {
						node.next = temp;
						temp.prev = node;
						head = node;
						break;
					} else {
						node.next = temp;
						node.prev = temp.prev;
						temp.prev.next = node;
						node.prev = temp.prev;
						break;
					}
				} else {
					temp = temp.next;
					if (temp == null) {
						tail.next = node;
						node.prev = tail;
						node.next = null;
						tail = node;
						break;
					}
 				}
			}
		} else {
			tail = node;
			head = tail;
		}
	}

}
