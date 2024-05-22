package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestBinarySearch {

    public static void main(String[] args) {
        List<String> hp = new ArrayList<>();
        hp.add("voldemort");
        hp.add("harry");
        hp.add("ron");
        hp.add("hermione");

        Collections.sort(hp);

        BinarySearchList<String> binarySearchList = new BinarySearchList<>(hp);

        boolean result1 = binarySearchList.search("harry");
        System.out.println("Søger efter 'harry': " + result1);

        boolean result2 = binarySearchList.search("hagrid");
        System.out.println("Søger efter 'hagrid': " + result2);
    }
}
