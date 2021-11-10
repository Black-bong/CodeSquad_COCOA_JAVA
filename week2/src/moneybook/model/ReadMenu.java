package moneybook.model;

import moneybook.domain.MoneyBookData;

import java.io.IOException;
import java.util.List;

public class ReadMenu extends SubMenu {

    public void briefsSearch() throws IOException {
        System.out.println("조회할 적요을 입력하세요.");
        inputBar();
        String searchData = bufferedReader.readLine();
        dataPrint(dataRepository.findByBriefsData(searchData));
    }

    public void dateSearch() throws IOException {
        System.out.println("조회할 날짜를 입력하세요.");
        inputBar();
        String searchData = bufferedReader.readLine();
        dataPrint(dataRepository.findByMonthData(searchData));
    }

    public void priceSearch() throws IOException {
        System.out.println("조회할 금액을 입력하세요.");
        inputBar();
        String searchData = bufferedReader.readLine();
        dataPrint(dataRepository.findByPriceData(searchData));
    }

    public void earningsSearch() throws IOException {
        System.out.println("조회할 수입액을 입력하세요.");
        inputBar();
        String searchData = bufferedReader.readLine();
        dataPrint(dataRepository.findEarningsData(searchData));
    }

    public void expensesSearch() throws IOException {
        System.out.println("조회할 지출액을 입력하세요.");
        inputBar();
        String searchData = bufferedReader.readLine();
        dataPrint(dataRepository.findByExpensesData(searchData));
    }

    public void consumptionTypeSearch() throws IOException {
        System.out.println("조회할 소비유형을 입력하세요.");
        inputBar();
        String searchData = bufferedReader.readLine();
        dataPrint(dataRepository.findByConsumptionTypeData(searchData));
    }

    private void dataPrint(List<MoneyBookData> list) throws IOException {
        try {
            for (MoneyBookData data : list) {
                System.out.println(data);
            }
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        } finally {
            subMenu();
        }
    }
}