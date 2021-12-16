package testpreparation.step4;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class Number {

    public List<Integer> getNumber(int startNum, int endNum) {
        List<Integer> numbers = new Random()
                .ints(startNum, endNum)
                .distinct()
                .limit(3)
                .boxed()
                .collect(toList());

        numbers.forEach(System.out::println);
        return numbers;
    }
}