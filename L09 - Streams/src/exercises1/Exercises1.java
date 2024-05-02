package exercises1;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exercises1 {

    public static void main(String[] args) {
        // Liste med tal mellem 1 - 50
        List<Integer> list = List.of(1,2,3,2,1,6,3,4,5,2,3,8,8,9,34,32);
        list.stream().forEach(e-> System.out.println(e+1));

        //	Udskriver det største element i listen
        int maxElement = list.stream().max(Integer::compareTo).orElseThrow();
        System.out.println("Largest element: " + maxElement);

        //	Afgør og udskriver om alle tallene i listen er mindre end 50
        boolean allLessThan50 = list.stream().allMatch(n -> n < 50);
        System.out.println("Is all numbers less than 50: " + allLessThan50);

        // 	Udskriver antallet af lige tal i listen
        long evenCount = list.stream().filter(n -> n % 2 == 0).count();
        System.out.println("Count of even numbers: " + evenCount);

        //	Udskriver antallet af ulige tal i listen
        long oddCount = list.stream().filter(n -> n % 2 != 0).count();
        System.out.println("Count of odd numbers: " + oddCount);

        //  Udskriver
        //      Gennemsnittet af tallene i listen
        //      Antallet af tallene i listen
        //      Antallet af tallene i listen der er større end gennemsnittet
        //      Antallet af tallene i listen der er mindre end gennemsnittet
        double average = list.stream().mapToInt(Integer::intValue).average().orElseThrow();
        System.out.println("Average of the numbers: " + average);
        long countGreaterThanAverage = list.stream().filter(n -> n > average).count();
        System.out.println("Numbers greater than the average: " + countGreaterThanAverage);
        long countLessThanAverage = list.stream().filter(n -> n < average).count();
        System.out.println("Numbers less than average: " + countLessThanAverage);

        //	Udskriver antallet af gange de forskellige tal forekommer i listen
        Map<Integer, Long> freqMap = list.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println("Frequency of each number: " + freqMap);

        //	Udskriver antallet af gange de forskellige tal forekommer i listen i sorteret orden
        TreeMap<Integer, Long> sortedFreqMap = new TreeMap<>(freqMap);
        System.out.println("Sorted freq of each number: " + sortedFreqMap);
    }
}
