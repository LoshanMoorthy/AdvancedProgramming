package movieexercise;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoviesApp {
    public static List<Movie> readMovies(String filename) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNextLine()) {
                String nameLine = in.nextLine();
                String yearLine = in.nextLine();
                String directorsLine = in.nextLine();
                String producersLine = in.nextLine();
                String actorsLine = in.nextLine();
                movies.add(new Movie(getString(nameLine),
                        Integer.parseInt(getString(yearLine)),
                        getList(directorsLine), getList(producersLine),
                        getList(actorsLine)));
            }
        }
        return movies;
    }

    private static String getString(String line) {
        int colon = line.indexOf(":");
        return line.substring(colon + 1).trim();
    }

    private static List<String> getList(String line) {
        return Stream.of(getString(line).split(", "))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        List<Movie> movieList = readMovies("D:\\Datamatiker\\3. Semester\\Avanceret Programmering\\movies.txt");

        //  The numer of movies starting with "H"
        long countH = movieList.stream()
                .filter(m -> m.getTitle().startsWith("H"))
                .count();
        System.out.println("Numbers of movies starting with 'H': " + countH);

        // The title of the movies starting with "X"
        List<String> titlesStartingWithX = movieList.stream()
                .filter(m -> m.getTitle().startsWith("X"))
                .map(Movie::getTitle)
                .toList();
        System.out.println("Titles of movies starting with 'X': " + titlesStartingWithX);

        // The number of films where the director is also an actor
        long directorAlsoActorCount = movieList.stream()
                .filter(m -> m.getActors().stream().anyMatch(actor -> m.getDirectors().contains(actor)))
                .count();
        System.out.println("Number of filmes where the director is also an actor: " + directorAlsoActorCount);

        //The number of actors in the film with the most actors
        int maxActors = movieList.stream()
                .mapToInt(m -> m.getActors().size())
                .max()
                .orElse(0);
        System.out.println("Number of actors in the film with the most actors: " + maxActors);

        // The title of the film with the most actors
        String titleWithMostActors = movieList.stream()
                .max(Comparator.comparingInt(m -> m.getActors().size()))
                .map(Movie::getTitle)
                .orElse("No movies found");
        System.out.println("Title of the film with the most actors: " + titleWithMostActors);

        //Number of films divided by first letter in the film title
        Map<Character, Long> moviesByFirstLetter = movieList.stream()
                .collect(Collectors.groupingBy(
                        movie -> movie.getTitle().charAt(0),
                        Collectors.counting()
                ));
        System.out.println("Number of films by first letter: " + moviesByFirstLetter);

        // Number of movies whose title starts with "The "
        long countMoviesStartingWithThe = movieList.stream()
                .filter(m -> m.getTitle().startsWith("The "))
                .count();
        System.out.println("Number of movies starting with 'The ': " + countMoviesStartingWithThe);

//
    }


}

