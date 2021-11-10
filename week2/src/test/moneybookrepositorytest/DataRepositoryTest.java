package test.moneybookrepositorytest;

import moneybook.domain.MoneyBookData;
import moneybook.repository.DataRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataRepositoryTest {

    DataRepository dataRepository = DataRepository.getInstance();

    @BeforeEach
    void clearData() {
        dataRepository.clearData();
    }

    @Test
    @DisplayName("데이터 저장 확인")
    void saveData() {
        MoneyBookData data = new MoneyBookData("11월02일", "핸드폰요금", 10000.0, 0.0);
        dataRepository.dataSave(data);

    }

    @Test
    @DisplayName("잔액 호출")
    void callCash() {
        MoneyBookData data1 = new MoneyBookData("11월01일", "월급", 1000000.0, 0.0);
        dataRepository.dataSave(data1);
        MoneyBookData data2 = new MoneyBookData("11월02일", "핸드폰요금", 0.0, 100000.0);
        dataRepository.dataSave(data2);
        MoneyBookData data3 = new MoneyBookData("11월03일", "보너스", 120000.0, 0.0);
        dataRepository.dataSave(data3);

        Assertions.assertSame(dataRepository.isSameBalance(1020000.0), true);
    }

    @Test
    @DisplayName("데이터 삭제 확인")
    void deleteData() {
        MoneyBookData data = new MoneyBookData("11월01일", "월급", 1000000.0, 0.0);
        dataRepository.dataSave(data);
        dataRepository.removeData(1L);
        Assertions.assertNull(dataRepository.findByIdData(1L));
    }

    @Test
    @DisplayName("데이터 수정 확인")
    void updateData() {
        MoneyBookData data1 = new MoneyBookData("11월01일", "월급", 1000000.0, 0.0);
        dataRepository.dataSave(data1);
        MoneyBookData data2 = new MoneyBookData("11월01일", "핸드폰요금", 0.0, 150000.0);
        dataRepository.dataSave(data2);
        MoneyBookData data3 = new MoneyBookData("11월01일", "외식", 0.0, 50000.0);
        dataRepository.dataSave(data3);
        System.out.println(dataRepository.findByMonthData("11월"));
        MoneyBookData updateData = new MoneyBookData("11월01일", "핸드폰", 0.0, 200000.0);
        dataRepository.dataUpdate(2L, updateData);

        System.out.println(dataRepository.findByMonthData("11월"));
    }
}