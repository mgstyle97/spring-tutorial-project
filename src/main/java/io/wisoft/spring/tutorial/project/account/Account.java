package io.wisoft.spring.tutorial.project.account;

import lombok.Getter;

@Getter
public class Account {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String profileImgPath;

    public Account(
            final String name, final String email,
            final String password, final String profileImgPath
    ) {
        this(null, name, email, password, profileImgPath);
    }
    public Account(
            final Long id,
            final String name, final String email,
            final String password, final String profileImgPath
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImgPath = profileImgPath;
    }

    public void checkPassword(final String confirmPassword) {
        if (!this.password.equals(confirmPassword)) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
    }

}