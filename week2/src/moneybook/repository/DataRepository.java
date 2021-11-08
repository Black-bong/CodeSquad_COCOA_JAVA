package moneybook.repository;

import moneybook.domain.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRepository {

    private static final DataRepository instance = new DataRepository();
    private static final Map<Long, Data> dataList = new HashMap<>();
    private static long sequence = 0L;
    private static double cash = 0.0;

    public void dataSave(Data data) {
        data.setDataID(++sequence);
        cash += (data.getIncome() - data.getExpenses());
        data.setCash(cash);
        dataList.put(sequence, data);
    }

    public static DataRepository getInstance() {
        return instance;
    }

    public Data findByIdData(Long id) {
        return dataList.get(id);
    }

    public void removeData(Long id) {
        dataList.remove(id);
    }

    public List<Data> findAllData() {
        return new ArrayList<>(dataList.values());
    }

    public void clearData() {
        dataList.clear();
    }
}