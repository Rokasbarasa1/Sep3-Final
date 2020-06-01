package model.login;

import shared.User;

public interface ILoginModel {
    void login(String username, String password);
    String loginResponse();
    User getCurrentUser();
}
