package etc;

public class CountDown {
    public static void main(String[] args) {
        CountDown cd = new CountDown();
        int a = 10;
        cd.countDawn(a);
    }
    public int countDawn(int s) {
        if (s < 1) {
            return 0;
        }
        System.out.println(s);
        return countDawn(s - 1);
    }
}