package network;

import com.google.gson.Gson;
import persistence.DAOFactory;
import shared.Shift;
import shared.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSocketHandler implements Runnable {
    private Socket socket;
    private OutputStream outToClient;
    private InputStream inFromClient;
    private DAOFactory daoFactory;
    private Gson gson;

    public DatabaseSocketHandler(Socket socket, DAOFactory daoFactory){
        this.socket = socket;
        this.daoFactory = daoFactory;
        gson = new Gson();
        try {
            inFromClient = socket.getInputStream();
            outToClient = socket.getOutputStream();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                byte[] lenBytes = new byte[4];
                inFromClient.read(lenBytes, 0, 4);
                int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                        ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
                byte[] receivedBytes = new byte[len];

                inFromClient.read(receivedBytes, 0, len);
                String received = new String(receivedBytes, 0, len);
                String[] receivedPieces = received.split(";");

                if(receivedPieces[0].equals("Check")){
                    sendToClient("Check");
                }else if(receivedPieces[0].equals("Login")){
                    System.out.println(receivedPieces[1]);
                    User login = gson.fromJson(receivedPieces[1], User.class);
                    String confirmation = daoFactory.getLoginDAO().validateLogin(login);
                    sendToClient(confirmation);
                }
                else if(receivedPieces[0].equals("CalendarMonth")) {
                    String[] date = receivedPieces[2].split("-");
                    ArrayList<Shift> shiftsForMonth = new ArrayList<>();
                    // Inputs are :Username for first input, month in MM-yyyy format
                    if(receivedPieces[3].equals("EMPLOYEE")){
                        System.out.println("Getting employee");
                        shiftsForMonth = daoFactory.getShiftDAO().getShifts(receivedPieces[1], date[0], date[1]);
                    }else if(receivedPieces[3].equals("MANAGER")){
                        System.out.println("Getting manager");
                        shiftsForMonth = daoFactory.getShiftDAO().getShiftsManager(receivedPieces[1], date[0], date[1]);
                    } else {
                        System.out.println("Problem in determening access level");
                    }
                    String shiftsJson = gson.toJson(shiftsForMonth);
                    sendToClient(shiftsJson);
                }
                else if(receivedPieces[0].equals("GetUser")) {
                    System.out.println("trying to get user data");
                    User user = daoFactory.getUserDAO().getUser(receivedPieces[1]);
                    String userJson = gson.toJson(user);
                    sendToClient(userJson);
                }
                else if(receivedPieces[0].equals("PostUser")) {
                    System.out.println(received);

                    if(!receivedPieces[1].equals("Confirmed")){
                        User new_user = gson.fromJson(receivedPieces[1], User.class);
                        String addResponse = daoFactory.getUserDAO().addUser(new_user,"Check");
                        sendToClient(addResponse);
                    } else {
                        User new_user = gson.fromJson(receivedPieces[2], User.class);
                        System.out.println(receivedPieces[2]);
                        System.out.println();
                        String addResponse = daoFactory.getUserDAO().addUser(new_user,"Post");
                        sendToClient(addResponse);
                    }
                }
                else if (receivedPieces[0].equals("PostShift")) {
                    System.out.println(received);
                    if(!receivedPieces[1].equals("Confirmed")){
                        Shift new_shift = gson.fromJson(receivedPieces[1], Shift.class);
                        String addResponse = daoFactory.getShiftDAO().postShift(new_shift,"Check");
                        sendToClient(addResponse);
                    } else {
                        Shift new_shift = gson.fromJson(receivedPieces[2], Shift.class);
                        String addResponse = daoFactory.getShiftDAO().postShift(new_shift,"Post");
                        sendToClient(addResponse);
                    }
                }
                else if (receivedPieces[0].equals("updateShift")) {
                    System.out.println(received);
                    if(!receivedPieces[1].equals("Confirmed")){
                        Shift new_shift = gson.fromJson(receivedPieces[1], Shift.class);
                        String addResponse = daoFactory.getShiftDAO().updateShift(new_shift,"Check");
                        sendToClient(addResponse);
                    } else {
                        Shift new_shift = gson.fromJson(receivedPieces[2], Shift.class);
                        String addResponse = daoFactory.getShiftDAO().updateShift(new_shift,"Post");
                        sendToClient(addResponse);
                    }
                }
                else if(receivedPieces[0].equals("GetUsersIDName")) {
                    System.out.println("Trying to get users");
                    List<User> users_id_name = daoFactory.getUserDAO().getUsersIdName(receivedPieces[1]);
                    String userJson = gson.toJson(users_id_name);
                    sendToClient(userJson);
                }
                else if(receivedPieces[0].equals("GetManagedUsers")){
                    System.out.println("Trying to get users managed by manager ID " + receivedPieces[1]);
                    List<User> managedUsers = daoFactory.getUserDAO().getUsersByManager(receivedPieces[1]);
                    String userJson = gson.toJson(managedUsers);
                    sendToClient(userJson);
                }else if(receivedPieces[0].equals("DeleteShift")){
                    System.out.println("Trying delete shift with ID: "+receivedPieces[1]);
                    String result = daoFactory.getShiftDAO().deleteShift(receivedPieces[1]);
                    sendToClient(result);
                }else if(receivedPieces[0].equals("DeleteUser")){
                    System.out.println("Trying delete User with ID: "+receivedPieces[1]);
                    String result = daoFactory.getUserDAO().deleteUser(receivedPieces[1]);
                    sendToClient(result);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToClient(String toSend){
        try {
            byte[] toSendBytes = toSend.getBytes();
            int toSendLen = toSendBytes.length;
            byte[] toSendLenBytes = new byte[4];
            toSendLenBytes[0] = (byte)(toSendLen & 0xff);
            toSendLenBytes[1] = (byte)((toSendLen >> 8) & 0xff);
            toSendLenBytes[2] = (byte)((toSendLen >> 16) & 0xff);
            toSendLenBytes[3] = (byte)((toSendLen >> 24) & 0xff);
            outToClient.write(toSendLenBytes);
            outToClient.write(toSendBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
