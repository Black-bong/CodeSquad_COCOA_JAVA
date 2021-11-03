package mission.indian;


import java.util.Scanner;

public class IndianNaming {
    public static void main(String[] args) {
        IndianNaming naming = new IndianNaming();
        naming.init();
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt() % 10;
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        scanner.close();
        printName(year, month, day);
    }

    public void printName(int y, int m, int d) {
        Name name = new Name(y, m, d);
        System.out.println(name.toString());
    }
}
