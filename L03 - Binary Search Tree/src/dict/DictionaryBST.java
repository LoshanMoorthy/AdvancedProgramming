package dict;

public class DictionaryBST<K extends Comparable<K>, V> implements
Dictionary<K, V> {

	private Node root;

	public DictionaryBST() {
		root = null;
	}

	@Override
	public V get(K key) {
		return find(key).value;

	}

	private Node find(K key) {
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (found) {
			return current;
		} else {
			return null;
		}

	}

	@Override
	public boolean isEmpty() {
		// TODO
		return false;
	}

	@Override
	public V put(K key, V value) {
		if (root == null) {
			root = new Node(key, value);
			return null;
		} else {
			Node parent = null;
			Node current = root;
			while (current != null) {
				parent = current;
				int compare = key.compareTo(current.key);
				if (compare < 0) {
					current = current.right;
				} else if (compare > 0) {
					current = current.left;
				} else {
					V oldValue = current.value;
					current.value = value;
					return oldValue;
				}
			}

			int compare = key.compareTo(parent.key);
			if (compare < 0) {
				parent.left = new Node(key, value);
			} else {
				parent.right = new Node(key, value);
			}

			return null;
		}
	}

	private

	@Override
	public V remove(K key) {
		// TODO
		return null;
	}

	@Override
	public int size() {
		// TODO
		return -1;
	}

	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}


	}

}
