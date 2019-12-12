package com.lovo.hibernate.dto;

public class UserDto {
   public UserDto(){}
    public UserDto(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }
    public UserDto(String userName, int userAge,String roleName) {
        this.userName = userName;
        this.userAge = userAge;
        this.roleName=roleName;
    }
    private String roleName;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
