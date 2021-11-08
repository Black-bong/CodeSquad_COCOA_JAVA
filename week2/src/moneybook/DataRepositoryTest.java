package moneybook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class DataRepositoryTest {

    @BeforeEach
    void clearData() {
        DataRepository dataRepository = new DataRepository();
        dataRepository.clearData();
    }

    @Test
    @DisplayName("데이터 저장 확인")
    void saveData() {
        Data data = new Data(LocalDateTime.now(),"핸드폰요금",10000.0,0.0);
        DataRepository dataRepository = new DataRepository();
        dataRepository.dataSave(data);

        System.out.println(data.getDate());

        Assertions.assertEquals(data.getBriefs(),"핸드폰요금");
    }
}