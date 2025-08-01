package JavaConcepts;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Charlie", 35);

        // Get the entrySet view
        Set<Map.Entry<String, Integer>> entrySet = ages.entrySet();

        // Iterate through the entries
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println("Name: " + entry.getKey() + ", Age: " + entry.getValue());
        }


        // Modifying a value through the entrySet
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getKey().equals("Alice")) {
                entry.setValue(31); // Updates the value in the original map
            }
        }
        System.out.println("Updated ages: " + ages);
    }
}
