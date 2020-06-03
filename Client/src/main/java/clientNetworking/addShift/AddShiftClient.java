package clientNetworking.addShift;

import clientNetworking.HTTPHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import shared.Shift;
import shared.User;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddShiftClient implements IAddShiftClient {
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;

    public AddShiftClient(HTTPHandler httpHandler) {
        this.httpHandler = httpHandler;
        this.jsonSerializer = new Gson();
    }

    @Override
    public String postShift(Shift shift) {
        String PATH ="http://127.0.0.1:5000/api/Shift";
        String shiftJson = jsonSerializer.toJson(shift);
        response = httpHandler.postToAPI(shiftJson, PATH);
        return response;
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public ArrayList<User> getEmployees(int managerId) {
        String PATH ="http://127.0.0.1:5000/api/user/?managerId="+ managerId;
        response = httpHandler.getFromAPI(PATH);
        Type listType = new TypeToken<ArrayList<User>>(){}.getType();
        ArrayList<User> users = jsonSerializer.fromJson(response, listType);
        return users;
    }
}
