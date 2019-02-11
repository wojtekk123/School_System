package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by wojtek on 29.01.2019.
 */
public class StudentData {

    private final StringProperty AdminButtonID;
    private final StringProperty AdminButtonFN;
    private final StringProperty AdminButtonLN;
    private final StringProperty AdminButtonE;
    private final StringProperty AdminButtonDOB;

    public StudentData (String id, String FirstName, String LastName , String Email, String DOB ) {

        this.AdminButtonID = new SimpleStringProperty(id);
        this.AdminButtonFN = new SimpleStringProperty(FirstName);
        this.AdminButtonLN =  new SimpleStringProperty(LastName);
        this.AdminButtonE  = new SimpleStringProperty(Email);
        this.AdminButtonDOB =new SimpleStringProperty(DOB);

    }


    public String getAdminButtonID() {
        return AdminButtonID.get();
    }

    public StringProperty adminButtonIDProperty() {
        return AdminButtonID;
    }

    public void setAdminButtonID(String adminButtonID) {
        this.AdminButtonID.set(adminButtonID);
    }

    public String getAdminButtonFN() {
        return AdminButtonFN.get();
    }

    public StringProperty adminButtonFNProperty() {
        return AdminButtonFN;
    }

    public void setAdminButtonFN(String adminButtonFN) {
        this.AdminButtonFN.set(adminButtonFN);
    }

    public String getAdminButtonLN() {
        return AdminButtonLN.get();
    }

    public StringProperty adminButtonLNProperty() {
        return AdminButtonLN;
    }

    public void setAdminButtonLN(String adminButtonLN) {
        this.AdminButtonLN.set(adminButtonLN);
    }

    public String getAdminButtonE() {
        return AdminButtonE.get();
    }

    public StringProperty adminButtonEProperty() {
        return AdminButtonE;
    }

    public void setAdminButtonE(String adminButtonE) {
        this.AdminButtonE.set(adminButtonE);
    }

    public String getAdminButtonDOB() {
        return AdminButtonDOB.get();
    }

    public StringProperty adminButtonDOBProperty() {
        return AdminButtonDOB;
    }

    public void setAdminButtonDOB(String adminButtonDOB) {
        this.AdminButtonDOB.set(adminButtonDOB);
    }
}
