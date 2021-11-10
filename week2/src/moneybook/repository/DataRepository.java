package moneybook.repository;

import moneybook.domain.MoneyBookData;

import java.math.BigDecimal;
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
    protected static BigDecimal saveBalance = BigDecimal.ZERO;

    public void dataSave(MoneyBookData data) {
        data.setDataID(++sequence);
        saveBalance = saveBalance.add(data.getBalance());
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
                continue;
            }
            value.add(data);
        }
        return value;
    }

    public List<MoneyBookData> findByPriceData(String m) {
        List<MoneyBookData> value = new ArrayList<>();
        for (MoneyBookData data : findAllData()) {
            if (!data.isSameBalance(m)) {
                continue;
            }
            value.add(data);
        }
        return value;
    }

    public List<MoneyBookData> findByBriefsData(String m) {
        List<MoneyBookData> value = new ArrayList<>();
        for (MoneyBookData data : findAllData()) {
            if (!data.isSameBriefs(m)) {
                continue;
            }
            value.add(data);
        }
        return value;
    }

    public List<MoneyBookData> findEarningsData(String m) {
        List<MoneyBookData> value = new ArrayList<>();
        for (MoneyBookData data : findAllData()) {
            if (!data.isSameEarnings(m)) {
                continue;
            }
            value.add(data);
        }
        return value;
    }

    public List<MoneyBookData> findByExpensesData(String m) {
        List<MoneyBookData> value = new ArrayList<>();
        for (MoneyBookData data : findAllData()) {
            if (!data.isSameExpenses(m)) {
                continue;
            }
            value.add(data);
        }
        return value;
    }

    public List<MoneyBookData> findByConsumptionTypeData(String m) {
        List<MoneyBookData> value = new ArrayList<>();
        for (MoneyBookData data : findAllData()) {
            if (!data.isSameConsumptionType(m)) {
                continue;
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