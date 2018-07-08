package LeetCode.Design;

import java.util.HashMap;

class LRUCache {
	private int capacity;
	
	HashMap<Integer,Node> cache= new HashMap<>();
	Node head, tail;
	
    public LRUCache(int capacity) {
      this.capacity=capacity;  
    }
    public int get(int key) {
        if(cache.containsKey(key)) {
        	Node node = cache.get(key);
        	removeFromList(node);
        	insertAtHead(new Node(node.key,node.value));
        	return cache.get(key).value;
        }
        return -1;
    }
    private void removeFromList(Node node) {
		if(node==null)
			return;
		if(node.prev!=null)node.prev.next=node.next;
		if(node.next!=null)node.next.prev=node.prev;
		if(node==tail) {
			tail=tail.prev;
		}
		if(node==head) {
			head=node.next;
		}
		
	}
	private void insertAtHead(Node node) {
    	if(head==null) {
			head=node;
			tail=node;
		}else if(node!=head) {
		head.prev=node;
		node.next = head;
		head = node;
    	}
	}
	public void put(int key, int value) {
       
		if(cache.containsKey(key)) {
        	Node nodetoRemove = cache.get(key);
        	removeFromList(nodetoRemove);
        }
        else if(cache.size()==capacity) {
        	removeLastFromList();
        }
        Node node = new Node(key,value);
        	insertAtHead(node);
        	cache.put(key, node);
    }

	private void removeLastFromList() {
		Node node = cache.get(tail.key);
		cache.remove(tail.key);
		removeFromList(node);
	}
}

