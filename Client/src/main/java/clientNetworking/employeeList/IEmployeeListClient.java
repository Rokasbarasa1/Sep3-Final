package clientNetworking.employeeList;

import shared.User;

import java.util.ArrayList;

public interface IEmployeeListClient {
    ArrayList<User> getEmployees(int managerId);
    void deleteUser(int id);
}
