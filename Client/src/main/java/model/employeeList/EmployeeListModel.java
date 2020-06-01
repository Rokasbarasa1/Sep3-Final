package model.employeeList;

import clientNetworking.employeeList.IEmployeeListClient;
import model.calendar.ICalendarModel;
import shared.User;

import java.util.ArrayList;

public class EmployeeListModel implements IEmployeeListModel {
    private IEmployeeListClient employeeListClient;
    private ICalendarModel calendarModel;

    public EmployeeListModel(ICalendarModel calendarModel, IEmployeeListClient employeeListClient) {
        this.employeeListClient = employeeListClient;
        this.calendarModel = calendarModel;
    }

    @Override
    public ArrayList<User> getEmployees() {
        return employeeListClient.getEmployees(calendarModel.getUserFromModel().getId());
    }

    @Override
    public void deleteUser(int id) {
        employeeListClient.deleteUser(id);
    }
}
