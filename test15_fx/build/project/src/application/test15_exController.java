package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import application.test15_sentence;

public class test15_exController implements Initializable {

	test15_sentence sentence = new test15_sentence();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label1_byEx;
    
    @FXML
    private Label label2_byEx;

    @FXML
    private TextField TextField1;

    @FXML
    private Button Next_byExButton;
    
    @FXML
    private Button Cancel_byExButton;

    @FXML
    void onActionTextField(ActionEvent event) {
    	boolean a = TextField1.getText().equals(label2_byEx.getText());
    	if(a) {
    		Main.getInstance().judge_c();
    		Main.getInstance().input_J("Åõ");
    	} else {
    		Main.getInstance().input_J("Å~");
    	}
    	Main.getInstance().input_Q(label2_byEx.getText());
    	Main.getInstance().input_A(TextField1.getText());
    	Main.getInstance().setPage_byEx();
    }

    @FXML
    void onNext_byEx(ActionEvent event) {
    	boolean a = TextField1.getText().equals(label2_byEx.getText());
    	if(a) {
    		Main.getInstance().judge_c();
    		Main.getInstance().input_J("Åõ");
    	} else {
    		Main.getInstance().input_J("Å~");
    	}
    	Main.getInstance().input_Q(label2_byEx.getText());
    	Main.getInstance().input_A(TextField1.getText());
    	Main.getInstance().setPage_byEx();
    }

    @FXML
    void onCancel1_byEx(ActionEvent event) {
    	Main.getInstance().cancel_byEx();
    }
    
    @FXML
    void initialize() {
        assert label1_byEx != null : "fx:id=\"label1_byEx\" was not injected: check your FXML file 'test15_ex.fxml'.";
        assert label2_byEx != null : "fx:id=\"label2_byEx\" was not injected: check your FXML file 'test15_ex.fxml'.";
        assert TextField1 != null : "fx:id=\"TextField1\" was not injected: check your FXML file 'test15_ex.fxml'.";
        assert Next_byExButton != null : "fx:id=\"Next_byExButton\" was not injected: check your FXML file 'test15_ex.fxml'.";
        assert Cancel_byExButton != null : "fx:id=\"Cancel_byExButton\" was not injected: check your FXML file 'test15_ex.fxml'.";

    }
    
    @Override
    public void initialize(URL loacation, ResourceBundle resources) {
    	label1_byEx.setText( (Main.getInstance().count() + 1) + "ñ‚ñ⁄");
    	label2_byEx.setText(sentence.Q());
    }
    
}
