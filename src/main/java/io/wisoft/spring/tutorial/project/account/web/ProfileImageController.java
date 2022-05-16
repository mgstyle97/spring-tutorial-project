package io.wisoft.spring.tutorial.project.account.web;

import io.wisoft.spring.tutorial.project.handler.FileHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProfileImageController {

    @GetMapping("/{image-name}")
    public ResponseEntity<byte[]> getProfileImage(@PathVariable("image-name") @Valid final String profileImageName) {
        final byte[] fileData = FileHandler.getFileData(profileImageName);

        final String contentType = FileHandler.getImageContentType(profileImageName);
        final HttpHeaders headers = generateContentTypeHeader(contentType);

        return new ResponseEntity<>(
                fileData, headers, HttpStatus.OK
        );
    }

    private HttpHeaders generateContentTypeHeader(final String contentType) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(contentType));

        return headers;
    }

}
