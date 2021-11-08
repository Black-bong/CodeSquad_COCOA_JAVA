package moneybook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRepository {
    private static Map<Long, Data> dataList = new HashMap<>();
    private static long sequence = 0L;

    public Data dataSave(Data data) {
        data.setDataID(++sequence);
        dataList.put(sequence, data);
        return data;
    }

    public Data FindByIdData(Long id) {
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
