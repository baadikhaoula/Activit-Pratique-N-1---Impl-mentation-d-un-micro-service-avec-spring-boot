package org.sid.bank_account_service.service;

import jakarta.transaction.Transactional;
import org.sid.bank_account_service.dto.AccountRequestdTO;
import org.sid.bank_account_service.dto.AccountResponseDto;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    BankAccountRepository bankAccountRepository;
    @Override
    public AccountResponseDto addAccount(AccountRequestdTO accountRequestdTO) {
        BankAccount bankAccount=accountMapper.toBankAccount(accountRequestdTO);
        bankAccountRepository.save(bankAccount);
        return accountMapper.toAccountResponseDto(bankAccount);
    }
}
