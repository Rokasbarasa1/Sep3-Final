package model.calendar;

import shared.Shift;
import shared.User;

import java.util.ArrayList;
import java.util.Date;

public interface ICalendarModel {
    User getUserFromModel();
    User getUserFromDatabase(int userId);
    void getCalendar(String timeStamp);
    void getCurrentUser();
    ArrayList<Shift> getModelShifts();
    String getTimeStamp();
}
