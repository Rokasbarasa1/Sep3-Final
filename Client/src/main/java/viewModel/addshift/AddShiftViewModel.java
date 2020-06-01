package viewModel.addshift;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.addshift.IAddShiftModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddShiftViewModel {

    private IAddShiftModel model;
    private StringProperty description, response;

    public AddShiftViewModel(IAddShiftModel model) {
        this.model = model;
        description = new SimpleStringProperty();
        response = new SimpleStringProperty();
    }

    public ArrayList<String> getUsers() {
        return model.getUsers();
    }

    public void submitShift(LocalDate date, String employee, String description) {
        if (employee != null) {
            if(date != null){
                if(description == null){
                    description = "No description";
                }
                String API_response = model.addShift(description, employee, date);
                response.setValue(API_response);
            }else {
                response.setValue("Please select a date");
            }
        } else {
            response.setValue("Please select a valid employee");
        }
    }

    public void clearFields() {
        description.setValue(null);
        response.setValue("");
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public StringProperty responseProperty() {
        return response;
    }

}