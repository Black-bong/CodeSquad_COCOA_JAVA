package moneybook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(buf.readLine(), " ");

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        System.out.println("========가계부========");
        System.out.println("========Menu========");
        System.out.println("1. 사용자 등록");
        System.out.println("2. 기존 사용자 로그인");
        inputMemberData();
        createMember();
        selectMenu();
    }

    private static void selectMenu() {

    }

    private static void inputMemberData() throws IOException {
        System.out.println("사용자를 등록하세요.");



    }

    private static void createMember() {


    }
}
