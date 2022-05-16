package core.java.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerStream {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 0, 1, 13};

        /*
        A stream basically involves 3 process
        1. Creation of stream
        2. Processing the stream
        3. Consumption of stream
         */
        IntStream.of(nums) //creation of stream
                .distinct() //process - 1
                .sorted() // process - 2
                .limit(3) // process - 3
                .forEach(System.out::println); //consumption of stream


        System.out.println("-----------------------------------------------------------------");

        /* Create a stream */
        IntStream.of(nums).forEach(System.out::println); //Stream of numbers
        IntStream.range(0, 10).forEach(System.out::println); //Stream of range of numbers, [1-100)
        IntStream.rangeClosed(0, 10).forEach(System.out::println); //Stream of numbers,  [1-100]
        //IntStream.generate(supplier()); //Stream of numbers from a supplier

        System.out.println("-----------------------------------------------------------------");


        /* Process the stream */

        IntStream.of(nums).distinct().forEach(System.out::println); //Print distinct from array
        IntStream.of(nums).sorted().forEach(System.out::println); // Sort the array ascending
        IntStream.of(nums).limit(3).forEach(System.out::println); // first 3 elements
        IntStream.of(nums).skip(3).forEach(System.out::println); // skip first 3 elements
        IntStream.of(nums).filter(num -> num % 2 == 0).forEach(System.out::println); // filter on even
        IntStream.of(nums).map(num -> num * 2).forEach(System.out::println); //  multiply all numbers by 2
        IntStream.of(nums).boxed().forEach(System.out::println); //convert each number to integer

        System.out.println("-----------------------------------------------------------------");

        /*Consume the stream */

        IntStream.of(nums).average(); // get average
        IntStream.of(nums).max(); // get max
        IntStream.of(nums).min(); // get min
        IntStream.of(nums).sum(); // find the sum of values
        IntStream.of(nums).count(); //Count the number of element in an array

        IntStream.range(1, 10).forEach(System.out::println); // Print the range
        IntStream.range(1, 10).toArray(); // Convert to array
        IntStream.range(1, 10).boxed().collect(Collectors.toList()); //convert to List<Integer>
        IntStream.range(1, 10).anyMatch(num -> num % 2 == 0); // is any number even
        IntStream.range(1, 10).allMatch(num -> num % 2 == 0); // are all numbers even


        System.out.println("-----------------------------------------------------------------");

        /* Example 1 -  Print top 3 distinct smallest numbers in array */
        IntStream.of(nums).distinct().sorted().limit(3).forEach(val -> System.out.println(val));
        /*------------------------OR-------------------------------------*/
        IntStream.of(nums).distinct().sorted().limit(3).forEach(System.out::println);


    }
}
