package JavaConcepts.LambdaFunctions;

//A lambda expression in Java is a short and clear way to
// implement a functional interface (an interface with only one abstract method).
//Syntax:
//(parameter1, parameter2) -> { // body }
//A lambda replaces the need for writing anonymous classes for functional interfaces.

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class LambdaFunctions {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Shubhodeep", "Amit", "Rahul");

        // Using lambda to sort by length
        names.sort((a, b) -> a.length() - b.length());
        System.out.println(names);

        // Rules of Lambda in Java
        //Element	            Rule
        //Parameters        	Can omit type (type inference works)
        //Parentheses       	Optional for one parameter, required for multiple
        //Body              	Use {} for multiple statements, omit for single statement
        //Return            	Optional if single line

        //No parameters
        Runnable r = () -> System.out.println("Hello, Lambda!");
        r.run();

        //one parameters
        Consumer<String> printer = s -> System.out.println("Hello, " + s);
        printer.accept("Shubhodeep");

        //Multiple parameters
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 20)); // 30

        //Filtering a list with Predicate:
        List<String> namesList = Arrays.asList("Amit", "Shubhodeep", "Ravi");
        namesList.stream()
                .filter(name -> name.length() > 5)
                .forEach(System.out::println);

        //Sorting a list using Comparator:
        List<String> cities = Arrays.asList("Mumbai", "Delhi", "Bangalore");

        cities.sort((a, b) -> a.compareToIgnoreCase(b));
        System.out.println(cities);

    }
}
