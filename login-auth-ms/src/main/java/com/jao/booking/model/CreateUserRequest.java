package com.jao.booking.model;

import lombok.Data;

@Data
public final class CreateUserRequest {
    private UserDto user;
    private String password;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

