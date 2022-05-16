package io.wisoft.spring.tutorial.project.account.application;

import io.wisoft.spring.tutorial.project.handler.FileHandler;
import io.wisoft.spring.tutorial.project.account.Account;
import io.wisoft.spring.tutorial.project.account.persistence.AccountEntity;
import io.wisoft.spring.tutorial.project.account.persistence.AccountRepository;
import io.wisoft.spring.tutorial.project.account.web.dto.req.LoginRequest;
import io.wisoft.spring.tutorial.project.account.web.dto.req.SignUpRequest;
import io.wisoft.spring.tutorial.project.account.web.dto.res.SignInResponse;
import io.wisoft.spring.tutorial.project.account.web.dto.res.SignUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthService {

    private final AccountRepository accountRepository;

    @Autowired
    public AuthService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public SignUpResponse signup(final SignUpRequest request) {
        final String profileImagePath = FileHandler.saveFileData(request.getProfileImage());

        Account account = new Account(
                request.getName(), request.getEmail(),
                request.getPassword(), profileImagePath
        );

        account = this.accountRepository
                .save(AccountEntity.from(account))
                .toDomain();

        return SignUpResponse.from(account.getId());
    }

    @Transactional(readOnly = true)
    public SignInResponse login(final LoginRequest request) {
        final Account account = this.accountRepository.findByEmail(request.getEmail())
                .orElseThrow(
                        () -> new IllegalArgumentException(request.getEmail() + "에 관한 사용자를 찾을 수 없습니다."))
                .toDomain();

        account.checkPassword(request.getPassword());

        return SignInResponse.from(account.getId());
    }

}
