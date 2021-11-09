package moneybook.model;

import moneybook.domain.MoneyBookData;
import moneybook.repository.DataRepository;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class SubMenu extends MainMenu {

    DataRepository dataRepository = DataRepository.getInstance();
    private static final Logger LOG = Logger.getGlobal();

    public void createData() throws IOException {
        System.out.println("날짜, 적요, 수입, 지출을 띄어쓰기로 구분하여 입력하시오.(종료:exit)");
        String date;
        System.out.print(">> ");
        StringTokenizer str = new StringTokenizer(bufferedReader.readLine(), " ");

        try {
            date = str.nextToken();
            if (date.equals("exit")) subMenu();

            String briefs = str.nextToken();
            double income = Double.parseDouble(str.nextToken());
            double expenses = Double.parseDouble(str.nextToken());

            MoneyBookData data = new MoneyBookData(date, briefs, income, expenses);
            dataRepository.dataSave(data);
            createData();

        } catch (NoSuchElementException e) {
            System.out.println("입력값 오류 다시 입력해주세요.");
            LOG.info(e.toString());
            createData();
        }
    }

    public void readData() throws IOException {
        System.out.println("조회 할 월을 입력하세요.");
        System.out.print(">> ");
        String date = bufferedReader.readLine();

        List<MoneyBookData> data = dataRepository.findAllData();

        for (MoneyBookData d : data) {
            if (d.getDate().substring(0, 3).equals(date)) {
                System.out.println(d.toString());
            }
        }
        subMenu();
    }

    public void updateData() throws IOException {
        System.out.println("수정할 데이터의 번호를 입력하시오.");
        System.out.print(">> ");
        Long id = Long.parseLong(bufferedReader.readLine());
        MoneyBookData data = dataRepository.findByIdData(id);

        System.out.println("날짜, 적요, 수입, 지출을 띄어쓰기로 구분하여 입력하시오.");
        System.out.print(">> ");
        StringTokenizer str = new StringTokenizer(bufferedReader.readLine(), " ");

        data.setDate(str.nextToken());
        data.setBriefs(str.nextToken());
        data.setIncome(Double.parseDouble(str.nextToken()));
        data.setExpenses(Double.parseDouble(str.nextToken()));
        subMenu();
    }

    public void dataDelete() throws IOException {
        System.out.println("삭제할 데이터의 번호를 입력하시오.");
        System.out.print(">> ");
        Long id = Long.parseLong(bufferedReader.readLine());
        dataRepository.removeData(id);
        subMenu();
    }

    public void goToMainMenu() throws IOException {
        mainMenu();
    }
}