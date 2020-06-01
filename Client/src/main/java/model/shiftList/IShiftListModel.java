package model.shiftList;

import shared.Shift;
import shared.User;

import java.util.ArrayList;

public interface IShiftListModel {
    ArrayList<Shift> getShifts();
    void saveShift(Shift selected);
    void removeShift(int shiftId);
    User getUserFromModel();
}
