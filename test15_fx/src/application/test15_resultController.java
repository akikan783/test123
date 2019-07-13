package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class test15_resultController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label1_byResult;
    
    @FXML
    private Label label2_byResult;

    @FXML
    private Button Prev_byResultButton;

    @FXML
    private ListView<String> ListView1_byResult;
    private ObservableList<String> items;

    @FXML
    private Label label3_byResult;
    
    @FXML
    void onPrev_byResult(ActionEvent event) {
    	Main.getInstance().setPage_byResult();
    }

    @FXML
    void initialize() {
        assert label1_byResult != null : "fx:id=\"label1_byResult\" was not injected: check your FXML file 'test15_result.fxml'.";
        assert label2_byResult != null : "fx:id=\"label2_byResult\" was not injected: check your FXML file 'test15_result.fxml'.";
        assert Prev_byResultButton != null : "fx:id=\"Prev_byResultButton\" was not injected: check your FXML file 'test15_result.fxml'.";
        assert ListView1_byResult != null : "fx:id=\"ListView1_byResult\" was not injected: check your FXML file 'test15_result.fxml'.";
        assert label3_byResult != null : "fx:id=\"label3_byResult\" was not injected: check your FXML file 'test15_result.fxml'.";

    }
    
    @Override
    public void initialize(URL loacation, ResourceBundle resources) {
    	switch(Main.getInstance().toggle()) {
    	case 1:
    		label1_byResult.setText( "âìöêî : " + Main.getInstance().count() + "ñ‚");
    		break;
    	case 2:
    		label1_byResult.setText("ÇsÇhÇlÇd : " + Main.getInstance().result_time());
    		break;
    	default:
    		break;
    	}
    	if(Main.getInstance().count() != 0 && Main.getInstance().count() == Main.getInstance().judge()) {
    		label2_byResult.setText("ê≥âêî : " + Main.getInstance().judge() + "ñ‚");
    		label3_byResult.setText("PERFECT!!");
    	} else {
    		label2_byResult.setText("ê≥âêî : " + Main.getInstance().judge() + "ñ‚");
    		label3_byResult.setText(" ");
    	}
    	items = FXCollections.observableArrayList();
    	ListView1_byResult.setItems(items);
    	for(int c = 0; c < Main.getInstance().Q_count(); c++) {
    		items.add( (c+1) + "ñ‚ñ⁄ : " + Main.getInstance().write_J(c));
    		items.add("ì¸óÕ : " + Main.getInstance().write_A(c));
    		items.add("ê≥ìö : " + Main.getInstance().write_Q(c));
    		items.add("");
    	}
    }
    
}
