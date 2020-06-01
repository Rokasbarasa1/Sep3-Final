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

        System.out.println(shiftJson);
        response = httpHandler.postToAPI(shiftJson, PATH);
        return response;
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public ArrayList<User> getUsers(int managerId) {
        String PATH ="http://127.0.0.1:5000/api/user/id-name?managerId=" + managerId;
        System.out.println("Getting users available for shifts");
        response = httpHandler.getFromAPI(PATH);

        Type type = new TypeToken<ArrayList<User>>(){}.getType();
        ArrayList<User> userList = jsonSerializer.fromJson(response, type);
        return userList;
    }
}
