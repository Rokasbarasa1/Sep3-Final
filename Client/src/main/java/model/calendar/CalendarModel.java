package model.calendar;

import clientNetworking.calendar.ICalendarClient;
import model.login.ILoginModel;
import shared.Shift;
import shared.User;

import java.util.ArrayList;

public class CalendarModel implements ICalendarModel {
    private ICalendarClient calendarClient;
    private ILoginModel loginModel;
    private User currentUser;
    private ArrayList<Shift> shifts;
    private String savedTimeStamp;

    public CalendarModel(ICalendarClient calendarClient, ILoginModel loginModel) {
        this.calendarClient = calendarClient;
        this.loginModel = loginModel;
        shifts = new ArrayList<Shift>();
    }

    @Override
    public void getCalendar(String timeStamp) {
        this.savedTimeStamp = timeStamp;
        shifts = calendarClient.getCalendarShifts(currentUser.getId(), currentUser.getAccessLevel() ,  timeStamp);
    }

    @Override
    public void getCurrentUser() {
        currentUser = calendarClient.getUser( Integer.toString(loginModel.getCurrentUser().getId()));
        System.out.println("User recieved"+ currentUser.getAccessLevel());
    }

    @Override
    public ArrayList<Shift> getModelShifts() {
        return shifts;
    }

    @Override
    public String getTimeStamp() {
        return savedTimeStamp;
    }

    @Override
    public User getUserFromModel(){
        return currentUser;
    }

    @Override
    public User getUserFromDatabase(int userId) {
        return calendarClient.getUser( Integer.toString(userId));
    }
}
