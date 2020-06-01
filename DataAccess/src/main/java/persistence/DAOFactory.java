package persistence;

import persistence.employee.IUserDAO;
import persistence.database.IDBConnection;
import persistence.employee.UserDAO;
import persistence.login.ILoginDAO;
import persistence.login.LoginDAO;
import persistence.shift.IShiftDAO;
import persistence.shift.ShiftDAO;

public class DAOFactory {
    private IDBConnection connect;
    private ILoginDAO login;
    private IShiftDAO shift;
    private IUserDAO user;

    public DAOFactory(IDBConnection connect) {
        this.connect = connect;
    }

    public ILoginDAO getLoginDAO() {
        if(login == null)
            login = new LoginDAO(connect);
        return login;
    }

    public IShiftDAO getShiftDAO() {
        if(shift == null)
            shift = new ShiftDAO(connect);
        return shift;
    }

    public IUserDAO getUserDAO() {
        if(user == null)
            user = new UserDAO(connect);
        return user;
    }
}
