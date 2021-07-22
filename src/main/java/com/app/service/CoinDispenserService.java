package com.app.service;

import com.app.dto.CoinDispenserAuditDTO;
import com.app.model.Dispense;

import java.util.List;

public interface CoinDispenserService {

    List<String> dispenseCoins(Dispense dispense);

    List<CoinDispenserAuditDTO> dispenserAuditList();
}
