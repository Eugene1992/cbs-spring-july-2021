package com.cbs.edu.springbootdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {
    @Override
    public boolean isValid(String fieldValue, ConstraintValidatorContext constraintValidatorContext) {
        return fieldValue != null && fieldValue.matches("[0-9]+")
                && (fieldValue.length() > 8 && fieldValue.length() < 14);
    }
}
