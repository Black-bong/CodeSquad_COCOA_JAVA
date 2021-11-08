package moneybook;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Data {
    private Long dataID;
    private LocalDateTime date;
    private String briefs;
    private Double income;
    private Double expenses;

    public Data(LocalDateTime date, String briefs, Double income, Double expenses) {
        this.date = date;
        this.briefs = briefs;
        this.income = income;
        this.expenses = expenses;
    }

    public Long getDataID() {
        return dataID;
    }

    public void setDataID(Long dataID) {
        this.dataID = dataID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
}
