package model.addshift;

import clientNetworking.addShift.IAddShiftClient;
import model.login.ILoginModel;
import shared.Shift;
import shared.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddShiftModel implements IAddShiftModel {

    public IAddShiftClient client;
    private ILoginModel loginModel;
    private ArrayList<User> userMap;

    public AddShiftModel(IAddShiftClient client, ILoginModel loginModel) {
        this.client = client;
        this.loginModel = loginModel;
    }

    public ArrayList<String> getUsers() {
        userMap = client.getUsers(loginModel.getCurrentUser().getId());
        ArrayList<String> listOfNames = new ArrayList<String>();
        for (User user : userMap)
        {
            listOfNames.add(user.getFname() + " " + user.getUsername());
        }
        return listOfNames;
    }

    public String addShift(String description, String employeeName, LocalDate date) {
        int manager_id = loginModel.getCurrentUser().getId();
        int user_id = 0;
        for (User user : userMap) {
            if (user.getFname().equals(employeeName)) {
                user_id = user.getId();
            }
        }
        Shift tmp_shift = new Shift(user_id, description, manager_id, date);
        String api_response = client.postShift(tmp_shift);
        System.out.println(api_response);
        return api_response;
    }
}
