package com.example.gas_station.services;

import com.example.gas_station.model.Ledger;
import com.example.gas_station.repositories.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedgerService {

    private LedgerRepository ledgerRepository;

    @Autowired
    public LedgerService(LedgerRepository ledgerRepository) {
        this.ledgerRepository = ledgerRepository;
    }

    public List<Ledger> getAllLedgers() {
        return ledgerRepository.findAll();
    }

    public Ledger getLedgerById(Long id) throws Exception {

        return ledgerRepository.findById(id)
                .orElseThrow(() -> new Exception("Ledger not found"));
    }

    public Ledger createNewLedger(Ledger ledger) throws Exception {

        if (ledger.getIdLedger() != null) {
            throw new Exception("Id is not null. Id is decided by DB.");
        }

        return ledgerRepository.save(ledger);
    }
    public Ledger updateLedger(Ledger ledger, Long id) throws Exception {

        if (! ledger.getIdLedger().equals(id)) {
            throw new Exception("ids doesn't match.");
        }

        Ledger ledgerFromDB = this.getLedgerById(id);

        ledgerFromDB.setYear(ledger.getYear());
        ledgerFromDB.setMonth(ledgerFromDB.getMonth());
        ledgerFromDB.setIncome(ledgerFromDB.getIncome());
        ledgerFromDB.setExpenses(ledgerFromDB.getExpenses());
        ledgerFromDB.setTotal(ledgerFromDB.getTotal());


        return ledgerRepository.save(ledgerFromDB);
    }


    public void  deleteLedger(Long id) throws Exception{

        ledgerRepository.deleteById(id);
    }

}
