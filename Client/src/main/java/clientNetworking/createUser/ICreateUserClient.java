package clientNetworking.createUser;

import shared.User;

public interface ICreateUserClient {
    String createUser(User createUserCarrier);
    String getResponse();
}
