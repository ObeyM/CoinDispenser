package com.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CoinDispenserAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    @Id
    @Basic(optional = false)
    @NotNull
    private long recordId;
    @Column
    private int amount;
    @Column
    private String dispensedCoins;
    @Column
    private String dispenseDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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