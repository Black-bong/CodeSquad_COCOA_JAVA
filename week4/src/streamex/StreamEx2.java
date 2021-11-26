package streamex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();
        intStream.forEach(System.out::println);

        String[] strArr = {"a", "b", "c", "d"};
        Stream<String> strStream = Arrays.stream(strArr);
        strStream.forEach(System.out::println);

        int[] intArr = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(intArr);
//        stream.forEach(System.out::println);
        System.out.println(stream.average());

        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
        strings.add("E");
        strings.forEach(System.out::println);

        IntStream intRandomStream = new Random().ints(1, 6);
        intRandomStream.distinct().limit(5).forEach(System.out::println);

        Stream<Integer> iterateStream = Stream.iterate(1, n -> n + 1);
        iterateStream.limit(10).forEach(System.out::println);
    }
}
