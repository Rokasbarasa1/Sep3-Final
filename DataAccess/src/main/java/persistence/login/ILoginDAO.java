package persistence.login;

import shared.User;

public interface ILoginDAO {
    String validateLogin(User user) ;
}
