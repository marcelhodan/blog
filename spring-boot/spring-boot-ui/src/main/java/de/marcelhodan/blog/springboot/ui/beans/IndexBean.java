package de.marcelhodan.blog.springboot.ui.beans;

import javax.inject.Named;

@Named
public class IndexBean {

    private String firstName = "Tim";
    private String lastName = "Burton";

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

    public String showGreeting() {
	return String.format("Hello %s %s good friend. Good to see you!", firstName, lastName);
    }
}