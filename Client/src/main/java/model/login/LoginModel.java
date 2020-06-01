package model.login;


import clientNetworking.login.ILoginClient;
import shared.User;

public class LoginModel implements ILoginModel {
    private ILoginClient loginClient;
    private User currentUser;
    private String response;

    public LoginModel(ILoginClient loginClient) {
        this.loginClient = loginClient;
    }

    @Override
    public void login(String username, String password) {
        User loginCarrier = new User(username,String.valueOf(password.hashCode()));
        String answer = loginClient.login(loginCarrier);
        String[] splitAnswer = answer.split(";");
        if(splitAnswer[0].equals("Login successful")){
            currentUser = loginCarrier;
            response = splitAnswer[0];
            currentUser.setId(Integer.parseInt(splitAnswer[1]));
        }else{
            response = answer;
        }
    }

    @Override
    public String loginResponse() {
        return response;
    }
    @Override
    public User getCurrentUser() {
        return currentUser;
    }
}
