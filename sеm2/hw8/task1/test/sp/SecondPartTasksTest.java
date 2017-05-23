package sp;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SecondPartTasksTest {

    @Test
    public void testFindQuotes() {
        String first = "first very interesting line";
        String second = "second even more interesting line";
        String third = "and third - you would never believe something can be so interesting";
        List<String> paths = Arrays.asList(first, second, third);
        assertEquals(paths, SecondPartTasks.findQuotes(paths, "interesting"));
        assertEquals(Arrays.asList(first, second), SecondPartTasks.findQuotes(paths, "line"));
        assertEquals(Arrays.asList(third), SecondPartTasks.findQuotes(paths, "never"));
    }

    @Test
    public void testPiDividedBy4() {
        assertEquals(SecondPartTasks.piDividedBy4(), Math.PI / 4, 0.01);
    }

    @Test
    public void testFindPrinter() {
        Map<String, List<String>> compositions = new HashMap<>();
        compositions.put("Gregory Oster", Arrays.asList("Harmful advice", "Kitten Named Bow-Wow"));
        compositions.put("Joanne Rowling", Arrays.asList("HP and the Philosopher's Stone",
                "HP and the Chamber of Secrets", "HP and the Prisoner of Azkaban",
                "HP and the Goblet of Fire", "HP and the Order of the Phoenix",
                "HP and the Half-Blood Prince", "HP and the Deathly Hallows"));
        compositions.put("Mikhail Bulgakov", Arrays.asList("The Master and Margarita", "Heart of a Dog", "Notes of a country doctor"));
        assertEquals("Joanne Rowling", SecondPartTasks.findPrinter(compositions));
    }

    @Test
    public void testCalculateGlobalOrder() {
        Map<String, Integer> firstOrder = new HashMap<>();
        firstOrder.put("Apple", 3);
        firstOrder.put("Pear", 8);
        firstOrder.put("Pineapple", 9);

        Map<String, Integer> secondOrder = new HashMap<>();
        secondOrder.put("Pear", 1);
        secondOrder.put("Melon", 2);
        secondOrder.put("Pineapple", 2);
        secondOrder.put("Watermelon", 3);

        Map<String, Integer> thirdOrder = new HashMap<>();
        thirdOrder.put("Apple", 10);
        thirdOrder.put("Watermelon", 2);
        thirdOrder.put("Pear", 2);
        thirdOrder.put("Melon", 3);

        List<Map<String, Integer>> orders = Arrays.asList(firstOrder, secondOrder, thirdOrder);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Apple", 13);
        expected.put("Pear", 11);
        expected.put("Pineapple", 11);
        expected.put("Melon", 5);
        expected.put("Watermelon", 5);

        assertEquals(expected, SecondPartTasks.calculateGlobalOrder(orders));
    }
}