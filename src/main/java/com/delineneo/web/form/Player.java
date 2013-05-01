package com.delineneo.web.form;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * User: deline
 * Date: 1/05/13
 * Time: 8:42 PM
 */
public class Player {
    @NotBlank(message = "Required field")
    private String firstName;

    @NotBlank(message = "Required field")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
