package mission.indian;


import java.util.Scanner;

public class IndianNaming {
    public static void main(String[] args) {
        IndianNaming naming = new IndianNaming();
        naming.init();
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("생년월일(1900 01 01)을 입력해 주세요>");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        scanner.close();

        Name name = new Name(year, month, day);
        System.out.println(name.toString());
    }
}
