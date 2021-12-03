package testpreparation.step4;

import java.util.ArrayList;
import java.util.List;

public class Number {

    public List<Integer> getNumber(List<Integer> numberList, int numberCount) {
        List<Integer> temp = shuffleNumberList(numberList);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numberCount; i++) {
            numbers.add(temp.get(i));
        }
        return numbers;
    }

    private List<Integer> shuffleNumberList(List<Integer> numberList) {
        for (int i = 0; i < numberList.size(); i++) {
            int randomIndex = (int) (Math.random() * numberList.size());
            int temp = numberList.get(randomIndex);
            numberList.set(randomIndex, numberList.get(i));
            numberList.set(i, temp);
        }
        return numberList;
    }
}