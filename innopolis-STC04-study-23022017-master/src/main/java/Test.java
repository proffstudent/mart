import main.models.connector.AcademConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by smoldyrev on 23.02.17.
 */
public class Test {
    public static void main(String[] args) {

       Connection con = AcademConnector.getConnection();
        /*try {
            UserDAO.registrationUser("loginww", "1","wwww");
        } catch (UserDAOException e) {
            e.printStackTrace();
        }*/

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM \"main\".\"user\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
