package hashing;

public class HashSetLinearProbing {
	private Object[] buckets;
	private int currentSize;
	private static final String DELETED = "DELETED";

	public HashSetLinearProbing(int bucketsLength) {
		buckets = new Object[bucketsLength];
		currentSize = 0;
	}

	public boolean contains(Object x) {
		int h = hashValue(x);
		int stopIndex = h;
		do {
			if (buckets[h] == null) return false;
			if (buckets[h] != DELETED && buckets[h].equals(x)) return true;
			h = (h + 1) % buckets.length;
		} while (h != stopIndex);
		return false;
	}

	public boolean add(Object x) {
		if (contains(x)) return false;
		int h = hashValue(x);
		while (buckets[h] != null && buckets[h] != DELETED) {
			h = (h + 1) % buckets.length;
		}
		buckets[h] = x;
		currentSize++;
		return true;
	}

	public boolean remove(Object x) {
		int h = hashValue(x);
		int stopIndex = h;
		boolean wrapped = false;

		while (buckets[h] != null || !wrapped) {
			if (buckets[h] == null) {
				return false;
			}
			if (buckets[h] != DELETED && buckets[h].equals(x)) {
				buckets[h] = DELETED;
				currentSize--;
				return true;
			}
			h = (h + 1) % buckets.length;
			if (h == stopIndex) {
				if (wrapped) break;
				wrapped = true;
			}
		}
		return false;
	}


	public int size() {
		return currentSize;
	}

	private int hashValue(Object x) {
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		return h % buckets.length;
	}

	public void writeOut() {
		for (int i = 0; i < buckets.length; i++) {
			System.out.println(i + "\t" + buckets[i]);
		}
	}
}
