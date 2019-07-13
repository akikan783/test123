package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class test15_checkController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label1_byCheck;

    @FXML
    private Button OK_byCheckButton;
    
    @FXML
    private Button Cancel_byCheckButton;

    @FXML
    void onOK_byCheck(ActionEvent event) {
    	Main.getInstance().setPage_bycheck();
    }
    
    @FXML
    void onCancel_byCheck(ActionEvent event) {
    	Main.getInstance().setPage_byResult();
    }

    @FXML
    void initialize() {
        assert label1_byCheck != null : "fx:id=\"label1_byCheck\" was not injected: check your FXML file 'test15_check.fxml'.";
        assert OK_byCheckButton != null : "fx:id=\"OK_byCheckButton\" was not injected: check your FXML file 'test15_check.fxml'.";
        assert Cancel_byCheckButton != null : "fx:id=\"Cancel_byCheckButton\" was not injected: check your FXML file 'test15_check.fxml'.";

    }
    
    @Override
    public void initialize(URL loacation, ResourceBundle resources) {
    	switch(Main.getInstance().toggle()) {
    	case 1:
    		label1_byCheck.setText("10•ªŠÔ‚É‰½–â‚Å‚«‚é‚©Œv‘ª‚µ‚Ü‚·");
    		break;
    	case 2:
    		label1_byCheck.setText("10–â‚É‚©‚©‚éŽžŠÔ‚ðŒv‘ª‚µ‚Ü‚·");
    		break;
    	default:
    		label1_byCheck.setText("error");
    		break;
    	}
    }
    
}
