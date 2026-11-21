package org.sid.bank_account_service.web;

import org.sid.bank_account_service.dto.AccountRequestdTO;
import org.sid.bank_account_service.dto.AccountResponseDto;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.sid.bank_account_service.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("BankAccoutRestController")
public class AccountRestController {
    @Autowired
    BankAccountRepository bankAccountRepository;
    @Autowired
    AccountServiceImpl accountServiceImpl;
    @GetMapping("/api")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/BankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable UUID id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("not find"));
    }
    @PutMapping("/BankAccounts/{id}")
    public BankAccount put(@PathVariable UUID id, @RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("not find"));
        if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());

        return bankAccountRepository.save(account);
    }
    @PostMapping("/BankAccounts")
    public AccountResponseDto save(@RequestBody AccountRequestdTO account){
        return AccountServiceImpl.addAccount(account);
    }
    @DeleteMapping("/BankAccounts/{id}")
    public void delete(@PathVariable UUID id){
        bankAccountRepository.deleteById(id);
    }
}
