package com.example.MadCamp_Week3_Server.web.service;

import com.example.MadCamp_Week3_Server.web.dto.AccountDto;
import com.example.MadCamp_Week3_Server.web.entity.Account;
import com.example.MadCamp_Week3_Server.web.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository _accountRepository;

    @Autowired
    ModelMapper _modelMapper;


    @Override
    public Optional<AccountDto> getAccount(String userId) throws ChangeSetPersister.NotFoundException {
        Optional<Account> user = _accountRepository.findByUserId(userId);

        AccountDto userDto;

        userDto = user.map(account -> {
            account.setPassword("");
            return _modelMapper.map(account, AccountDto.class);
        }).orElseThrow(ChangeSetPersister.NotFoundException::new);

        return Optional.ofNullable(userDto);
    }

    @Override
    public Optional<AccountDto> addAccount(AccountDto accountDto) {
        Account savedUser = _accountRepository.save(_modelMapper.map(accountDto, Account.class));

        return Optional.ofNullable(_modelMapper.map(savedUser, AccountDto.class));
    }
}
