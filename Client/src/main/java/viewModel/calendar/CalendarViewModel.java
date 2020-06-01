package viewModel.calendar;

import javafx.beans.property.*;
import model.calendar.ICalendarModel;
import shared.Shift;
import shared.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class CalendarViewModel {

    private  ICalendarModel model;
    private  StringProperty date1x1;
    private  StringProperty date1x2;
    private  StringProperty date1x3;
    private  StringProperty date1x4;
    private  StringProperty date1x5;
    private  StringProperty date1x6;
    private  StringProperty date1x7;
    private  StringProperty date2x1;
    private  StringProperty date2x2;
    private  StringProperty date2x3;
    private  StringProperty date2x4;
    private  StringProperty date2x5;
    private  StringProperty date2x6;
    private  StringProperty date2x7;
    private  StringProperty date3x1;
    private  StringProperty date3x2;
    private  StringProperty date3x3;
    private  StringProperty date3x4;
    private  StringProperty date3x5;
    private  StringProperty date3x6;
    private  StringProperty date3x7;
    private  StringProperty date4x1;
    private  StringProperty date4x2;
    private  StringProperty date4x3;
    private  StringProperty date4x4;
    private  StringProperty date4x5;
    private  StringProperty date4x6;
    private  StringProperty date4x7;
    private  StringProperty date5x1;
    private  StringProperty date5x2;
    private  StringProperty date5x3;
    private  StringProperty date5x4;
    private  StringProperty date5x5;
    private  StringProperty date5x6;
    private  StringProperty date5x7;
    private  StringProperty date6x1;
    private  StringProperty date6x2;
    private  StringProperty date6x3;
    private  StringProperty date6x4;
    private  StringProperty date6x5;
    private  StringProperty date6x6;
    private  StringProperty date6x7;
    private  StringProperty user;
    private  StringProperty access;
    private  BooleanProperty buttons;
    private final ArrayList<StringProperty> dates;

    public CalendarViewModel(ICalendarModel model) {
        this.model = model;
        dates = new ArrayList<>();
        date1x1 = new SimpleStringProperty();
        date1x2 = new SimpleStringProperty();
        date1x3 = new SimpleStringProperty();
        date1x4 = new SimpleStringProperty();
        date1x5 = new SimpleStringProperty();
        date1x6 = new SimpleStringProperty();
        date1x7 = new SimpleStringProperty();
        date2x1 = new SimpleStringProperty();
        date2x2 = new SimpleStringProperty();
        date2x3 = new SimpleStringProperty();
        date2x4 = new SimpleStringProperty();
        date2x5 = new SimpleStringProperty();
        date2x6 = new SimpleStringProperty();
        date2x7 = new SimpleStringProperty();
        date3x1 = new SimpleStringProperty();
        date3x2 = new SimpleStringProperty();
        date3x3 = new SimpleStringProperty();
        date3x4 = new SimpleStringProperty();
        date3x5 = new SimpleStringProperty();
        date3x6 = new SimpleStringProperty();
        date3x7 = new SimpleStringProperty();
        date4x1 = new SimpleStringProperty();
        date4x2 = new SimpleStringProperty();
        date4x3 = new SimpleStringProperty();
        date4x4 = new SimpleStringProperty();
        date4x5 = new SimpleStringProperty();
        date4x6 = new SimpleStringProperty();
        date4x7 = new SimpleStringProperty();
        date5x1 = new SimpleStringProperty();
        date5x2 = new SimpleStringProperty();
        date5x3 = new SimpleStringProperty();
        date5x4 = new SimpleStringProperty();
        date5x5 = new SimpleStringProperty();
        date5x6 = new SimpleStringProperty();
        date5x7 = new SimpleStringProperty();
        date6x1 = new SimpleStringProperty();
        date6x2 = new SimpleStringProperty();
        date6x3 = new SimpleStringProperty();
        date6x4 = new SimpleStringProperty();
        date6x5 = new SimpleStringProperty();
        date6x6 = new SimpleStringProperty();
        date6x7 = new SimpleStringProperty();
        user = new SimpleStringProperty();
        access = new SimpleStringProperty();
        buttons = new SimpleBooleanProperty();
        dates.add(date1x1);
        dates.add(date1x2);
        dates.add(date1x3);
        dates.add(date1x4);
        dates.add(date1x5);
        dates.add(date1x6);
        dates.add(date1x7);
        dates.add(date2x1);
        dates.add(date2x2);
        dates.add(date2x3);
        dates.add(date2x4);
        dates.add(date2x5);
        dates.add(date2x6);
        dates.add(date2x7);
        dates.add(date3x1);
        dates.add(date3x2);
        dates.add(date3x3);
        dates.add(date3x4);
        dates.add(date3x5);
        dates.add(date3x6);
        dates.add(date3x7);
        dates.add(date4x1);
        dates.add(date4x2);
        dates.add(date4x3);
        dates.add(date4x4);
        dates.add(date4x5);
        dates.add(date4x6);
        dates.add(date4x7);
        dates.add(date5x1);
        dates.add(date5x2);
        dates.add(date5x3);
        dates.add(date5x4);
        dates.add(date5x5);
        dates.add(date5x6);
        dates.add(date5x7);
        dates.add(date6x1);
        dates.add(date6x2);
        dates.add(date6x3);
        dates.add(date6x4);
        dates.add(date6x5);
        dates.add(date6x6);
        dates.add(date6x7);
        dates.add(user);
        dates.add(access);
    }

    public void getCalendar(String timeStamp) {
        model.getCalendar(timeStamp);
    }

    public StringProperty getPropertyList(int i) {
        return dates.get(i);
    }

    public void getUser() {
        model.getCurrentUser();
        user.set("User: " + model.getUserFromModel().getUsername());
        access.set("Access: " + model.getUserFromModel().getAccessLevel());
    }

    public void clearCalendar() {
        for (int i = 0; i < 42; i++) {
            dates.get(i).set("");
        }
    }

    public void setCalendar(int month, int year) {
        String firstDayOfMonth = "01-" + month + "-" + year;
        String dayOfWeek = returnWeekDay(firstDayOfMonth);
        int dayOfWeekInt = dayToInt(dayOfWeek);
        int dayMax = getLastDayOfMonth(firstDayOfMonth);

        //Setts all days of the month. the numbers on days
        for (int i = 1; i < dayMax + 1; i++) {
            dates.get(dayOfWeekInt + i - 1).set(i + "");
        }
        //Sets acctual shifts
        for (int i = 0; i < model.getModelShifts().size(); i++) {
            int dayMonth = model.getModelShifts().get(i).getDate().getDayOfMonth();
            dates.get(dayOfWeekInt + dayMonth - 1).set(dates.get(dayOfWeekInt + dayMonth - 1).get() + "\n" + getShiftFormatting(model.getModelShifts().get(i)));
        }
    }

    public String returnWeekDay(String date){
        String day = "default";
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("d-M-yyyy");
            Date dt1 = format1.parse(date);
            DateFormat format2 = new SimpleDateFormat("EEEE");
            day = format2.format(dt1);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("date was badly formated");
        }
        return day;
    }

    public int dayToInt(String day){
        int dayOfWeekCounter;
        switch (day) {
            case "Monday":
                dayOfWeekCounter = 0;
                break;
            case "Tuesday":
                dayOfWeekCounter = 1;
                break;
            case "Wednesday":
                dayOfWeekCounter = 2;
                break;
            case "Thursday":
                dayOfWeekCounter = 3;
                break;
            case "Friday":
                dayOfWeekCounter = 4;
                break;
            case "Saturday":
                dayOfWeekCounter = 5;
                break;
            case "Sunday":
                dayOfWeekCounter = 6;
                break;
            default:
                dayOfWeekCounter = 0;
                break;
        }
        return dayOfWeekCounter;
    }

    public int getLastDayOfMonth(String date){
        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d-M-yyyy"));
        int maxMonthDay = convertedDate.getMonth().length(convertedDate.isLeapYear());
        return maxMonthDay;
    }

    public String getShiftFormatting(Shift shift){
        if(model.getUserFromModel().getAccessLevel().equals("EMPLOYEE")){
            return model.getUserFromModel().getFname() + " " + model.getUserFromModel().getLname() + "\n" + shift.getDescription();
        } else if(model.getUserFromModel().getAccessLevel().equals("MANAGER")){
            try {
                User user = model.getUserFromDatabase(shift.getUser_id());
                return  "On shift: "+ user.getFname() + " " + user.getLname() + "\n" + "---------------------";
            }catch (NullPointerException e){
                System.out.println("User was removed");
                return  "On shift: User was removed " + "\n" + "---------------------";
            }

        }else{
            return "User not found";
        }
    }

    public void setFunctionalityDifferences() {
        if(model.getUserFromModel().getAccessLevel().equals("EMPLOYEE")){
            buttons.set(false);
        }else {
            buttons.set(true);
        }
    }

    public BooleanProperty getButtonsProperty(){
        return buttons;
    }
}
