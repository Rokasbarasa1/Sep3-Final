package clientNetworking.calendar;

import clientNetworking.HTTPHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import shared.Shift;
import shared.User;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CalendarClient implements ICalendarClient {
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;


    public CalendarClient(HTTPHandler httpHandler){
        this.httpHandler = httpHandler;
        this.jsonSerializer = new Gson();
    }

    @Override
    public ArrayList<Shift> getCalendarShifts(int userID, String accessLevel, String month) {
        Type listType = new TypeToken<ArrayList<Shift>>(){}.getType();
        String PATH ="http://127.0.0.1:5000/api/Shift/?username=" +  userID + "&accessLevel=" + accessLevel + "&date=" + month;
        response = httpHandler.getFromAPI(PATH);
        ArrayList<Shift> shifts = jsonSerializer.fromJson(response, listType);
        return shifts;
    }

    @Override
    public User getUser(String Id) {
        String PATH ="http://127.0.0.1:5000/api/User/" +Id;
        response = httpHandler.getFromAPI(PATH);
        User user = jsonSerializer.fromJson(response, User.class);
        return user;
    }
}
