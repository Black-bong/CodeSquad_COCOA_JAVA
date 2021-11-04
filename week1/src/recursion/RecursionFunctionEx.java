package recursion;

public class RecursionFunctionEx {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("1부터 " + n + "까지의 합계: " + add(n));
    }

    private static int add(int n) {
        if (n == 0) {
            return 0;
        }
        return n += add(n - 1);
    }
}
