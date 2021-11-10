package moneybook.model;

import moneybook.domain.MoneyBookData;
import moneybook.repository.DataRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class SubMenu extends MainMenu {

    DataRepository dataRepository = DataRepository.getInstance();
    private static final Logger LOG = Logger.getGlobal();


    public void createData() throws IOException {
        System.out.println("날짜, 적요, 수입, 지출, 소비유형을 띄어쓰기로 구분하여 입력하시오.(입력종료:완료)");
        String date;
        inputBar();
        StringTokenizer str = new StringTokenizer(bufferedReader.readLine(), " ");

        try {
            date = str.nextToken();
            if (date.equals("완료")) subMenu();

            String briefs = str.nextToken();
            BigDecimal income = BigDecimal.valueOf(Long.parseLong(str.nextToken()));
            BigDecimal expenses = BigDecimal.valueOf(Long.parseLong(str.nextToken()));
            String consumptionType = str.nextToken();

            MoneyBookData data = new MoneyBookData(date, briefs, income, expenses, consumptionType);
            dataRepository.dataSave(data);
            createData();

        } catch (NoSuchElementException e) {
            System.out.println("입력값 오류 다시 입력해주세요.");
            LOG.info(e.toString());
            createData();
        }
    }

    public void readData() throws IOException {
        searchMenu();
    }

    public void updateData() throws IOException {
        System.out.println("수정할 데이터의 번호를 입력하시오.");
        inputBar();
        Long id = Long.parseLong(bufferedReader.readLine());

        System.out.println("날짜, 적요, 수입, 지출, 소비유형을 띄어쓰기로 구분하여 입력하시오.");
        inputBar();
        StringTokenizer str = new StringTokenizer(bufferedReader.readLine(), " ");

        String date = str.nextToken();
        String briefs = str.nextToken();
        BigDecimal income = BigDecimal.valueOf(Long.parseLong(str.nextToken()));
        BigDecimal expenses = BigDecimal.valueOf(Long.parseLong(str.nextToken()));
        String consumptionType = str.nextToken();

        MoneyBookData data = new MoneyBookData(date, briefs, income, expenses, consumptionType);
        dataRepository.dataUpdate(id, data);

        subMenu();
    }

    public void dataDelete() throws IOException {
        System.out.println("삭제할 데이터의 번호를 입력하시오.");
        inputBar();
        Long id = Long.parseLong(bufferedReader.readLine());
        dataRepository.removeData(id);
        subMenu();
    }

    public void goToMainMenu() throws IOException {
        mainMenu();
    }
}