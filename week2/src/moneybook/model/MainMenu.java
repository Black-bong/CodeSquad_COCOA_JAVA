package moneybook.model;


import moneybook.singleton.BufferedReaderSingleton;
import moneybook.view.MoneyBook;
import moneybook.domain.Member;
import moneybook.repository.MemberRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MainMenu extends MoneyBook {

    MemberRepository memberRepository = MemberRepository.getInstance();
    BufferedReader bufferedReader = BufferedReaderSingleton.getInstance();

    public void createAccount() throws IOException {
        System.out.println("사용자 이름과 비밀번호를 띄어쓰기로 구분하여 입력하세요.");
        inputBar();

        StringTokenizer str = new StringTokenizer(bufferedReader.readLine(), " ");
        String username = str.nextToken();
        String password = str.nextToken();
        Member member = new Member(username, password);
        memberRepository.save(member);
        mainMenu();
    }

    public void login() throws IOException {
        if (memberRepository.memberIsValid()) {
            System.out.println("등록된 사용자가 없습니다, 사용자를 등록해주세요.");
            createAccount();
        }
        System.out.println("사용자 이름과 비밀번호를 띄어쓰기로 구분하여 입력하세요.");
        inputBar();
        StringTokenizer str = new StringTokenizer(bufferedReader.readLine(), " ");
        String username = str.nextToken();
        String password = str.nextToken();
        if (!memberRepository.isSameMember(username, password)) {
            System.out.println("등록되지 않은 사용자입니다.");
            login();
        }
        System.out.println("로그인 성공");
        subMenu();
    }

    public void exit() {
        showResult();
    }
}