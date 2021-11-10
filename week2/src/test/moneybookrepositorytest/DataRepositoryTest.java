package test.moneybookrepositorytest;

import moneybook.domain.MoneyBookData;
import moneybook.repository.DataRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class DataRepositoryTest {

    @Test
    @DisplayName("데이터 검색")
    void searchData () {
        DataRepository dataRepository = new DataRepository();
        MoneyBookData moneyBookData1 = new MoneyBookData("10월10일", "월급", BigDecimal.valueOf(1500000), BigDecimal.valueOf(0), "없음");
        dataRepository.dataSave(moneyBookData1);
        MoneyBookData moneyBookData2 = new MoneyBookData("11월10일", "용돈", BigDecimal.valueOf(0), BigDecimal.valueOf(20000), "현금");
        dataRepository.dataSave(moneyBookData2);
        MoneyBookData moneyBookData3 = new MoneyBookData("12월10일", "핸드폰요금", BigDecimal.valueOf(0), BigDecimal.valueOf(100000), "카드");
        dataRepository.dataSave(moneyBookData3);
        MoneyBookData moneyBookData4 = new MoneyBookData("01월10일", "월급", BigDecimal.valueOf(1500000), BigDecimal.valueOf(0), "없음");
        dataRepository.dataSave(moneyBookData4);
        MoneyBookData moneyBookData5 = new MoneyBookData("02월10일", "월급", BigDecimal.valueOf(1500000), BigDecimal.valueOf(0), "없음");
        dataRepository.dataSave(moneyBookData5);
        MoneyBookData moneyBookData6 = new MoneyBookData("03월10일", "핸드폰요금", BigDecimal.valueOf(0), BigDecimal.valueOf(50000), "카드");
        dataRepository.dataSave(moneyBookData6);
        MoneyBookData moneyBookData7 = new MoneyBookData("04월10일", "외식", BigDecimal.valueOf(0), BigDecimal.valueOf(70000), "현금");
        dataRepository.dataSave(moneyBookData7);
        MoneyBookData moneyBookData8 = new MoneyBookData("05월10일", "용돈", BigDecimal.valueOf(0), BigDecimal.valueOf(10000), "현금");
        dataRepository.dataSave(moneyBookData8);

        Assertions.assertEquals(dataRepository.findByBriefsData("월급").size(), 3);
    }

}