package abstractex;

abstract class Player { // 추상클래스
    abstract void play(int pos); // 추상메소드
    abstract void stop();
}

class AudioPlayer extends Player {
    @Override
    void play(int pos) {
        System.out.println(pos + "위치부터 play합니다.");
    }

    @Override
    void stop() {
        System.out.println("재생을 멈춥니다.");
    }
}

public class PlayerTest {

    public static void main(String[] args) {
        AudioPlayer ap = new AudioPlayer();
        ap.play(100);
        ap.stop();
    }
}
