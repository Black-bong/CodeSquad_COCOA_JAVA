package lambdaex;

import java.util.logging.Logger;

public class LambdaEx1 {

    private static final Logger LOG = Logger.getGlobal();

    public static void main(String[] args) {
//        MyFunction mf = new MyFunction() {
//            public int max(int a, int b) {
//                return a > b ? a : b;
//            }
//        };
//        MyFunction mf = getMyFunction();
//        int value = mf.max(3, 5);
        int value = getMyFunction().max(3, 5);
        LOG.info(value + "");
    }

    static MyFunction getMyFunction() {
        return Math::max;
    }
}

@FunctionalInterface // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야 함
interface MyFunction {
    int max(int a, int b);
}