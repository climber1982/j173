package com.lovo.hibernate.dto;

public class UserDto {
   public UserDto(){}
    public UserDto(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    private String userName;
    private  int userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
