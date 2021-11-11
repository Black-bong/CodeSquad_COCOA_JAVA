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
    Input input = new Input();

    public void createAccount() throws IOException {
        System.out.println("사용자 이름과 비밀번호를 띄어쓰기로 구분하여 입력하세요.");
        inputBar();
        memberRepository.save(inputMemberInfo());
        mainMenu();
    }

    private Member inputMemberInfo() throws IOException {
        String username = input.inputString();
        String password = input.inputString();
        return new Member(username, password);
    }

    public void login() throws IOException {
        memberIsValid();
        System.out.println("사용자 이름과 비밀번호를 띄어쓰기로 구분하여 입력하세요.");
        inputBar();
        isSameMember();
        System.out.println("로그인 성공");
        subMenu();
    }

    private void memberIsValid() throws IOException {
        if (memberRepository.memberIsValid()) {
            System.out.println("등록된 사용자가 없습니다, 사용자를 등록해주세요.");
            createAccount();
        }
    }

    private void isSameMember() throws IOException {
        String username = input.inputString();
        String password = input.inputString();
        if (!memberRepository.isSameMember(username, password)) {
            System.out.println("등록되지 않은 사용자입니다.");
            login();
        }
    }

    public void exit() {
        showResult();
    }

}