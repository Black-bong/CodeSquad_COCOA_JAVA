package moneybook.repository;

import moneybook.domain.MoneyBookData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class DataRepository {

    private static final DataRepository instance = new DataRepository();
    private static final Map<Long, MoneyBookData> dataList = new HashMap<>();
    private static final Logger LOG = Logger.getGlobal();
    private static long sequence = 0L;
    protected static double saveBalance = 0.0;

    public void dataSave(MoneyBookData data) {
        data.setDataID(++sequence);
        saveBalance += data.getBalance();
        dataList.put(sequence, data);
    }

    // TODO 가계부 내역 수정 및 삭제 시 잔액변동 로직 구현
    public void dataUpdate(Long id, MoneyBookData data) {
//        saveBalance = findByIdData(id).getBalanceTempValue();

        dataList.put(id, data);
        findByIdData(id).setDataID(id);
//        for (long i = id; i <= dataList.size(); i++) {
//            if (findByIdData(i).getBalance() > 0) {
//                LOG.info("여기까지 오냐?+");
//                saveBalance -= findByIdData(i).getBalance();
//            }
//            if (findByIdData(i).getBalance() < 0) {
//                LOG.info("여기까지 오냐?-");
//                saveBalance += Math.abs(findByIdData(i).getBalance());
//            }
//            findByIdData(i).updateBalance(saveBalance+findByIdData(i).getBalance());
//            dataList.put(i, findByIdData(i));
//        }
    }

    public boolean isSameBalance(Double c) {
        return saveBalance == c;
    }

    public static DataRepository getInstance() {
        return instance;
    }

    public MoneyBookData findByIdData(Long id) {
        return dataList.get(id);
    }

    public List<MoneyBookData> findByMonthData(String m) {
        List<MoneyBookData> value = new ArrayList<>();
        for (MoneyBookData data : findAllData()) {
            if (!data.isSameDate(m)) {
                return null;
            }
            value.add(data);
        }
        return value;
    }

    public void removeData(Long id) {
        dataList.remove(id);
    }

    public List<MoneyBookData> findAllData() {
        return new ArrayList<>(dataList.values());
    }

    public void clearData() {
        dataList.clear();
    }
}