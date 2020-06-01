package persistence.shift;

import shared.Shift;

import java.util.ArrayList;

public interface IShiftDAO {
    String postShift(Shift shift, String operation);
    ArrayList<Shift> getShifts(String userID, String month, String year);
    ArrayList<Shift> getShiftsManager(String managerID, String month, String year);
    String updateShift(Shift shift, String operation);
    String deleteShift(String shiftId);
}
