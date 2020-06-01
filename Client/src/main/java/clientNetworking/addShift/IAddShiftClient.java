package clientNetworking.addShift;

import shared.Shift;
import shared.User;

import java.util.ArrayList;

public interface IAddShiftClient {
    String postShift(Shift shift);
    String getResponse();
    ArrayList<User> getUsers(int managerId);
}
