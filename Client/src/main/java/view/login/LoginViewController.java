package view.login;


import view.ViewHandler;
import viewModel.login.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginViewController {
    @FXML
    private Label response;
    @FXML
    private TextField userNameText;
    @FXML
    private TextField passWordText;
    private ViewHandler viewHandler;
    private LoginViewModel viewModel;

    @FXML
    void onLogin(ActionEvent event) {
        viewModel.login();
        if(response.getText().equals("Login successful")){
            viewHandler.openCalendarView();
            System.out.println("trying to change to calendar");
        }
    }

    public void init(LoginViewModel vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        userNameText.textProperty().bindBidirectional(vm.usernameProperty());
        passWordText.textProperty().bindBidirectional(vm.passwordProperty());
        response.textProperty().bindBidirectional(vm.loginResponseProperty());
        vm.clearProperties();
    }
}
