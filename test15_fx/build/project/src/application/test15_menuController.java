package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class test15_menuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button M_byMenuButton;

    @FXML
    private Button Q_byMenuButton;
    
    @FXML
    private Button closeButton;

    @FXML
    void onM_byMenu(ActionEvent event) {
    	Main.getInstance().setPage_M_byMenu();
    }

    @FXML
    void onQ_byMenu(ActionEvent event) {
    	Main.getInstance().setPage_Q_byMenu();
    }
    
    @FXML
    void onClose(ActionEvent event) {
    	Main.getInstance().closeWindow(event);
    }

    @FXML
    void initialize() {
        assert M_byMenuButton != null : "fx:id=\"M_byMenuButton\" was not injected: check your FXML file 'test15_menu.fxml'.";
        assert Q_byMenuButton != null : "fx:id=\"Q_byMenuButton\" was not injected: check your FXML file 'test15_menu.fxml'.";
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'test15_menu.fxml'.";

    }
}
