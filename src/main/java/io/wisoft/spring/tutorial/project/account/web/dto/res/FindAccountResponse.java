package io.wisoft.spring.tutorial.project.account.web.dto.res;

import io.wisoft.spring.tutorial.project.handler.FileHandler;
import io.wisoft.spring.tutorial.project.account.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindAccountResponse {

    private String name;
    private String email;
    private String profileImageName;

    public FindAccountResponse(
            final String name,
            final String email,
            final String profileImageName
    ) {
        this.name = name;
        this.email = email;
        this.profileImageName = profileImageName;
    }

    public static FindAccountResponse from(final Account account) {
        return new FindAccountResponse(
                account.getName(), account.getEmail(),
                FileHandler.getFileName(account.getProfileImgPath())
        );
    }

}
