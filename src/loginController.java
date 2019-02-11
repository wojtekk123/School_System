import admin.AdminConntroller;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import studnet.StudentController;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class loginController implements Initializable   {


 LoginModel loginModel = new LoginModel();


 @FXML
 private Label DBStatusLabel ;

 @FXML
 private TextField UsernameTextFiled;

 @FXML
 private TextField PasswordTextField;

 @FXML
 private Button LoginButton;

 @FXML
 private ComboBox<option> ComboBoxStatus;

    @FXML
    private Label loginStatus;

 @Override
 public void initialize(URL location, ResourceBundle resources) {

  if (this.loginModel.isDataBasedConnected()){
   this.DBStatusLabel.setText("Connected");
  }else {
   this.DBStatusLabel.setText("Disconnected");
  }

  this.ComboBoxStatus.setItems(FXCollections.observableArrayList(option.values()));

 }

  @FXML void Login (ActionEvent event) {
        try {

            if (this.loginModel.isLogin(this.UsernameTextFiled.getText(),this.PasswordTextField.getText(),((option)this.ComboBoxStatus.getValue()).toString())){

                Stage stage = (Stage)this.LoginButton.getScene().getWindow();
             stage.close();

                    switch (((option) this.ComboBoxStatus.getValue()).toString()) {
                        case "Admin":
                            adminLogin();
                            break;
                        case "Student":
                            studentLogin();
                            break;


                    }


                }

            else {
                this.loginStatus.setText("wrong cordinate");
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void studentLogin () {

        try {
           Stage userStage = new Stage();
           FXMLLoader loader = new FXMLLoader();
           Pane root = (Pane) loader.load(getClass().getResource("/studnet/student.fxml").openStream());

           StudentController studentController = (StudentController) loader.getController();
           Scene scene = new Scene(root);
           userStage.setScene(scene);
           userStage.setTitle("student dashbord");
           userStage.show();
           userStage.setResizable(false);

          }catch (IOException e) {
           e.printStackTrace();
        }


    }
  public void adminLogin (){

        try {
             Stage adminStage = new Stage();
             FXMLLoader loader = new FXMLLoader();
             Pane root  = (Pane) loader.load(getClass().getResource("/admin/admin.fxml").openStream());
            AdminConntroller adminConntroller  = (AdminConntroller)loader.getController();

             Scene scene = new Scene(root);
             adminStage.setScene(scene);
             adminStage.setTitle("admin dasbord");
             adminStage.show();
             adminStage.setResizable(false);
        }catch (IOException e) {
            e.printStackTrace();
        }

  }

}
