package moneybook.domain;

import moneybook.repository.DataRepository;

import java.math.BigDecimal;

public class MoneyBookData extends DataRepository {
    private Long dataID;
    private final String date;
    private final String briefs;
    private final String consumptionType;
    private final BigDecimal earnings;
    private final BigDecimal expenses;
    private BigDecimal balanceTempValue;
    private final BigDecimal balance;

    public MoneyBookData(String date, String briefs, BigDecimal earnings, BigDecimal expenses, String consumptionType) {
        this.date = date;
        this.briefs = briefs;
        this.earnings = earnings;
        this.expenses = expenses;
        this.balance = earnings.subtract(expenses);
        this.consumptionType = consumptionType;
        this.balanceTempValue = balance.add(saveBalance);
    }

    public void setDataID(Long dataID) {
        this.dataID = dataID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getBalanceTempValue() {
        return balanceTempValue;
    }

    public boolean isSameDate(String d) {
        return this.date.substring(0, 3).equals(d);
    }
    public boolean isSameBriefs(String b) {
        return this.briefs.equals(b);
    }
    public boolean isSameEarnings(String ea) {
        return this.earnings.equals(ea);
    }
    public boolean isSameExpenses(String ex) {
        return this.expenses.equals(ex);
    }
    public boolean isSameConsumptionType(String c) {
        return this.consumptionType.equals(c);
    }
    public boolean isSameBalance(String bl) {
        return this.balance.equals(bl);
    }

    public void updateBalance(BigDecimal n) {
        this.balanceTempValue = n;
    }

    @Override
    public String toString() {
        return this.dataID + " "
                + "날짜:" + this.date + " "
                + "적요:" + this.briefs + " "
                + "수입:" + this.earnings + "원 "
                + "지출:" + this.expenses + "원 "
                + "잔액:" + this.balanceTempValue + "원 "
                + "소비유형:" + this.consumptionType;
    }
}