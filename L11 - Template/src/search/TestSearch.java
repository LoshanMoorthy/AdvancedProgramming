package search;

import java.util.ArrayList;
import java.util.List;

public class TestSearch {

    public static void main(String[] args) {
        List<String> hp = new ArrayList<>();
        hp.add("voldemort");
        hp.add("harry");
        hp.add("ron");
        hp.add("hermione");
        SearchableList<String> searchableList = new SearchableList<>(hp);

        boolean result1 = searchableList.search("harry");
        System.out.println("Søger efter 'harry': " + result1);

        boolean result2 = searchableList.search("hagrid");
        System.out.println("Søger efter 'hagrid': " + result2);
    }
}
