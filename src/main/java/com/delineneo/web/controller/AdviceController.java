package com.delineneo.web.controller;

import org.hibernate.validator.method.MethodConstraintViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: deline
 * Date: 8/05/13
 * Time: 9:58 PM
 */
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(MethodConstraintViolationException.class)
    public ModelAndView handleMethodConstraintViolationException(MethodConstraintViolationException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex);
        return modelAndView;
    }
}
