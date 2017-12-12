package com.lse.spring.example.jta;

import org.joda.time.DateTime;

public class Audit {
    private String id;
    private String action;
    private String accountNumber;
    private Double amount;
    private DateTime eventTime;

    @Override
    public String toString() {
        return "Audit [id=" + id + ", action=" + action + ", accountNumber=" + accountNumber
                + ", amount=" + amount + ", eventTime=" + eventTime + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public DateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(DateTime eventTime) {
        this.eventTime = eventTime;
    }
}
