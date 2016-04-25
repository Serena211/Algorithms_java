package Class07_Hashtable_String1;

public class MyHashMap {

	// Node is a static class of MyHashMap, since it is:
	// very closely bonded to MyHashMap class.
	// we probably need to access this class outside from MyHashMap class.
	public static class Node {
		final Integer key;
		String value;
		Node next;

		Node(Integer key, String value) {
			this.key = key;
			this.value = value;
		}

		public Integer getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	private int size = 0;
	private Node[] buckets;
	private float loadFactor;
	public static final int DEFAULT_CAPACITY = 16;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;

	public MyHashMap(int capacity, float loadFactor) {
		buckets = new Node[capacity];
		this.loadFactor = loadFactor;
	}

	public MyHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String get(Integer key) {
		if (size == 0) {
			// throw exception
		}
		// hashCode can be negative
		int bucketNumber = Math.abs(key.hashCode()) % buckets.length;
		Node head = buckets[bucketNumber];
		while (head != null && !head.getKey().equals(key)) {
			head = head.next;
		}
		return head == null ? null : head.getValue();
	}

	public void put(Integer key, String value) {
		Node newNode = new Node(key, value);
		int bucketNumber = Math.abs(key.hashCode()) % buckets.length;
		Node head = buckets[bucketNumber];
		while (head != null && !head.getKey().equals(key)) {
			head = head.next;
		}
		if (head == null) {
			head = newNode;
		} else {
			head.setValue(value);
		}
		size++;
	}
}
