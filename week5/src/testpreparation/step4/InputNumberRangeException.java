package testpreparation.step4;

public class InputNumberRangeException extends Exception {

    public InputNumberRangeException(int range) {
        super(range + "자리 숫자를 입력해주세요.");
    }
}