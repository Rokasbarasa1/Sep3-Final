package viewModel.employeeList;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import model.employeeList.IEmployeeListModel;
import shared.User;
import java.util.ArrayList;

public class EmployeeListViewModel {

    private IEmployeeListModel model;

    public EmployeeListViewModel(IEmployeeListModel employeeListModel) {
        model = employeeListModel;
    }

    public ArrayList<User> populateListView() {
        return model.getEmployees();
    }

    public void deleteUser(int id) {
        model.deleteUser(id);
    }

}
