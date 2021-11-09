package moneybook.domain;

public class MoneyBookData {
    private Long dataID;
    private String date;
    private String briefs;
    private Double income;
    private Double expenses;
    private Double cash = 0.0;

    public MoneyBookData(String date, String briefs, Double income, Double expenses) {
        this.date = date;
        this.briefs = briefs;
        this.income = income;
        this.expenses = expenses;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Long getDataID() {
        return dataID;
    }

    public void setDataID(Long dataID) {
        this.dataID = dataID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBriefs() {
        return briefs;
    }

    public void setBriefs(String briefs) {
        this.briefs = briefs;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return getDataID() + " "
                + "날짜:" + getDate() + " "
                + "적요:" + getBriefs() + " "
                + "수입:" + getIncome() + "원 "
                + "지출:" + getExpenses() + "원 "
                + "잔액:" + getCash() + "원";
    }
}
