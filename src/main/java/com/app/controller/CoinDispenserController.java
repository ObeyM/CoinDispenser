package com.app.controller;

import com.app.dto.CoinDispenserAuditDTO;
import com.app.model.Dispense;
import com.app.service.CoinDispenserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/application")
@RestController
public class CoinDispenserController {

    @Autowired
    private CoinDispenserService coinDispenserService;

    @RequestMapping(value = "/coin-dispenser", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<String> dispenseCoins(@RequestBody Dispense dispense) {

        return coinDispenserService.dispenseCoins(dispense);
    }

    @RequestMapping(value = "/dispenser-audit")
    public List<CoinDispenserAuditDTO> dispenserAuditList() {

        return coinDispenserService.dispenserAuditList();
    }
}