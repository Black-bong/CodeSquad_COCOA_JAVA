package testpreparation.step4;

public class InputNumberDuplicateException extends Exception {

    public InputNumberDuplicateException() {
        super("중복된 값이 있습니다.");
    }
}