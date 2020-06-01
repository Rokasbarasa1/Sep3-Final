package view;


import view.addshift.AddShiftController;
import view.calendar.CalendarViewController;
import view.createUser.CreateUserController;
import view.employeeList.EmployeeListController;
import view.login.LoginViewController;
import view.shiftList.ShiftListController;
import viewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory viewModelFactory;
    private Stage mainStage;
    private Scene loginScene;
    private Scene calendarScene;
    private Scene employeeList;
    private Scene createUser;
    private Scene addShift;
    private Scene shiftList;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        viewModelFactory = vmf;
        mainStage = stage;
    }

    public void start() {
        openLoginView();
        mainStage.show();
    }

    public void openLoginView() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("Login/Login.fxml", loader);
        LoginViewController controller = loader.getController();
        controller.init(viewModelFactory.getLoginViewModel(), this);
        loginScene = new Scene(root);
        mainStage.setTitle("Login");
        mainStage.setScene(loginScene);
    }

    public void openCalendarView() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("calendar/Calendar.fxml", loader);
        CalendarViewController controller = loader.getController();
        controller.init(viewModelFactory.getCalendarViewModel(), this);
        calendarScene = new Scene(root);
        mainStage.setTitle("Calendar");
        mainStage.setScene(calendarScene);
    }

    public void openCalendarViewOld() {
        FXMLLoader loader = new FXMLLoader();
        if (calendarScene == null) {
            Parent root = getRootByPath("calendar/Calendar.fxml", loader);
            CalendarViewController controller = loader.getController();
            controller.init(viewModelFactory.getCalendarViewModel(), this);
            calendarScene = new Scene(root);
        }
        mainStage.setTitle("Calendar");
        mainStage.setScene(calendarScene);
    }

    public void openCreateUserView() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("createUser/CreateUser.fxml", loader);
        CreateUserController controller = loader.getController();
        controller.init(viewModelFactory.getUserViewModel(), this);
        createUser = new Scene(root);
        mainStage.setTitle("Create User");
        mainStage.setScene(createUser);
    }

    public void openAddShiftView() {
        FXMLLoader loader = new FXMLLoader();
        if (addShift == null) {
            Parent root = getRootByPath("addshift/AddShift.fxml", loader);
            AddShiftController controller = loader.getController();
            controller.init(viewModelFactory.getAddShiftViewModel(), this);
            addShift = new Scene(root);
        }
        mainStage.setTitle("Add Shift");
        mainStage.setScene(addShift);
    }

    public void openEmployeeListView() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("employeeList/EmployeeList.fxml", loader);
        EmployeeListController controller = loader.getController();
        controller.init(viewModelFactory.getEmployeeListViewModel(), this);
        employeeList = new Scene(root);
        mainStage.setTitle("Employee list");
        mainStage.setScene(employeeList);
    }

    public void openShiftListView() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("shiftList/ShiftList.fxml", loader);
        ShiftListController controller = loader.getController();
        controller.init(viewModelFactory.getShiftListViewModel(), this);
        shiftList = new Scene(root);
        mainStage.setTitle("Shift list");
        mainStage.setScene(shiftList);

    }

    private Parent getRootByPath(String path, FXMLLoader loader) {
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
