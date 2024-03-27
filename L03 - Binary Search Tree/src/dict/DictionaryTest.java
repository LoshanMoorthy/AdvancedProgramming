package dict;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DictionaryTest {
    @Test
    @Order(1)
    void test_get_internal() {
        // Arrange
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();
        dictionary.put(83, "Demogorgons");
        dictionary.put(25, "Datamatiker");
        dictionary.put(99, "Bryan Adams");
        dictionary.put(90, "Det fedeste år i verdenshistorien");
        dictionary.put(100, "");
        dictionary.put(90, "Dommedag");
        dictionary.put(82, "Matadormix");

        // Act
        String excpected = "Datamatiker!";
        String actual = dictionary.get(25);

        // Assert
        assertNull(excpected, actual);

    }

    @Test
    @Order(2)
    void test_isEmpty_true() {
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();
        dictionary.put(83, "Demogorgons");

        // Act
        boolean expected = true;
        boolean actual = dictionary.isEmpty();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @Order(3)
    void test_isEmpty_false() {
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();
        dictionary.put(83, "Demogorgons");

        // Act
        boolean expected = false;
        boolean actual = dictionary.isEmpty();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @Order(4)
    void test_put_returnValue() {
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();
        dictionary.put(83, "Demogorgons");
        dictionary.put(25, "Datamatiker!");
        dictionary.put(99, "Bryan Adams");

        // Act
        String expected = "Bryan Adams";
        String actual = dictionary.put(99, "Prince");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @Order(5)
    void test_remove() {
        // Arrange
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();
        dictionary.put(83, "Demogorgons");
        dictionary.put(25, "Datamatiker");
        dictionary.put(99, "Bryan Adams");
        dictionary.put(90, "Det fedeste år i verdenshistorien");
        dictionary.put(100, "");
        dictionary.put(90, "Dommedag");
        dictionary.put(82, "Matadormix");

        // Act
        String excpected = "Demogorgons!";
        String actual = dictionary.remove(83);

        // Assert
        assertNull(excpected, actual);
    }

    @Test
    @Order(6)
    void test_size() {
        // Arrange
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();

        // Act & Assert
        assertEquals(0, dictionary.size());
        dictionary.put(83, "Demogorgons");
        assertEquals(1, dictionary.size());
        dictionary.put(25, "Datamatiker");
        assertEquals(2, dictionary.size());
        dictionary.put(99, "Bryan Adams");
        assertEquals(3, dictionary.size());
        dictionary.remove(83);
        assertEquals(2, dictionary.size());
    }
}