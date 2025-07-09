package JavaConcepts.StreamAPI;

//The Stream API (introduced in Java 8) provides a powerful and declarative way to process collections of data
// (like Lists, Sets, etc.).
//It supports:
//Functional-style operations
//Lazy evaluation (executed only when needed)
//Chaining operations like map → filter → collect
//Efficient parallel operations


//There are three stages in a stream pipeline:
//Stage	            Type	                                            Examples
//Source    	 Create the stream           	                    list.stream(), Stream.of(...)
//Intermediate   Operations	Transform or filter data	            filter(), map(), sorted()
//Terminal       Operations	Produce result or trigger processing	collect(), forEach(), count()


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamAPI {
    public static void main(String[] args) {
//        🔹 1. filter(Predicate<T>)
//        Filters elements based on a condition.

        List<String> names = List.of("Shubhodeep", "Ram", "Ravi");

        names.stream()
                .filter(n -> n.startsWith("R"))
                .forEach(System.out::println); // Ram, Ravi

//        🔹 2. map(Function<T,R>)
//        Transforms each element.

        List<String> names1 = List.of("a", "b", "c");

        List<String> upper = names1.stream()
                .map(s -> s.toUpperCase())
                .toList();

        System.out.println(upper); // [A, B, C]

//        🔹 3. flatMap(Function<T, Stream<R>>)
//        Flattens nested collections.

        List<List<String>> data = List.of(List.of("A", "B"), List.of("C", "D"));

        List<String> result = data.stream()
                .flatMap(list -> list.stream())
                .toList();

        System.out.println(result); // [A, B, C, D]

//        🔹 4. sorted() / sorted(Comparator)
//        Sort elements.

        List<Integer> numbers = List.of(4, 2, 1, 5);

        numbers.stream()
                .sorted()
                .forEach(System.out::println); // 1 2 4 5

//        Custom sort:
//        list.stream().sorted((a, b) -> b - a);

//        🔹 5. distinct()
//        Removes duplicates.

        List<Integer> nums = List.of(1, 2, 2, 3);

        nums.stream()
                .distinct()
                .forEach(System.out::println); // 1 2 3

//        🔹 6. limit(n)
//        Takes first n elements.

        Stream.of(1, 2, 3, 4, 5)
                .limit(3)
                .forEach(System.out::println); // 1 2 3


//        🔹 7. skip(n)
//        Skips first n elements.

        Stream.of(1, 2, 3, 4, 5)
                .skip(2)
                .forEach(System.out::println); // 3 4 5


//        🔹 8. collect()
//        Terminal operation to collect results into a collection.

        List<String> result1 = names.stream()
                .filter(n -> n.startsWith("R"))
                .collect(Collectors.toList());


//        🔹 9. forEach(Consumer)
//        Terminal operation to perform action on each item.

        names.stream().forEach(System.out::println);

//        🔹 10. count()
//        Counts number of elements.

        long count = nums.stream()
                .filter(x -> x > 5)
                .count();

//        🔹 11. anyMatch() / allMatch() / noneMatch()
//        Check conditions on elements:

        nums.stream().anyMatch(x -> x > 10); // true if any match
        nums.stream().allMatch(x -> x > 0);  // true if all match
        nums.stream().noneMatch(x -> x < 0); // true if none match

//        🔹 12. reduce()
//        Performs aggregation.

        int sum = Stream.of(1, 2, 3, 4)
                .reduce(0, (a, b) -> a + b); // 10


//        🔹 14. findFirst() / findAny()
//        Returns Optional of first or any element:

        Optional<String> result2 = names.stream().findFirst();

//        🔹 15. toArray()
//        Collects to array:

        String[] array = names1.stream().toArray(String[]::new);

        List<String> nameList = List.of("Shubhodeep", "Shubham", "Ankit", "Rohit");

        List<String> filteredSorted = nameList.stream()
                .filter(n -> n.startsWith("S"))
                .map(String::toUpperCase)
                .sorted()
                .toList();

        System.out.println(filteredSorted); // [SHUBHAM, SHUBHODEEP]

    }
}
