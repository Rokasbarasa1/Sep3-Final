package clientNetworking.employeeList;

import clientNetworking.HTTPHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import shared.User;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class EmployeeListClient implements IEmployeeListClient {
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;

    public EmployeeListClient(HTTPHandler httpHandler) {
        this.httpHandler = httpHandler;
        this.jsonSerializer = new Gson();
    }

    @Override
    public ArrayList<User> getEmployees(int managerId) {
        String PATH ="http://127.0.0.1:5000/api/user/?managerId="+ managerId;
        response = httpHandler.getFromAPI(PATH);
        Type listType = new TypeToken<ArrayList<User>>(){}.getType();
        ArrayList<User> shifts = jsonSerializer.fromJson(response, listType);
        return shifts;
    }

    @Override
    public void deleteUser(int id) {
        String PATH ="http://127.0.0.1:5000/api/User/" + id;
        httpHandler.deleteFromAPI(PATH);
    }
}
