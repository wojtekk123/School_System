import java.sql.Connection;

/**
 * Created by wojtek on 29.01.2019.
 */
import DataBaseConenction.dbConnection;
public class attempt {

    public static void main(String[] args) {
        boolean bool ;
        Connection connection;
        boolean czyjest;


        try {

          LoginModel loginModel = new LoginModel();
          bool = loginModel.isDataBasedConnected();
          if ( bool ){

              System.out.println(" is connected");
          }

          czyjest= loginModel.isLogin("wojtek","wotek","Admin");
            if (czyjest){
                System.out.println("its ok");
            }else {
                System.out.println("not ok");

            }


        }catch ( Exception e){
            e.printStackTrace();
        }

    }

}
