package model.employeeList;

import shared.User;

import java.util.ArrayList;

public interface IEmployeeListModel {
    ArrayList<User> getEmployees();
    void deleteUser(int id);
}
