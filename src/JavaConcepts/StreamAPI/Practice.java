package JavaConcepts.StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
//        Basic Level
//        1. Print even numbers from a list.
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        nums.stream().filter(a-> a%2==0).forEach(System.out::println);

//        2. Convert a list of strings to uppercase.
        List<String> names = List.of("ram", "shyam", "geeta");
        names.stream().map(s->s.toUpperCase()).forEach(System.out::println);

//        3. Count strings whose length > 4.
        List<String> words = List.of("pen", "pencil", "notebook", "bag");
        System.out.println(words.stream().filter(a->a.length()>4).count());;

//        4. Get the first 3 elements from a list.
        List<Integer> nums2 = List.of(10, 20, 30, 40, 50, 60);
        nums2.stream().limit(3).forEach(System.out::println);

//        Intermediate Level
//        5. Remove duplicates from a list of integers.
        List<Integer> nums1 = List.of(1, 2, 2, 3, 4, 4, 5);
        System.out.println(nums1.stream().distinct().toList());;

//        6. Sort a list of strings in reverse order.
        System.out.println(words.stream().sorted((a,b)->a.compareToIgnoreCase(b)).toList());

//        7. Find the longest string in a list.
        System.out.println(words.stream().max(Comparator.comparingInt(a->a.length())).orElse("No data"));

//        8. Flatten a list of lists into a single list.
        List<List<String>> nested = List.of(List.of("A", "B"), List.of("C", "D"));
        System.out.println(nested.stream()
                .flatMap(List::stream)
                .toList());

//        9. Filter students with marks > 70 and collect names.
        class Student {
            String name;
            int marks;
            Student(String name,int marks){
                this.name=name;
                this.marks=marks;
            }
        }

        List<Student> students = List.of(
                new Student("A", 60),
                new Student("B", 75),
                new Student("C", 90)
        );

        System.out.println(students.
                stream().
                filter(a->a.marks>70)
                .map(a->a.name).toList());


//        10. Count how many names start with a vowel.
        List<String> names1 = List.of("Anil", "Esha", "Ishaan", "Ram", "Umesh");
        System.out.println(names1.stream().filter(name -> name.matches("(?i)^[aeiou].*"))
                .toList());

//        Advanced Level
//        11. Group products by category using Collectors.groupingBy.
        class Product {
            String name;
            String category;
            double price;
            Product(String n, String c, double p) {
                name = n;
                category = c;
                price = p;
            }
        }

        List<Product> products = List.of(
                new Product("Pen", "Stationery", 10),
                new Product("Notebook", "Stationery", 50),
                new Product("Apple", "Grocery", 100)
        );

        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));

        System.out.println(grouped);

//        12. Find average price of all products.
        double avg = products.stream().mapToDouble(a->a.price).average().orElse(0);
        System.out.println(avg);

//        13. Partition a list of integers into even and odd.
        Map<Boolean, List<Integer>> result = nums.stream().collect(Collectors.partitioningBy(a->a%2==0));
        System.out.println(result);

//        14. Get top 3 highest scoring students using .sorted() and .limit().
        class Student1 {
            String name;
            int marks;
            Student1(String name, int marks){
                this.name=name;
                this.marks=marks;
            }
        }

        List<Student> students1 = List.of(
                new Student("A", 70),
                new Student("B", 90),
                new Student("C", 85),
                new Student("D", 95)
        );

        List<Student> top3 = students1.stream().sorted((a,b)->b.marks-a.marks).limit(3).toList();
        top3.forEach(s-> System.out.println(s.name));

//        15. From a map of name→score, find name with the highest score.
        Map<String, Integer> scores = Map.of("A", 90, "B", 85, "C", 92);
        String topScorer = scores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");

        System.out.println(topScorer);

//        Bonus: Real-World Mini Task
//        16. Given a list of books, extract titles of books published after 2015 and sort by price.

        class Book {
            String title;
            int year;
            double price;

            Book(String t, int y, double p) {
                title = t;
                year = y;
                price = p;
            }
        }

        List<Book> books = List.of(
                new Book("A", 2010, 100),
                new Book("B", 2016, 200),
                new Book("C", 2020, 150)
        );

        List<String> titles = books.stream()
                .filter(b -> b.year > 2015)
                .sorted(Comparator.comparingDouble(b -> b.price))
                .map(b -> b.title)
                .toList();

        System.out.println(titles);


//        17. From a sentence, find all unique words in alphabetical order.
        String sentence = "this is a stream api practice sentence for java stream";
        System.out.println(Arrays.stream(sentence.split(" ")).distinct().sorted().toList());
    }
}
