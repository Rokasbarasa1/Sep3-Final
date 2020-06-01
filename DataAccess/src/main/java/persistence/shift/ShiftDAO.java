package persistence.shift;

import exceptions.DataConnectionException;
import persistence.database.IDBConnection;
import shared.Shift;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ShiftDAO implements IShiftDAO {

    private final IDBConnection databaseConnection;

    public ShiftDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    //CHANGES FROM ANDERS BRANCH
    @Override
    public ArrayList<Shift> getShifts(String userID, String monthRequest, String yearRequest) {

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        ArrayList<Shift> shifts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + databaseConnection.getShiftTable() + " WHERE users_ID = " + Integer.parseInt(userID) + " AND month = " + Integer.parseInt(monthRequest) + " AND year = " + Integer.parseInt(yearRequest) + ";";
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next()) {
                int shift_ID = resultSet.getInt("Shift_ID");
                int user_ID = resultSet.getInt("Users_ID");
                String description = resultSet.getString("description");
                int managerID = resultSet.getInt("Manager_ID");
                int day = resultSet.getInt("day");
                int month = resultSet.getInt("month");
                int year = resultSet.getInt("year");

                String dateString = day + "-" + month + "-" + year;
                System.out.println(dateString);
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d-M-yyyy"));;


                shifts.add(new Shift(shift_ID, user_ID, description, managerID, date));
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return shifts;
    }

    @Override
    public ArrayList<Shift> getShiftsManager(String managerID, String monthRequest, String yearRequest) {

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        ArrayList<Shift> shifts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + databaseConnection.getShiftTable() + " WHERE Manager_ID = " + Integer.parseInt(managerID) + " AND month = " + Integer.parseInt(monthRequest) + " AND year = " + Integer.parseInt(yearRequest) + ";";
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next()) {
                int shift_ID = resultSet.getInt("Shift_ID");
                int user_ID = resultSet.getInt("Users_ID");
                String description = resultSet.getString("description");
                int manager_ID = resultSet.getInt("Manager_ID");
                int day = resultSet.getInt("day");
                int month = resultSet.getInt("month");
                int year = resultSet.getInt("year");

                String dateString = day + "-" + month + "-" + year;
                System.out.println(dateString);
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d-M-yyyy"));;

                shifts.add(new Shift(shift_ID, user_ID, description, manager_ID, date));
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return shifts;
    }

    @Override
    public String postShift(Shift shift, String operation) {

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        if(operation.equals("Check")){
            try {
                String sql = "SELECT Users_ID, Manager_ID, description, day, month, year FROM "
                        + databaseConnection.getShiftTable() + " WHERE Users_ID = "+ shift.getUser_id() + " AND day = '" + shift.getDate().getDayOfMonth() +"' AND month = '" + shift.getDate().getMonthValue() +"'AND year = '" + shift.getDate().getYear() +"';";
                preparedStatement = databaseConnection.createPreparedStatement(sql);
                resultSet = preparedStatement.executeQuery();
                System.out.println("In the add shift");
                if(resultSet.next()){
                    databaseConnection.closeConnection();
                    return "NOT";
                } else{
                    databaseConnection.closeConnection();
                    return "OK";
                }
            } catch (DataConnectionException| SQLException e) {
                e.printStackTrace();
                System.out.println("Problem in database");
                databaseConnection.closeConnection();
                return "NOT";
            }

        } else {
            try {
                String sql = "INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year) " +
                        "VALUES ('" + shift.getUser_id() + "', '" + shift.getManager_id() + "','"
                        + shift.getDescription() + "', '" + shift.getDate().getDayOfMonth()
                        + "', '" + shift.getDate().getMonthValue()
                        + "', '" + shift.getDate().getYear() + "')";
                preparedStatement = databaseConnection.createPreparedStatement(sql);
                preparedStatement.execute();
                databaseConnection.closeConnection();
                return "OK";
            } catch (DataConnectionException | SQLException e) {
                e.printStackTrace();
                databaseConnection.closeConnection();
                return "NOT";
            }
        }
    }

    @Override
    public String updateShift(Shift shift, String operation) {

        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Shift resultShift;
        String conclusion = "NOT";

        if (operation.equals("Check")) {
            try {
                String sqlSelect = "SELECT Users_ID, Manager_ID, description, day, month, year FROM Shift WHERE Users_ID = "
                        + shift.getUser_id() + " AND day = " + shift.getDate().getDayOfMonth() + " AND month = "
                        + shift.getDate().getMonthValue() + " AND year = " + shift.getDate().getYear() + ";";
                preparedStatement = databaseConnection.createPreparedStatement(sqlSelect);
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next()) {
                    int user_id = resultSet.getInt("Users_ID");
                    int day = resultSet.getInt("day");
                    int month = resultSet.getInt("month");
                    int year = resultSet.getInt("year");

                    String dateString = day + "-" + month + "-" + year;
                    System.out.println(dateString);
                    LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d-M-yyyy"));

                    resultShift = new Shift(user_id, date);

                    if (resultShift.getUser_id() == shift.getUser_id() &&
                            resultShift.getDate().getDayOfMonth() == shift.getDate().getDayOfMonth() &&
                    resultShift.getDate().getMonthValue() == shift.getDate().getMonthValue() &&
                    resultShift.getDate().getYear() == shift.getDate().getYear()) {
                        databaseConnection.closeConnection();
                        conclusion = "NOT";
                    } else{
                        databaseConnection.closeConnection();
                        conclusion = "OK";
                    }
                }

            } catch (DataConnectionException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String sql = "UPDATE Shift SET day = " + shift.getDate().getDayOfMonth() + ", month = "
                        + shift.getDate().getMonthValue() + ", year = " + shift.getDate().getYear()
                        + ", Users_ID = " + shift.getUser_id() + ", description = " + shift.getDescription()
                        + " WHERE Shift_ID = " + shift.getId() + ";";

                preparedStatement = databaseConnection.createPreparedStatement(sql);
                preparedStatement.execute();
                databaseConnection.closeConnection();
                conclusion = "OK";
            } catch (DataConnectionException | SQLException e) {
                e.printStackTrace();
                databaseConnection.closeConnection();
                conclusion = "NOT";
            }
        }
        return conclusion;
    }

    @Override
    public String deleteShift(String shiftId) {
        PreparedStatement preparedStatement;
        String conclusion = "NOT";
        try {
            String sql = "DELETE From Shift where Shift_ID = " + shiftId;
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            preparedStatement.execute();
            conclusion ="OK";
        } catch (SQLException | DataConnectionException e){
            e.printStackTrace();
            databaseConnection.closeConnection();
        }
        return conclusion;
    }
}
