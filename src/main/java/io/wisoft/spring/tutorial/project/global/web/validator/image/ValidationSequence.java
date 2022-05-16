package io.wisoft.spring.tutorial.project.global.web.validator.image;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, Custom.class})
public interface ValidationSequence {
}
