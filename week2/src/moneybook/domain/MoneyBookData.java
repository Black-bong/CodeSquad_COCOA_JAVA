package moneybook.domain;

import moneybook.repository.DataRepository;

public class MoneyBookData extends DataRepository {
    private Long dataID;
    private final String date;
    private final String briefs;
    private final double earnings;
    private final double expenses;
    private double balanceTempValue;
    private final double balance;

    public MoneyBookData(String date, String briefs, double earnings, double expenses) {
        this.date = date;
        this.briefs = briefs;
        this.earnings = earnings;
        this.expenses = expenses;
        this.balance = earnings - expenses;
        this.balanceTempValue = balance + saveBalance;
    }

    public void setDataID(Long dataID) {
        this.dataID = dataID;
    }

    public double getBalance() {
        return balance;
    }

    public double getBalanceTempValue() {
        return balanceTempValue;
    }

    public boolean isSameDate(String date) {
        return this.date.substring(0, 3).equals(date);
    }

    public void updateBalance(double n) {
        this.balanceTempValue = n;
    }

    @Override
    public String toString() {
        return this.dataID + " "
                + "날짜:" + this.date + " "
                + "적요:" + this.briefs + " "
                + "수입:" + this.earnings + "원 "
                + "지출:" + this.expenses + "원 "
                + "잔액:" + this.balanceTempValue + "원";
    }
}