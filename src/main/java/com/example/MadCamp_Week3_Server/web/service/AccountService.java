package com.example.MadCamp_Week3_Server.web.service;

import com.example.MadCamp_Week3_Server.web.dto.AccountDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

public interface AccountService {

    Optional<AccountDto> getAccount(String userId) throws ChangeSetPersister.NotFoundException;

    Optional<AccountDto> addAccount(AccountDto accountDto);
}
