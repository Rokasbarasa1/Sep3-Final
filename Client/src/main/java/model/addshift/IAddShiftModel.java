package model.addshift;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IAddShiftModel {
    ArrayList<String> getUsers();
    String addShift(String description, String employeeName, LocalDate date);
}
