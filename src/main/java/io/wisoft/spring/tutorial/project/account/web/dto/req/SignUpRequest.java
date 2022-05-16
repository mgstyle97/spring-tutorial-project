package io.wisoft.spring.tutorial.project.account.web.dto.req;

import io.wisoft.spring.tutorial.project.global.web.validator.image.Custom;
import io.wisoft.spring.tutorial.project.global.web.validator.image.Image;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@Getter
@Setter
public class SignUpRequest {

    @NotBlank(message = "이름은 필수 항목입니다.")
    private String name;

    @NotBlank(message = "이메일은 필수 항목입니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    private String password;

    @Image(groups = Custom.class)
    @NotNull(message = "프로필 이미지를 지정해주세요.", groups = Default.class)
    private MultipartFile profileImage;

}
