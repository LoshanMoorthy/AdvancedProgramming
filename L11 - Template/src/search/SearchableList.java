package search;

import java.util.Iterator;
import java.util.List;

public class SearchableList<E extends Comparable<E>> extends SearchPattern<E> {
    private List<E> list;
    private Iterator<E> iterator;
    private E current;

    public SearchableList(List<E> list) {
        this.list = list;
    }

    @Override
    protected void init() {
        iterator = list.iterator();
    }

    protected boolean isEmpty() {
        return !iterator.hasNext();
    }

    protected E select() {
        if (iterator.hasNext())
            current = iterator.next();
        return current;
    }

    @Override
    protected void split(E m) {

    }
}
