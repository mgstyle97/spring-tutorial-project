package io.wisoft.spring.tutorial.project.account.web;

import io.wisoft.spring.tutorial.project.account.application.AccountService;
import io.wisoft.spring.tutorial.project.account.web.dto.res.FindAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindAccountResponse> findAccountById(@PathVariable("id") @Valid final Long accountId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.accountService.findAccountById(accountId));
    }

}
