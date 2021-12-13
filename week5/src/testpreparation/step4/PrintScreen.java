package testpreparation.step4;

public class PrintScreen {
    public void inputBar() {
        System.out.print("숫자를 입력해주세요 ex)123 :");
    }

    public void reInputScreen() {
        System.out.println("잘못 입력하셨습니다. 숫자를 입력해주세요.");
    }

    public void gameOverScreen() {
        System.out.println("기회를 모두 사용했습니다! 실패");
    }

    public void strike(int strike) {
        if (strike != 0) {
            System.out.print(strike + "스트라이크!");
        }
    }

    public void ball(int ball) {
        if (ball != 0) {
            System.out.print(ball + "볼!");
        }
    }

    public void notingScreen() {
        System.out.println("낫싱!");
    }

    public void winGameScreen(int numberCount) {
        System.out.println(numberCount + "개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.exit(0);
    }
}