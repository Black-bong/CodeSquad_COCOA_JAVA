package lambdaex;

import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaEx5 {
    public static void main(String[] args) {
        Function<String, Integer> f = Integer::parseInt;
        System.out.println(f.apply("100") + 200);

        Function<Integer, MyClass> fc = MyClass::new;
        System.out.println(fc.apply(100).iv);

        Supplier<MyClass> s = MyClass::new;
        MyClass mc = s.get();
        System.out.println(mc);

        Function<Integer, int[]> fcb = int[]::new;
        System.out.println(fcb.apply(100).length);
    }
}

class MyClass {
    int iv;

    MyClass(int iv) {
        this.iv = iv;
    }
    MyClass() {

    }
}
