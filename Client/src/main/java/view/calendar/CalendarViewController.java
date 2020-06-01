package view.calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import view.ViewHandler;
import viewModel.calendar.CalendarViewModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CalendarViewController {
    @FXML
    private Label date1x1 = new Label();
    @FXML
    private Label date1x2 = new Label();
    @FXML
    private Label date1x3 = new Label();
    @FXML
    private Label date1x4 = new Label();
    @FXML
    private Label date1x5 = new Label();
    @FXML
    private Label date1x6 = new Label();
    @FXML
    private Label date1x7 = new Label();
    @FXML
    private Label date2x1 = new Label();
    @FXML
    private Label date2x2 = new Label();
    @FXML
    private Label date2x3 = new Label();
    @FXML
    private Label date2x4 = new Label();
    @FXML
    private Label date2x5 = new Label();
    @FXML
    private Label date2x6 = new Label();
    @FXML
    private Label date2x7 = new Label();
    @FXML
    private Label date3x1 = new Label();
    @FXML
    private Label date3x2 = new Label();
    @FXML
    private Label date3x3 = new Label();
    @FXML
    private Label date3x4 = new Label();
    @FXML
    private Label date3x5 = new Label();
    @FXML
    private Label date3x6 = new Label();
    @FXML
    private Label date3x7 = new Label();
    @FXML
    private Label date4x1 = new Label();
    @FXML
    private Label date4x2 = new Label();
    @FXML
    private Label date4x3 = new Label();
    @FXML
    private Label date4x4 = new Label();
    @FXML
    private Label date4x5 = new Label();
    @FXML
    private Label date4x6 = new Label();
    @FXML
    private Label date4x7 = new Label();
    @FXML
    private Label date5x1 = new Label();
    @FXML
    private Label date5x2 = new Label();
    @FXML
    private Label date5x3 = new Label();
    @FXML
    private Label date5x4 = new Label();
    @FXML
    private Label date5x5 = new Label();
    @FXML
    private Label date5x6 = new Label();
    @FXML
    private Label date5x7 = new Label();
    @FXML
    private Label date6x1 = new Label();
    @FXML
    private Label date6x2 = new Label();
    @FXML
    private Label date6x3 = new Label();
    @FXML
    private Label date6x4 = new Label();
    @FXML
    private Label date6x5 = new Label();
    @FXML
    private Label date6x6 = new Label();
    @FXML
    private Label date6x7 = new Label();
    @FXML
    private Label user;
    @FXML
    private Label access;
    @FXML
    private ComboBox<String> monthsBox;
    @FXML
    private ComboBox<String> yearBox;
    @FXML
    private Button createShift;
    @FXML
    private Button employeeListButton;
    @FXML
    private Button shiftList;

    private ViewHandler viewHandler;
    private CalendarViewModel calendarViewModel;


    public void init(CalendarViewModel vm, ViewHandler vh) {
        calendarViewModel = vm;
        viewHandler = vh;
        date1x1.textProperty().bindBidirectional(calendarViewModel.getPropertyList(0));
        date1x2.textProperty().bindBidirectional(calendarViewModel.getPropertyList(1));
        date1x3.textProperty().bindBidirectional(calendarViewModel.getPropertyList(2));
        date1x4.textProperty().bindBidirectional(calendarViewModel.getPropertyList(3));
        date1x5.textProperty().bindBidirectional(calendarViewModel.getPropertyList(4));
        date1x6.textProperty().bindBidirectional(calendarViewModel.getPropertyList(5));
        date1x7.textProperty().bindBidirectional(calendarViewModel.getPropertyList(6));
        date2x1.textProperty().bindBidirectional(calendarViewModel.getPropertyList(7));
        date2x2.textProperty().bindBidirectional(calendarViewModel.getPropertyList(8));
        date2x3.textProperty().bindBidirectional(calendarViewModel.getPropertyList(9));
        date2x4.textProperty().bindBidirectional(calendarViewModel.getPropertyList(10));
        date2x5.textProperty().bindBidirectional(calendarViewModel.getPropertyList(11));
        date2x6.textProperty().bindBidirectional(calendarViewModel.getPropertyList(12));
        date2x7.textProperty().bindBidirectional(calendarViewModel.getPropertyList(13));
        date3x1.textProperty().bindBidirectional(calendarViewModel.getPropertyList(14));
        date3x2.textProperty().bindBidirectional(calendarViewModel.getPropertyList(15));
        date3x3.textProperty().bindBidirectional(calendarViewModel.getPropertyList(16));
        date3x4.textProperty().bindBidirectional(calendarViewModel.getPropertyList(17));
        date3x5.textProperty().bindBidirectional(calendarViewModel.getPropertyList(18));
        date3x6.textProperty().bindBidirectional(calendarViewModel.getPropertyList(19));
        date3x7.textProperty().bindBidirectional(calendarViewModel.getPropertyList(20));
        date4x1.textProperty().bindBidirectional(calendarViewModel.getPropertyList(21));
        date4x2.textProperty().bindBidirectional(calendarViewModel.getPropertyList(22));
        date4x3.textProperty().bindBidirectional(calendarViewModel.getPropertyList(23));
        date4x4.textProperty().bindBidirectional(calendarViewModel.getPropertyList(24));
        date4x5.textProperty().bindBidirectional(calendarViewModel.getPropertyList(25));
        date4x6.textProperty().bindBidirectional(calendarViewModel.getPropertyList(26));
        date4x7.textProperty().bindBidirectional(calendarViewModel.getPropertyList(27));
        date5x1.textProperty().bindBidirectional(calendarViewModel.getPropertyList(28));
        date5x2.textProperty().bindBidirectional(calendarViewModel.getPropertyList(29));
        date5x3.textProperty().bindBidirectional(calendarViewModel.getPropertyList(30));
        date5x4.textProperty().bindBidirectional(calendarViewModel.getPropertyList(31));
        date5x5.textProperty().bindBidirectional(calendarViewModel.getPropertyList(32));
        date5x6.textProperty().bindBidirectional(calendarViewModel.getPropertyList(33));
        date5x7.textProperty().bindBidirectional(calendarViewModel.getPropertyList(34));
        date6x1.textProperty().bindBidirectional(calendarViewModel.getPropertyList(35));
        date6x2.textProperty().bindBidirectional(calendarViewModel.getPropertyList(36));
        date6x3.textProperty().bindBidirectional(calendarViewModel.getPropertyList(37));
        date6x4.textProperty().bindBidirectional(calendarViewModel.getPropertyList(38));
        date6x5.textProperty().bindBidirectional(calendarViewModel.getPropertyList(39));
        date6x6.textProperty().bindBidirectional(calendarViewModel.getPropertyList(40));
        date6x7.textProperty().bindBidirectional(calendarViewModel.getPropertyList(41));
        //Menu side labels
        user.textProperty().bindBidirectional(calendarViewModel.getPropertyList(42));
        access.textProperty().bindBidirectional(calendarViewModel.getPropertyList(43));
        //Button accesibility for different access levels
        createShift.visibleProperty().bindBidirectional(calendarViewModel.getButtonsProperty());
        employeeListButton.visibleProperty().bindBidirectional(calendarViewModel.getButtonsProperty());
        //Combobox year and month population
        monthsBox.getItems().add("January");
        monthsBox.getItems().add("February");
        monthsBox.getItems().add("March");
        monthsBox.getItems().add("April");
        monthsBox.getItems().add("May");
        monthsBox.getItems().add("June");
        monthsBox.getItems().add("July");
        monthsBox.getItems().add("August");
        monthsBox.getItems().add("September");
        monthsBox.getItems().add("October");
        monthsBox.getItems().add("November");
        monthsBox.getItems().add("December");
        yearBox.getItems().add("2019");
        yearBox.getItems().add("2020");
        yearBox.getItems().add("2021");
        yearBox.getItems().add("2022");
        yearBox.getItems().add("2023");
        yearBox.getItems().add("2024");
        yearBox.getItems().add("2025");
        yearBox.getItems().add("2026");

        Calendar cal = Calendar.getInstance();
        yearBox.setValue(new SimpleDateFormat("yyyy", Locale.ENGLISH).format(cal.getTime()));
        monthsBox.setValue(new SimpleDateFormat("MMMM", Locale.ENGLISH).format(cal.getTime()));
        int monthNumber = 0;
        switch (monthsBox.getValue()) {
            case "January":
                monthNumber = 1;
                break;
            case "February":
                monthNumber = 2;
                break;
            case "March":
                monthNumber = 3;
                break;
            case "April":
                monthNumber = 4;
                break;
            case "May":
                monthNumber = 5;
                break;
            case "June":
                monthNumber = 6;
                break;
            case "July":
                monthNumber = 7;
                break;
            case "August":
                monthNumber = 8;
                break;
            case "September":
                monthNumber = 9;
                break;
            case "October":
                monthNumber = 10;
                break;
            case "November":
                monthNumber = 11;
                break;
            case "December":
                monthNumber = 12;
                break;

            default:
                monthNumber = 1;
                break;
        }
        calendarViewModel.getUser();
        calendarViewModel.setFunctionalityDifferences();
        calendarViewModel.getCalendar(monthNumber +"-"+ yearBox.getValue());
        calendarViewModel.setCalendar(monthNumber,  Integer.parseInt(yearBox.getValue()));
    }

    @FXML
    void logOut(ActionEvent event) {
        viewHandler.openLoginView();
    }
    @FXML
    void onAddShift(ActionEvent event) {
        viewHandler.openAddShiftView();
    }
    @FXML
    void onOpenShiftList(ActionEvent event) {
        viewHandler.openShiftListView();
    }
    @FXML
    void onEmployeeList(ActionEvent event) {
        viewHandler.openEmployeeListView();
    }
    @FXML
    void onSelectMonth(ActionEvent event) {
        int monthNumber = 0;
        switch (monthsBox.getValue()) {
            case "January":
                monthNumber = 1;
                break;
            case "February":
                monthNumber = 2;
                break;
            case "March":
                monthNumber = 3;
                break;
            case "April":
                monthNumber = 4;
                break;
            case "May":
                monthNumber = 5;
                break;
            case "June":
                monthNumber = 6;
                break;
            case "July":
                monthNumber = 7;
                break;
            case "August":
                monthNumber = 8;
                break;
            case "September":
                monthNumber = 9;
                break;
            case "October":
                monthNumber = 10;
                break;
            case "November":
                monthNumber = 11;
                break;
            case "December":
                monthNumber = 12;
                break;
        }
        calendarViewModel.getCalendar(monthNumber + "-" + yearBox.getValue());
        calendarViewModel.clearCalendar();
        calendarViewModel.setCalendar(monthNumber, Integer.parseInt(yearBox.getValue()));
    }
}
