package clientNetworking.calendar;

import shared.Shift;
import shared.User;

import java.util.ArrayList;

public interface ICalendarClient {
    ArrayList<Shift> getCalendarShifts(int userId, String accessLevel, String month);
    User getUser(String currentUser);
}
