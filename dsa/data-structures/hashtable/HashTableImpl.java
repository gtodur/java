package practice.hashtable;

public class HashTableImpl {

	private HashNode[] buckets;
	private int numOfbuckets;	//total capacity of HashTable
	private int size;			//current number of HashNodes in HashTable
	
	public HashTableImpl() {
		this(10);	//default capacity
	}
	
	public HashTableImpl(int capacity) {
		this.numOfbuckets = capacity;
		this.buckets = new HashNode[capacity];
		this.size = 0;
	}
	
	private class HashNode {
		private Integer key;
		private String value;
		private HashNode next;
		
		public HashNode(Integer key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void put(Integer key, String value) throws Exception {
		if(key == null || value == null) {
			throw new Exception("Key or value cannot be null");
		}
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		while(head != null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		size++;
		head = buckets[bucketIndex];
		HashNode node = new HashNode(key, value);
		node.next = head;
		buckets[bucketIndex] = node;
	}
	
	public String get(Integer key) throws Exception {
		if(key == null) {
			throw new Exception("key is null");
		}
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	
	public String remove(Integer key) throws Exception {
		if(key == null) {
			throw new Exception("Key is null");
		}
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		HashNode previous = null;
		
		while(head != null) {
			if(head.key.equals(key)) {
				break;
			}
			previous = head;
			head = head.next;
		}
		if(head == null) {
			return null;
		}
		size--;
		if(previous != null) {
			previous.next = head.next;
		} else {
			buckets[bucketIndex] = head.next;
		}
		return null;
	}

	private int getBucketIndex(Integer key) {
		return key % numOfbuckets;
	}
}
