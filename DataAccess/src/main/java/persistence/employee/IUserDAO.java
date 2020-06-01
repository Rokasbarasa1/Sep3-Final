package persistence.employee;

import shared.User;

import java.util.List;

public interface IUserDAO {
    String addUser(User user, String operation);
    User getUser(String userId);
    List<User> getUsersIdName(String managerId);
    List<User> getUsersByManager(String managerId);
    String deleteUser(String receivedPiece);
}
