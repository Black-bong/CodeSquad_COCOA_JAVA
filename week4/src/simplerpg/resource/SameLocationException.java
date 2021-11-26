package simplerpg.resource;

public class SameLocationException extends Exception {

    public SameLocationException() {
        super("동일한 위치에 객체가 생성되었습니다.");
    }
}