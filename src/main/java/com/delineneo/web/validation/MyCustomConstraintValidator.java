package com.delineneo.web.validation;

import com.delineneo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * User: deline
 * Date: 5/06/13
 * Time: 6:38 PM
 */
public class MyCustomConstraintValidator implements ConstraintValidator<MyCustomConstraint, String> {

    @Autowired
    private SimpleService simpleService;

    @Override
    public void initialize(MyCustomConstraint myCustomConstraint) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("simpleService.getText() = " + simpleService.getText());
        return true;
    }
}
