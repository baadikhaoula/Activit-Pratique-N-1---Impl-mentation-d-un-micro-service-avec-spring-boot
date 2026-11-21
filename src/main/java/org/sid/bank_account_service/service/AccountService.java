package org.sid.bank_account_service.service;

import org.sid.bank_account_service.dto.AccountRequestdTO;
import org.sid.bank_account_service.dto.AccountResponseDto;

public interface AccountService {
    public AccountResponseDto addAccount(AccountRequestdTO accountRequestdTO);
}
