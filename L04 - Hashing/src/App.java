import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        HashSet hash = new HashSet<>();

        Bil bil1 = new Bil("Porsche", "GT3", "Sort", "123");
        Bil bil2 = new Bil("Porsche", "GT2", "Sort", "234");
        Bil bil3 = new Bil("Porsche", "GT4", "Sort", "345");
        Bil bil4 = new Bil("Porsche", "Touring", "Sort", "456");
        Bil bil5 = new Bil("Porsche", "Touring", "Sort", "456");

        hash.add(bil1);
        hash.add(bil2);
        hash.add(bil3);
        hash.add(bil4);
        hash.add(bil5);

        System.out.println(hash);
    }
}
