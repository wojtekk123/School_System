package admin;

import DataBaseConenction.dbConnection;
import com.oracle.webservices.internal.api.message.PropertySet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


/**
 * Created by wojtek on 29.01.2019.
 */
public class AdminConntroller implements Initializable{

    @FXML
    private TextField  AdminButtonID;
    @FXML
    private TextField AdminButtonFN;
    @FXML
    private TextField AdminButtonLN;
    @FXML
    private TextField AdminButtonE;
    @FXML
    private DatePicker AdminButtonDOB;

    @FXML
    private TableView<StudentData> studentTable;

    @FXML
    private TableColumn <StudentData,String> idColumn;
    @FXML
    private TableColumn <StudentData,String> FirstNameColumn;
    @FXML
    private TableColumn <StudentData,String> LastNameColumn;
    @FXML
    private TableColumn <StudentData,String> EmailColumn;
    @FXML
    private TableColumn <StudentData,String> DOBColumn;

    private dbConnection DataConnection;
    private ObservableList<StudentData> data;
    private String sql = "Select * From Student";

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.DataConnection = new dbConnection();


    }
 @FXML
    private void loadStudnetData (ActionEvent event ) {

        try {

            Connection conn = dbConnection.getConection();
            this.data = FXCollections.observableArrayList();
            ResultSet re = conn.createStatement().executeQuery(sql);
            while (re.next()){

                this.data.add(new StudentData(re.getString(1),re.getString(2),re.getString(3),re.getString(4),re.getString(5)));

            }



        }catch (SQLException e ){
            e.printStackTrace();

        }
        this.idColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("AdminButtonID"));
        this.FirstNameColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("AdminButtonFN"));
        this.LastNameColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("AdminButtonLN"));
        this.EmailColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("AdminButtonE"));
        this.DOBColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("AdminButtonDOB"));

         this.studentTable.setItems(null );
         this.studentTable.setItems(data);

    }
    @FXML
    private void addStudent (ActionEvent event){

        String sqlinsert = " INSERT INTO student   (id,name,lastname,email,DOB) VALUES (?,?,?,?,?) ";

                try {

            Connection connection = dbConnection.getConection();
            PreparedStatement stmt = connection.prepareStatement(sqlinsert);

            stmt.setString(1,this.AdminButtonID.getText());
                    stmt.setString(2,this.AdminButtonFN.getText());
                    stmt.setString(3,this.AdminButtonLN.getText());
                    stmt.setString(4,this.AdminButtonDOB.getEditor().getText());

                    stmt.execute();
                    connection.close();


                }catch (SQLException e) {


                }

    }
    @FXML
    private void CleatFiled (ActionEvent event) {
        this.AdminButtonID.setText("");
        this.AdminButtonLN.setText("");
        this.AdminButtonFN.setText("");
        this.AdminButtonE.setText("");
        this.AdminButtonDOB.setValue(null );
    }


}
