package search;

import java.util.List;

public class BinarySearchList<E extends Comparable<E>> extends SearchPattern<E> {
    private List<E> list;
    private int left;
    private int right;
    private int mid;

    public BinarySearchList(List<E> list) {
        this.list = list;
    }

    @Override
    protected void init() {
        left = 0;
        right = list.size() - 1;
    }

    @Override
    protected boolean isEmpty() {
        return left > right;
    }

    @Override
    protected E select() {
        mid = (left + right) / 2;
        return list.get(mid);
    }

    @Override
    protected void split(E m) {
        if (m.compareTo(list.get(mid)) < 0) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
}
