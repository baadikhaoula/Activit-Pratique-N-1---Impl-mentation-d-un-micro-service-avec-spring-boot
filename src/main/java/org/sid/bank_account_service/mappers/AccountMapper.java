package org.sid.bank_account_service.mappers;

import lombok.NoArgsConstructor;
import org.sid.bank_account_service.dto.AccountRequestdTO;
import org.sid.bank_account_service.dto.AccountResponseDto;
import org.sid.bank_account_service.entities.BankAccount;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@NoArgsConstructor
public class AccountMapper {
    public BankAccount toBankAccount(AccountRequestdTO accountRequestdTO){
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID())
                .balance(accountRequestdTO.getBalance())
                .createdAt(new Date())
                .type(accountRequestdTO.getType())
                .currency(accountRequestdTO.getCurrency())
                .build();
        return bankAccount;
    }
    public AccountResponseDto toAccountResponseDto(BankAccount bankAccount){
        AccountResponseDto accountResponseDto=AccountResponseDto.builder()
                .id(bankAccount.getId())
                .type(bankAccount.getType())
                .currency(bankAccount.getCurrency())
                .balance(bankAccount.getBalance())
                .createdAt(bankAccount.getCreatedAt())
                .build();
        return accountResponseDto;
    }
}