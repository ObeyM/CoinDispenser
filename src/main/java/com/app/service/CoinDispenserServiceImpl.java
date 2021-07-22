package com.app.service;

import com.app.dto.CoinDispenserAuditDTO;
import com.app.entity.CoinDispenserAudit;
import com.app.mapper.CoinDispenserAuditMapper;
import com.app.model.Coin;
import com.app.model.Dispense;
import com.app.repository.CoinDispenserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinDispenserServiceImpl implements CoinDispenserService {

    private List<String> coins;

    @Autowired
    private CoinDispenserRepository coinDispenserRepository;

    /**
     * This function returns denominations of coins as per number of denominations available
     * @param denomination
     * @return V1,V2,V3....Vx
     */
    public List<Coin> getCoinDenominations(int denomination) {

        List<Coin> coinList = new LinkedList<>();
        int currentOddNumber = 1;
        int value = 1;
        coinList.add(new Coin("V1", value));
        for (int i = 2; i <= denomination; i++) {

            value = value + currentOddNumber;
            coinList.add(new Coin("V" + i, value));
            currentOddNumber += 2;
        }
        return coinList;
    }

    /**
     * A recursive function that converts parsed amount to coins
     * @param amount
     * @param coinList
     * @return
     */
    private List<String> getCoinConverterAlgorithm(int amount, List<Coin> coinList) {

        int index = coinList.size() - 1;
        int total = amount / coinList.get(index).getValue();
        int remainder = amount % coinList.get(index).getValue();

        if (total >= 1) {
            for (int j = 0; j < total; j++) {
                coins.add(coinList.get(index).getKey());
            }
        }

        if (remainder != 0) {
            coinList.remove(index);
            coins = getCoinConverterAlgorithm(remainder, coinList);
        }

        return coins;
    }

    /**
     * coin dispenser function which returns coins, then persist an audit record
     * @param dispense
     * @return
     */
    @Override
    public List<String> dispenseCoins(Dispense dispense) {
        coins = new LinkedList<>();
        List<String> dispensedCoins = getCoinConverterAlgorithm(dispense.getAmount(), getCoinDenominations(dispense.getCoinDenominations()));

        CoinDispenserAuditDTO coinDispenserAuditDTO;
        if (dispensedCoins.size() > 0) {

            coinDispenserAuditDTO = new CoinDispenserAuditDTO();
            coinDispenserAuditDTO.setDispensedCoins(dispensedCoins.stream().map(String::valueOf).collect(Collectors.joining(",")));
            coinDispenserAuditDTO.setAmount(dispense.getAmount());

            if (this.coinDispenserRepository != null){
                this.coinDispenserRepository.save(CoinDispenserAuditMapper.dtoToEntity(coinDispenserAuditDTO));
            }
        }
        return dispensedCoins;
    }

    /**
     * logs audit records into a memory database
     * @return audit records
     */
    @Override
    public List<CoinDispenserAuditDTO> dispenserAuditList() {

        List<CoinDispenserAuditDTO> coinDispenserAuditDTOList = new LinkedList<>();

        for (CoinDispenserAudit coinDispenserAudit : coinDispenserRepository.findAll()) {

            coinDispenserAuditDTOList.add(CoinDispenserAuditMapper.entityToDto(coinDispenserAudit));
        }

        return coinDispenserAuditDTOList;
    }
}
