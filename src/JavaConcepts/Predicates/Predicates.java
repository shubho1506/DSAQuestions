package JavaConcepts.Predicates;

//A Predicate<T> is a functional interface in Java (java.util.function.Predicate) that:
//Represents a boolean-valued function of one argument.
//Typically used for filtering or matching conditions.
//Introduced in Java 8 as part of the functional programming features (like lambda expressions).
//So, any lambda or method reference that takes one argument and returns true/false can be used as a Predicate.

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Product {
    String name;
    double price;

    Product(String name, double price){
        this.name = name;
        this.price = price;
    }
}

public class Predicates {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Shubhodeep", "Ram", "Sita", "Arjun");

        Predicate<String> longerThan4 = name -> name.length() > 4;

        names.stream()
                .filter(longerThan4)
                .forEach(System.out::println);

//        Methods in Predicate Interface
//        1. test(T t)
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10)); // true

//        2. and(Predicate other)
//        Combines two predicates with logical AND.
        Predicate<Integer> isEven1 = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        Predicate<Integer> isEvenAndPositive = isEven1.and(isPositive);
        System.out.println(isEvenAndPositive.test(4));   // true
        System.out.println(isEvenAndPositive.test(-2));  // false


//        3. or(Predicate other)
//        Combines two predicates with logical OR.
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> endsWithZ = s -> s.endsWith("Z");

        Predicate<String> combined = startsWithA.or(endsWithZ);
        System.out.println(combined.test("Amazon")); // true
        System.out.println(combined.test("Buzz"));   // true


//        4. negate()
//        Reverses the result.
        Predicate<Integer> isEven2 = n -> n % 2 == 0;
        Predicate<Integer> isOdd = isEven2.negate();

        System.out.println(isOdd.test(5)); // true


//        5. isEqual(Object targetRef)
//        Static method that returns a predicate checking if input equals the given object.
        Predicate<String> isShubho = Predicate.isEqual("Shubhodeep");
        System.out.println(isShubho.test("Shubhodeep")); // true



//        Filter all expensive products:
        List<Product> products = Arrays.asList(new Product("A",100),new Product("B",2000));

                Predicate<Product> expensive = p -> p.price > 1000;

        products.stream()
                .filter(expensive)
                .forEach(p -> System.out.println(p.name));
    }
}
