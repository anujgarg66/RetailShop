package com.shop.core;

import java.time.LocalDateTime;

/*
 * Class to store information about User 
 */
public class User {

	private final UserType type;
    private final String userName;
    private final LocalDateTime joiningDate;
    
    public User(UserType type, String userName) {
        this.type = type;
        this.userName = userName;
        joiningDate = LocalDateTime.now();
    }
    
    public User(UserType type, String userName, LocalDateTime joiningDate) {
        this.type = type;
        this.userName = userName;
        this.joiningDate = joiningDate;
    }

	public UserType getType() {
		return type;
	}

	public String getUserName() {
		return userName;
	}

	public LocalDateTime getJoiningDate() {
		return joiningDate;
	}
}
