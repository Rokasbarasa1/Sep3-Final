package model.createUser;

import shared.User;

public interface ICreateUserModel {
    String createUser(String username, String password, String fname, String lname, String email, String status, String accesslevel);

}
