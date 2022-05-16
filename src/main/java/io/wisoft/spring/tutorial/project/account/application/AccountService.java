package io.wisoft.spring.tutorial.project.account.application;

import io.wisoft.spring.tutorial.project.handler.exception.AccountNotFoundException;
import io.wisoft.spring.tutorial.project.account.Account;
import io.wisoft.spring.tutorial.project.account.persistence.AccountRepository;
import io.wisoft.spring.tutorial.project.account.web.dto.res.FindAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(readOnly = true)
    public FindAccountResponse findAccountById(final Long accountId) {
        final Account account = this.accountRepository.findById(accountId)
                .orElseThrow(
                        () -> new AccountNotFoundException(accountId + "에 맞는 사용자가 존재하지 않습니다."))
                .toDomain();

        return FindAccountResponse.from(account);
    }

}
