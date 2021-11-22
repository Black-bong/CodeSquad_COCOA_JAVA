package interfaceex;

public class CalcTest {
    public static void main(String[] args) {
        // calc의 타입으로 Calc(인터페이스)와 Calculator(추상클래스)로 선언할 수 있으나, 사용하는 메소드에 제한이 있다.
        CompleteCalc calc = new CompleteCalc();
        int a = 10;
        int b = 2;

        System.out.println(calc.add(a, b));
        System.out.println(calc.sub(a, b));
        System.out.println(calc.mul(a, b));
        System.out.println(calc.div(a, b));

        calc.showInfo();
    }
}
