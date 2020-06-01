package viewModel.shiftList;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import model.shiftList.IShiftListModel;
import shared.Shift;
import java.util.ArrayList;

public class ShiftListViewModel {
    private IShiftListModel model;
    private BooleanProperty buttons;


    public ShiftListViewModel(IShiftListModel shiftListModel) {
        this.model = shiftListModel;
        buttons = new SimpleBooleanProperty();
    }

    public ArrayList<Shift> populateListView() {
        return model.getShifts();
    }

    public void removeShift(int shiftId) {
        model.removeShift(shiftId);
    }

    public void saveShiftForEditing(Shift seleced) {
        model.saveShift(seleced);
    }

    public BooleanProperty getButtonsProperty(){

        return buttons;
    }

    public void setFunctionalityDifferences() {
        if(model.getUserFromModel().getAccessLevel().equals("EMPLOYEE")){
            buttons.set(false);
        }else {
            buttons.set(true);
        }
    }
}