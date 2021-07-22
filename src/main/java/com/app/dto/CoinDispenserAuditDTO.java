package com.app.dto;

import java.util.Date;

public class CoinDispenserAuditDTO {

    private long recordId;
    private int amount;
    private String dispensedCoins;
    private String dispenseDate;

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDispensedCoins() {
        return dispensedCoins;
    }

    public void setDispensedCoins(String dispensedCoins) {
        this.dispensedCoins = dispensedCoins;
    }

    public String getDispenseDate() {
        return dispenseDate;
    }

    public void setDispenseDate(String dateRegistered) {
        this.dispenseDate = dateRegistered;
    }
}
