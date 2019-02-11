import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DataBaseConenction.dbConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * Created by wojtek on 28.01.2019.
 */
public class LoginModel  {

    Connection connection ;

    public LoginModel () {

        try {
             this.connection = dbConnection.getConection();
        } catch (SQLException e) {
            e.printStackTrace();
        }if (this.connection == null) {
            System.exit(-1);
        }
    }


    public boolean isDataBasedConnected () {

         if (this.connection !=null) {
            return true;
        }else  {
             return false;
        }
    }

    public boolean isLogin ( String user , String password , String opt )throws  Exception {

        PreparedStatement pr = null;
        ResultSet rs = null;

        String sqlstatment = " Select * From login where username = ? and password =  ? and devision = ?";

        try {




                pr = this.connection.prepareStatement(sqlstatment);
                pr.setString(1, user);
                pr.setString(2, password);
                pr.setObject(3, opt);

                rs = pr.executeQuery();

                boolean boill;

                if (rs.next()) {
                    return true;
                }
                return false;


            } catch(SQLException e){
                return false;
            }

        finally{
                pr.close();
                rs.close();

            }
        }

    }




