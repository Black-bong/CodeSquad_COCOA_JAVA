package moneybook.test;

import moneybook.domain.Data;
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
        Data data = new Data("11월02일","핸드폰요금",10000.0,0.0);
        dataRepository.dataSave(data);

        Assertions.assertEquals(data.getBriefs(),"핸드폰요금");
    }

    @Test
    @DisplayName("잔액 호출")
    void callCash() {
        Data data1 = new Data("11월01일", "월급", 1000000.0, 0.0);
        dataRepository.dataSave(data1);
        Data data2 = new Data("11월02일", "핸드폰요금", 0.0, 100000.0);
        dataRepository.dataSave(data2);
        Data data3 = new Data("11월03일", "보너스", 120000.0, 0.0);
        dataRepository.dataSave(data3);

        Assertions.assertEquals(data3.getCash(), 1020000.0);
    }

    @Test
    @DisplayName("데이터 삭제 확인")
    void deleteData() {
        Data data = new Data("11월01일", "월급", 1000000.0, 0.0);
        dataRepository.dataSave(data);
        dataRepository.removeData(1L);
        Assertions.assertNull(dataRepository.findByIdData(1L));
    }
}