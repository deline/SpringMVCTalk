package com.delineneo.web.form;

import com.delineneo.web.validation.MyCustomConstraint;
import org.hibernate.validator.constraints.NotBlank;

/**
 * User: deline
 * Date: 1/05/13
 * Time: 8:42 PM
 */

public class Player {

    private int id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @MyCustomConstraint
    private String lastName;

    public Player() {
    }

    public Player(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
