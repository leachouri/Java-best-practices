import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class Java17LambdaBestPractices {

    public static void main(String[] args) {
        sortWithLambda();
        useOptionalWithLambda();
        filterAndMapWithStream();
        useLambdaWithFunctionalInterface();
        parallelProcessingWithStream();
        useDefaultAndStaticMethodsInInterfaces();
        useRecordsWithFunctionalProgramming();
        useVarForLocalVariables();
    }

    /**
     * Example 1: Sorting a List with Lambda Expressions
     * Demonstrates sorting a list of strings by their length using lambda expressions.
     */
    private static void sortWithLambda() {
        List<String> names = Arrays.asList("Mohamed", "John", "Anna", "Mike");

        // Sort the list by the length of the strings
        names.sort(Comparator.comparingInt(String::length));

        System.out.println("Sorted names by length: " + names);
    }

    /**
     * Example 2: Using Optional with Lambdas
     * Demonstrates how to handle Optional values with lambdas for null safety.
     */
    private static void useOptionalWithLambda() {
        Optional<String> optional = Optional.of("Java");

        // Use ifPresent to print the value if it exists
        optional.ifPresent(value -> System.out.println("Optional value: " + value));

        // Use orElseGet to provide a default value
        String defaultValue = optional.orElseGet(() -> "Default Value");
        System.out.println("Optional orElseGet value: " + defaultValue);
    }

    /**
     * Example 3: Filtering and Mapping with Streams
     * Demonstrates using Stream API to filter and map collections with lambda expressions.
     */
    private static void filterAndMapWithStream() {
        List<String> names = Arrays.asList("Mohamed", "John", "Anna", "Mike");

        // Filter names starting with 'J' and convert to uppercase
        List<String> result = names.stream()
                                   .filter(name -> name.startsWith("J"))
                                   .map(String::toUpperCase)
                                   .collect(Collectors.toList());

        System.out.println("Filtered and mapped names: " + result);
    }

    /**
     * Example 4: Using Lambdas with Functional Interfaces
     * Demonstrates using custom functional interfaces with lambda expressions.
     */
    private static void useLambdaWithFunctionalInterface() {
        // Custom functional interface to get the length of a string
        Function<String, Integer> stringLength = str -> str.length();

        // Apply the lambda to get the length of "Lambda"
        int length = stringLength.apply("Lambda");
        System.out.println("Length of 'Lambda': " + length);
    }

    /**
     * Example 5: Parallel Processing with Streams
     * Demonstrates using parallel streams for concurrent processing with lambdas.
     */
    private static void parallelProcessingWithStream() {
        List<String> names = Arrays.asList("Mohamed", "Ahmed", "Anna", "Mike");

        // Convert names to uppercase using parallel stream
        names.parallelStream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }

    /**
     * Example 6: Default and Static Methods in Interfaces
     * Demonstrates using default and static methods in interfaces.
     */
    private static void useDefaultAndStaticMethodsInInterfaces() {
        MyInterface example = new MyClass();

        // Call default method from the interface
        example.defaultMethod();

        // Call static method from the interface
        MyInterface.staticMethod();
    }

    /**
     * Example 7: Using Record Classes with Functional Programming
     * Demonstrates using record classes introduced in Java 16 for immutable data representation.
     */
    private static void useRecordsWithFunctionalProgramming() {
        List<Person> people = List.of(
            new Person("Mohamed", 30),
            new Person("Ahmed", 25),
            new Person("Fatima", 35)
        );

        // Find the oldest person using stream max
        people.stream()
              .max(Comparator.comparingInt(Person::age))
              .ifPresent(person -> System.out.println("Oldest person: " + person.name()));
    }

    /**
     * Example 8: Using var for Local Variables
     * Demonstrates using var for type inference for local variables.
     */
    private static void useVarForLocalVariables() {
        // Type of 'numbers' is inferred by the compiler
        var numbers = List.of(1, 2, 3, 4, 5);

        // Calculate the sum of numbers
        int sum = numbers.stream()
                         .mapToInt(Integer::intValue)
                         .sum();

        System.out.println("Sum of numbers: " + sum);
    }
}

// Interface with default and static methods
interface MyInterface {
    // Default method in the interface
    default void defaultMethod() {
        System.out.println("Default Method in Interface");
    }

    // Static method in the interface
    static void staticMethod() {
        System.out.println("Static Method in Interface");
    }
}

// Class implementing the interface
class MyClass implements MyInterface {
    // Inherits default method from MyInterface
}
