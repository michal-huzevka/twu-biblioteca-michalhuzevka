package com.twu.biblioteca.view;

import com.twu.biblioteca.model.UserAccount;

/**
 * Created by michal on 2/23/15.
 */
public class UserDetailsView implements View {
    private UserAccount account;
    public UserDetailsView(UserAccount account) {
        this.account = account;
    }
    public String output() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: " + account.getFirstName() + " " + account.getLastName() + "\r\n");
        builder.append("Phone Number: " + account.getPhoneNumber() + "\r\n");
        builder.append("Email: " + account.getEmail() + "\r\n");
        return builder.toString();
    }
}
