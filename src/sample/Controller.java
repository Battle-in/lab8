package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fild;

    @FXML
    private Text tex;

    @FXML
    private Button but;

    @FXML
    void initialize() {
        tex.setText("");
        
    }
}

