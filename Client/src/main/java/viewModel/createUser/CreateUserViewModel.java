package viewModel.createUser;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;
import model.createUser.ICreateUserModel;
import javafx.scene.paint.Paint;

public class CreateUserViewModel {

    private StringProperty username, password, fname, lname, email, createEmployeeResponse, status, accesslevel;
    private Property<Paint> usernamePaint, passwordPaint, fnamePaint, lnamePaint, emailPaint;
    private ICreateUserModel model;

    public CreateUserViewModel(ICreateUserModel model) {
        this.model = model;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        fname = new SimpleStringProperty();
        lname = new SimpleStringProperty();
        email = new SimpleStringProperty();
        createEmployeeResponse = new SimpleStringProperty();
        status = new SimpleStringProperty();
        accesslevel = new SimpleStringProperty();

        usernamePaint = new SimpleObjectProperty<Paint>();
        passwordPaint = new SimpleObjectProperty<Paint>();
        fnamePaint = new SimpleObjectProperty<Paint>();
        lnamePaint = new SimpleObjectProperty<Paint>();
        emailPaint = new SimpleObjectProperty<Paint>();
    }

    public void submitEmployee() {
        resetColors();
        boolean usernameCorrect = false;
        boolean passwordCorrect = false;
        boolean fnameCorrect = false;
        boolean lnameCorrect = false;
        boolean emailCorrect = false;

        if(username.get() != null && !username.get().isEmpty()){
            usernameCorrect = true;
        }else {
            usernamePaint.setValue(Color.RED);
        }
        if(password.get() != null && !password.get().isEmpty()){
            passwordCorrect = true;
        }else {
            passwordPaint.setValue(Color.RED);
        }
        if(fname.get() != null && !fname.get().isEmpty()){
            fnameCorrect = true;
        }else {
            fnamePaint.setValue(Color.RED);
        }
        if(lname.get() != null && !lname.get().isEmpty()){
            lnameCorrect = true;
        }else {
            lnamePaint.setValue(Color.RED);
        }
        if(email.get() != null && !email.get().isEmpty()){
            emailCorrect = true;
        }else {
            emailPaint.setValue(Color.RED);
        }
        if(usernameCorrect && passwordCorrect && fnameCorrect && lnameCorrect && emailCorrect){
            System.out.println(status.getValue()+ " " + accesslevel.getValue());
            String API_reponse = model.createUser(username.getValue(), password.getValue(), fname.getValue(), lname.getValue(),
                    email.getValue(), status.getValue(), accesslevel.getValue());
            createEmployeeResponse.setValue(API_reponse);
        }else {
            createEmployeeResponse.set("Enter missing fields");
        }
    }

    public void clearFields() {
        username.setValue("");
        password.setValue("");
        fname.setValue("");
        lname.setValue("");
        email.setValue("");
        resetColors();
    }

    public void resetColors(){
        usernamePaint.setValue(Color.BLACK);
        passwordPaint.setValue(Color.BLACK);
        fnamePaint.setValue(Color.BLACK);
        lnamePaint.setValue(Color.BLACK);
        emailPaint.setValue(Color.BLACK);
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty firstnameProperty() {
        return fname;
    }

    public StringProperty lastnameProperty() {
        return lname;
    }

    public StringProperty emailProperty(){
        return email;
    }

    public StringProperty createEmployeeResponseProperty() {
        return createEmployeeResponse;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public StringProperty accesslevelProperty() {
        return accesslevel;
    }

    public Property<Paint> usernamePaintProperty() {
        return usernamePaint;
    }

    public Property<Paint> passwordPaintProperty() {
        return passwordPaint;
    }

    public Property<Paint> fnamePaintProperty() {
        return fnamePaint;
    }

    public Property<Paint> lnamePaintProperty() {
        return lnamePaint;
    }

    public Property<Paint> emailPaintProperty() {
        return emailPaint;
    }

    public void resetAddUser() {
        username.set("");
        password.set("");
        fname.set("");
        lname.set("");
        email.set("");
        createEmployeeResponse.set("");
    }
}
