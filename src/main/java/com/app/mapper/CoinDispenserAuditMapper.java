package com.app.mapper;

import com.app.dto.CoinDispenserAuditDTO;
import com.app.entity.CoinDispenserAudit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CoinDispenserAuditMapper {

    public static CoinDispenserAudit dtoToEntity(CoinDispenserAuditDTO coinDispenserAuditDTO){

        CoinDispenserAudit coinDispenserAudit = new CoinDispenserAudit();
        coinDispenserAudit.setRecordId(System.currentTimeMillis());
        coinDispenserAudit.setAmount(coinDispenserAuditDTO.getAmount());
        coinDispenserAudit.setDispensedCoins(coinDispenserAuditDTO.getDispensedCoins());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        coinDispenserAudit.setDispenseDate(dateFormat.format(date));

        return coinDispenserAudit;
    }

    public static CoinDispenserAuditDTO entityToDto(CoinDispenserAudit coinDispenserAudit){

        CoinDispenserAuditDTO coinDispenserAuditDTO = new CoinDispenserAuditDTO();
        coinDispenserAuditDTO.setRecordId(coinDispenserAudit.getRecordId());
        coinDispenserAuditDTO.setAmount(coinDispenserAudit.getAmount());
        coinDispenserAuditDTO.setDispensedCoins(coinDispenserAudit.getDispensedCoins());
        coinDispenserAuditDTO.setDispenseDate(coinDispenserAudit.getDispenseDate());

        return coinDispenserAuditDTO;
    }
}
