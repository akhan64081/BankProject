package UI.AtmCustomerChecker;

import BankSystem.BankSystem;
import BankSystem.DataAccess.Account;
import UI.CustomerScreen.CustomerScreenController;
import UI.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;

public class AtmCustomerSearchController
{
    public TextField CusPinNum_Text;


    //region Manager Grids
    public GridPane ManagerAccount_GridPane;
    public GridPane ManagerOptions_GridPane;
    //endregion Manager Grids

    //The bank system data context
    private BankSystem _bankSystem;
    //endregion Variables

    //region Bank System Getter/Setter
    public BankSystem get_bankSystem()
    {
        return _bankSystem;
    }

    public void set_bankSystem(BankSystem _bankSystem)
    {
        this._bankSystem = _bankSystem;
    }
    //endregion Bank System Getter/Setter

    public void IsUserManager(boolean isManager)
    {
        ManagerAccount_GridPane.setVisible(isManager);
        ManagerOptions_GridPane.setVisible(isManager);
    }

    public void Back_OnMouseClick(MouseEvent mouseEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../MainScreen.fxml"));

        try
        {
            fxmlLoader.load();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        //end of  try catch block

        Parent parent = fxmlLoader.getRoot();

        Stage stage = (Stage) CusPinNum_Text.getScene().getWindow();
        stage.setTitle("Main Screen");
        //stage.setScene(new Scene(parent));

        //Use setRoot instead of setScene to prevent the window resizing.
        stage.getScene().setRoot(parent);

        MainController mainController = fxmlLoader.getController();
        mainController.set_bankSystem(_bankSystem);

    }


    public void Enter_OnMouseClick(MouseEvent mouseEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AtmCustomerChecker/AtmCustomerSearch.fxml"));

        try
        {
            fxmlLoader.load();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Parent customerAtmParent = fxmlLoader.getRoot();

        Stage stage = (Stage) CustomerScreenController.CustomerName_Text.getScene().getWindow();

        stage.setTitle("Customer Account Screen");

        //Use setRoot instead of setScene to prevent the window resizing.
        stage.getScene().setRoot(customerAtmParent);

        CustomerScreenController customerScreenController = fxmlLoader.getController();
        customerScreenController.set_bankSystem(_bankSystem);

    }



}
