package com.example.gas_station.Controllers;


import com.example.gas_station.model.Ledger;
import com.example.gas_station.repositories.LedgerRepository;
import com.example.gas_station.services.LedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ledger")
public class LedgerController {

    private LedgerService ledgerService;
    private LedgerRepository ledgerRepository;

    @Autowired
    public LedgerController(LedgerService ledgerService,LedgerRepository ledgerRepository){
        this.ledgerService = ledgerService;
        this.ledgerRepository = ledgerRepository;
    }

    @GetMapping("")
    public List<Ledger> getAllLedgers() {

        return ledgerService.getAllLedgers();
    }

    @GetMapping("/{id}")
    public Ledger getLedgerById(@PathVariable Long id) throws Exception {

        //code that gets user by id from database
        return ledgerService.getLedgerById(id);
    }
    @PostMapping("")
    public Ledger createLedger(@RequestBody Ledger ledger) throws Exception {


        //code that gets user by id from database
        return ledgerService.createNewLedger(ledger);
    }
    @PutMapping("/{id}")
    public Ledger updateLedger(@RequestBody Ledger ledger, @PathVariable Long id) throws Exception {

        //code that gets user by id from database
        return ledgerService.updateLedger(ledger,id);
    }

    @DeleteMapping("/{id}")
    public void deleteLedger(@PathVariable Long id) throws Exception{
        ledgerService.deleteLedger(id);
    }


}
