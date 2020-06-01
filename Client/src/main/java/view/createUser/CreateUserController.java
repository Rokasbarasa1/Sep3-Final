package view.createUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import view.ViewHandler;
import viewModel.createUser.CreateUserViewModel;

public class CreateUserController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private ComboBox<String> statusComboBox;
    @FXML
    private ComboBox<String> accessLevelComboBox;
    @FXML
    private Label response;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelPassword;
    @FXML
    private Label labelFirstname;
    @FXML
    private Label labelLastname;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelStatus;
    @FXML
    private Label labelAccesslevel;
    @FXML
    private Label labelStatusString;
    @FXML
    private Label labelAccesslevelString;
    private ViewHandler viewHandler;
    private CreateUserViewModel createUserViewModel;

    public void init(CreateUserViewModel vm, ViewHandler vh) {
        createUserViewModel = vm;
        viewHandler = vh;
        usernameTextField.textProperty().bindBidirectional(vm.usernameProperty());
        passwordTextField.textProperty().bindBidirectional(vm.passwordProperty());
        firstnameTextField.textProperty().bindBidirectional(vm.firstnameProperty());
        lastnameTextField.textProperty().bindBidirectional(vm.lastnameProperty());
        emailTextField.textProperty().bindBidirectional(vm.emailProperty());
        response.textProperty().bindBidirectional(vm.createEmployeeResponseProperty());
        labelStatusString.textProperty().bindBidirectional(vm.statusProperty());
        labelAccesslevelString.textProperty().bindBidirectional(vm.accesslevelProperty());

        labelUsername.textFillProperty().bindBidirectional(vm.usernamePaintProperty());
        labelPassword.textFillProperty().bindBidirectional(vm.passwordPaintProperty());
        labelFirstname.textFillProperty().bindBidirectional(vm.fnamePaintProperty());
        labelLastname.textFillProperty().bindBidirectional(vm.lnamePaintProperty());
        labelEmail.textFillProperty().bindBidirectional(vm.emailPaintProperty());

        statusComboBox.getItems().add("ACTIVE");
        statusComboBox.getItems().add("INACTIVE");
        accessLevelComboBox.getItems().add("EMPLOYEE");
        accessLevelComboBox.getItems().add("MANAGER");

        statusComboBox.getSelectionModel().select(0);
        statusComboBox();
        accessLevelComboBox.getSelectionModel().select(0);
        accessLevelComboBox();
        vm.resetColors();
        vm.resetAddUser();
    }

    @FXML
    public void onSubmitButton(ActionEvent event) {
        createUserViewModel.submitEmployee();
        if(response.getText() == null){
            //Just to avoid errors
        } else if (response.getText().equals("Success")){
            viewHandler.openEmployeeListView();
            System.out.println("Changing to calendar");
        }
    }

    @FXML
    public void onCancelButton(ActionEvent event) {
        createUserViewModel.clearFields();
        viewHandler.openEmployeeListView();
    }

    @FXML
    public void onResetButton(ActionEvent event) {
        createUserViewModel.clearFields();
        statusComboBox.getSelectionModel().select(0);
        accessLevelComboBox.getSelectionModel().select(0);
        labelUsername.setTextFill(Color.BLACK);
        labelPassword.setTextFill(Color.BLACK);
        labelFirstname.setTextFill(Color.BLACK);
        labelLastname.setTextFill(Color.BLACK);
        labelEmail.setTextFill(Color.BLACK);

    }

    @FXML
    public void statusComboBox(ActionEvent event) {
        String selectedValue = statusComboBox.getValue();
        labelStatusString.setText(selectedValue);
    }

    @FXML
    public void statusComboBox() {
        String selectedValue = statusComboBox.getValue();
        labelStatusString.setText(selectedValue);
    }

    @FXML
    public void accessLevelComboBox(ActionEvent event) {
        String selectedValue = accessLevelComboBox.getValue();
        labelAccesslevelString.setText(selectedValue);
    }

    @FXML
    public void accessLevelComboBox() {
        String selectedValue = accessLevelComboBox.getValue();
        labelAccesslevelString.setText(selectedValue);
    }
}