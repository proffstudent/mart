package main.services;

import main.common.exceptions.UserDAOException;
import main.models.dao.UserDAO;
import main.models.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by smoldyrev on 23.02.17.
 */

public class UserService {

    @Autowired
    private UserDAO userDAO;
//    public static boolean authorise(String login, String password) throws UserDAOException {
//        if(UserDAO.getUserByLoginAndPassword(login, password) != null){
//            return true;
//        }
//        return false;
//    }

    public static User authorise(String login, String password) throws UserDAOException {
            return UserDAO.getUserByLoginAndPassword(login, password);
    }



    public static boolean registration(String login, String password, String email) throws UserDAOException {
        return UserDAO.registrationUser(login, password,email);
    }

}
