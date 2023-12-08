package lk.codeschool.task.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.codeschool.task.tm.EmployeeTM;

import java.time.LocalDate;

public class MainFormController {

    @FXML
    private TableView<EmployeeTM> tblEmployeeData;
    @FXML
    private ComboBox<String> cmbType;

    @FXML
    private TextField txtName;

    @FXML
    private RadioButton rbMale;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton rbFemale;

    @FXML
    private RadioButton rbOther;

    @FXML
    private TableColumn<EmployeeTM,String> colName;

    @FXML
    private TableColumn<EmployeeTM,String> colType;

    @FXML
    private TableColumn<EmployeeTM,String> colGender;

    @FXML
    private TableColumn<EmployeeTM, LocalDate> colBirthday;

    @FXML
    private TableColumn<EmployeeTM, Button> colOption;

    @FXML
    private DatePicker txtBirthDay;

    public void initialize(){
        //Data To Add Type Combo Box
        String [] data = {"Manager","QC","Security Officer","Receptionist"};

        //Convert Data to Observable Array List
        ObservableList<String> dataSet = FXCollections.observableArrayList(data);

        //Add Data To Combo Box
        cmbType.setItems(dataSet);

        //Call Visualize Method To Show Data
        visualizeTableData();

    }
    //Method To Visualize Data
    public void visualizeTableData(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("birthDay"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("option"));
    }


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        //Create Employee Object To Add Table
        EmployeeTM ob = new EmployeeTM();

        //Collect Data From UI
        String name = txtName.getText();
        String type = cmbType.getSelectionModel().getSelectedItem();
        LocalDate birthDay = txtBirthDay.getValue();
        String gender = rbFemale.isSelected() ? rbFemale.getText() : rbMale.isSelected() ? rbMale.getText():
                rbOther.isSelected() ? rbOther.getText() : "";

        //Create Option Button to display
        Button option = new Button("Delete");
        //Add Action to perform when click on delete
        option.setOnAction(e->{
            tblEmployeeData.getItems().remove(ob);
        });

        //Set Collected Data From UI To Object
        ob.setName(name);
        ob.setType(type);
        ob.setBirthDay(birthDay);
        ob.setGender(gender);
        ob.setOption(option);

        //Add Object To Table
        tblEmployeeData.getItems().add(ob);

        //Refresh Table
        tblEmployeeData.refresh();


        //Clear All Field
        txtName.clear();
        cmbType.getSelectionModel().clearSelection();
        txtBirthDay.setValue(null);
        rbFemale.setSelected(false);
        rbMale.setSelected(false);
        rbOther.setSelected(false);


    }



}
