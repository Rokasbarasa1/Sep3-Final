package view.shiftList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Shift;
import shared.User;
import view.ViewHandler;

import viewModel.shiftList.ShiftListViewModel;

import java.time.LocalDate;
import java.util.Optional;

public class ShiftListController {
    @FXML
    private TableView<Shift> table;
    @FXML
    private TableColumn<Shift, Integer> shiftID;
    @FXML
    private TableColumn<Shift, Integer> managerID;
    @FXML
    private TableColumn<Shift, Integer> workerID;
    @FXML
    private TableColumn<Shift, LocalDate> dateID;
    @FXML
    private TableColumn<Shift, String> descriptionID;
    @FXML
    private Button deleteButton;
    @FXML
    private Button editButton;

    private ViewHandler viewHandler;
    private ShiftListViewModel viewModel;
    private ObservableList<Shift> shifts = FXCollections.observableArrayList();

    public void init(ShiftListViewModel vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        shiftID.setCellValueFactory(new PropertyValueFactory<Shift, Integer>("id"));
        managerID.setCellValueFactory(new PropertyValueFactory<Shift, Integer>("user_id"));
        workerID.setCellValueFactory(new PropertyValueFactory<Shift, Integer>("manager_id"));
        dateID.setCellValueFactory(new PropertyValueFactory<Shift, LocalDate>("date"));
        descriptionID.setCellValueFactory(new PropertyValueFactory<Shift, String>("description"));

        deleteButton.visibleProperty().bindBidirectional(viewModel.getButtonsProperty());
        editButton.visibleProperty().bindBidirectional(viewModel.getButtonsProperty());
        viewModel.setFunctionalityDifferences();
        shifts.addAll(viewModel.populateListView());
        table.setItems(shifts);
    }

    @FXML
    void onBack(ActionEvent event) {
        viewHandler.openCalendarView();
    }

    @FXML
    void onDeleteShift(ActionEvent event) {
        Shift shift = table.getSelectionModel().getSelectedItem();
        if(shift != null){
            boolean delete = false;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Delete user");
            alert.setHeaderText("Do you want to delete this shift?");

            ButtonType cancelButtonType =  new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getDialogPane().getButtonTypes().add(cancelButtonType);

            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK){
                delete = true;
            }
            if(delete){
                shift = table.getSelectionModel().getSelectedItem();
                viewModel.removeShift(shift.getId());
            }
            viewHandler.openShiftListView();
        }
    }

    @FXML
    void onEdit(ActionEvent event) {
        Shift seleced = table.getSelectionModel().getSelectedItem();
        viewModel.saveShiftForEditing(seleced);
        //viewHandler.openEditShift();
    }
}
