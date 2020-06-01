package model.createUser;

import clientNetworking.createUser.ICreateUserClient;
import model.calendar.CalendarModel;
import model.calendar.ICalendarModel;
import shared.User;

public class CreateUserModel implements ICreateUserModel {
    private ICalendarModel calendarModel;
    private ICreateUserClient iCreateUserClient;
    private String response;
    private User userInfo;

    public CreateUserModel(ICalendarModel calendarModel, ICreateUserClient iCreateUserClient) {
        this.calendarModel = calendarModel;
        this.iCreateUserClient = iCreateUserClient;
    }

    @Override
    public String createUser(String username, String password, String fname, String lname, String email, String status, String accesslevel) {
        User createUserCarrier = new User(calendarModel.getUserFromModel().getId(), username, password, fname, lname, email, status, accesslevel);
        String answer = iCreateUserClient.createUser(createUserCarrier);
        System.out.println(answer);
        return answer;
    }
}
