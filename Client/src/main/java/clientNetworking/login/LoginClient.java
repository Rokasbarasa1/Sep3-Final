package clientNetworking.login;


import clientNetworking.HTTPHandler;
import com.google.gson.Gson;
import shared.User;

public class LoginClient implements ILoginClient {
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;


    public LoginClient(HTTPHandler httpHandler){
        this.httpHandler = httpHandler;
        this.jsonSerializer = new Gson();
    }

    @Override
    public String login(User loginCarrier) {
        String PATH ="http://127.0.0.1:5000/api/Login";
        String loginJson = jsonSerializer.toJson(loginCarrier);
        System.out.println(loginJson);
        response = httpHandler.postToAPI(loginJson, PATH);
        return response;
    }

    @Override
    public String getResponse() {
        return response;
    }
}
