package moneybook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    DataRepository dataRepository = DataRepository.getInstance();
    MemberRepository memberRepository = MemberRepository.getInstance();

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        System.out.println("========가계부========");
        main.selectMenu();
    }

    private void selectMenu() throws IOException {
        System.out.println("========Menu========");
        System.out.println("1. 사용자 등록");
        System.out.println("2. 로그인");
        System.out.println("3. 종료");
        System.out.print(">> ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int selectNumber = Integer.parseInt(buf.readLine());
        switch (selectNumber) {
            case 1:
                memberData();
                break;
            case 2:
                dataMenu();
                break;
            case 3:
        }
    }

    private void dataMenu() throws IOException {
        if (!memberRepository.isFlag()) {
            System.out.println("사용자를 등록해주세요.");
            selectMenu();
        }
        System.out.println("========Menu========");
        System.out.println("1. 데이터 등록");
        System.out.println("2. 데이터 확인");
        System.out.println("3. 데이터 수정");
        System.out.println("4. 데이터 삭제");
        System.out.println("5. 메인 메뉴");
        System.out.print(">> ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int selectNumber = Integer.parseInt(buf.readLine());
        switch (selectNumber) {
            case 1:
                createData();
                break;
            case 2:
                readData();
                break;
            case 3:
                updateData();
                break;
            case 4:
                break;
            case 5:
                dataDelete();
                break;
        }
    }

    private void createData() throws IOException {

        System.out.println("날짜, 적요, 수입, 지출을 띄어쓰기로 구분하여 입력하시오.");
        System.out.print(">> ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(buf.readLine(), " ");

        String date = str.nextToken();
        String briefs = str.nextToken();
        double income = Double.parseDouble(str.nextToken());
        double expenses = Double.parseDouble(str.nextToken());

        Data data = new Data(date, briefs, income, expenses);

        dataRepository.dataSave(data);
        dataMenu();
    }

    private void readData() throws IOException {
        System.out.println("조회 할 월을 입력하세요.");
        System.out.print(">> ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String date = buf.readLine();
        List<Data> data = dataRepository.findAllData();

        for (Data d : data) {
            if (d.getDate().substring(0, 2).equals(date)) {
                System.out.println(d.toString());
            }
        }
        dataMenu();
    }

    private void updateData() throws IOException {
        System.out.println("수정할 데이터의 번호를 입력하시오.");
        System.out.print(">> ");

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        Long id = Long.parseLong(buf.readLine());
        dataRepository.findByIdData(id);
        dataMenu();
    }

    private void dataDelete() throws IOException {
        System.out.println("삭제할 데이터의 번호를 입력하시오.");
        System.out.print(">> ");

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        Long id = Long.parseLong(buf.readLine());
        dataRepository.removeData(id);
        dataMenu();
    }

    private void memberData() throws IOException {
        System.out.println("사용자 이름과 비밀번호를 입력하세요.");
        System.out.print(">> ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(buf.readLine(), " ");
        String username = str.nextToken();
        String password = str.nextToken();

        createMember(username, password);
    }

    private void createMember(String u, String p) throws IOException {
        Member member = new Member(u, p);
        memberRepository.save(member);
        selectMenu();
    }
}
