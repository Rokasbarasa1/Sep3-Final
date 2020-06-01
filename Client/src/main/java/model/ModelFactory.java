package model;


import clientNetworking.ClientFactory;
import model.addshift.AddShiftModel;
import model.addshift.IAddShiftModel;
import model.calendar.ICalendarModel;
import model.calendar.CalendarModel;
import model.createUser.CreateUserModel;
import model.createUser.ICreateUserModel;
import model.employeeList.EmployeeListModel;
import model.employeeList.IEmployeeListModel;
import model.login.ILoginModel;
import model.login.LoginModel;
import model.shiftList.IShiftListModel;
import model.shiftList.ShiftListModel;

public class ModelFactory {
    private ClientFactory clientFactory;
    private ILoginModel loginModel;
    private ICalendarModel calendarModel;
    private ICreateUserModel createUserModel;
    private IAddShiftModel addShiftModel;
    private IEmployeeListModel employeeListModel;
    private IShiftListModel shiftListModel;

    public ModelFactory(ClientFactory c) {
        clientFactory = c;
    }

    public ILoginModel loginModel() {
        if(loginModel == null)
            loginModel = new LoginModel(clientFactory.loginClient());
        return loginModel;
    }

    public ICalendarModel calendarModel() {
        if(calendarModel == null)
            calendarModel = new CalendarModel(clientFactory.calendarClient(), loginModel());
        return calendarModel;
    }

    public ICreateUserModel createUserModel() {
        if (createUserModel == null)
            createUserModel = new CreateUserModel(calendarModel,clientFactory.createUserClient());
        return createUserModel;
    }

    public IAddShiftModel addShiftModel() {
        if (addShiftModel == null)
            addShiftModel = new AddShiftModel(clientFactory.shiftClient(), loginModel());
        return addShiftModel;
    }

    public IEmployeeListModel employeeListModel() {
        if (employeeListModel == null)
            employeeListModel = new EmployeeListModel(calendarModel, clientFactory.employeeList());
        return employeeListModel;
    }

    public IShiftListModel shiftListModel() {
        if(shiftListModel == null)
            shiftListModel = new ShiftListModel(calendarModel, clientFactory.shiftListClient());
        return shiftListModel;
    }
}
