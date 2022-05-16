package io.wisoft.spring.tutorial.project.account.web.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInResponse {

    private Long accountId;

    public SignInResponse(final Long accountId) {
        this.accountId = accountId;
    }

    public static SignInResponse from(final Long userId) {
        return new SignInResponse(userId);
    }

}
