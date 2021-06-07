package com.example.MadCamp_Week3_Server.web.controller;

import com.example.MadCamp_Week3_Server.web.dto.AccountDto;
import com.example.MadCamp_Week3_Server.web.entity.Account;
import com.example.MadCamp_Week3_Server.web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService _accountService;

    @GetMapping("/{userId}")
    public ResponseEntity<AccountDto> getOne(@PathVariable String userId) throws ChangeSetPersister.NotFoundException {
        Optional<AccountDto> userDto = _accountService.getAccount(userId);

        return userDto.map(account -> ResponseEntity.status(HttpStatus.OK).body(account)).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //중복 검사를 해야하는데 이건 일단 기능 구현 마저 하고 진행
    @PostMapping
    public ResponseEntity<AccountDto> newOne(@RequestBody AccountDto accountDto) {
        Optional<AccountDto> userDto = _accountService.addAccount(accountDto);

        return userDto.map(account -> ResponseEntity.status(HttpStatus.CREATED).body(account)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
