package sample;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
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
        DataBase db = new DataBase();
        EventHandler event = new EventHandler() {
            @Override
            public void handle(Event event) {
                tex.setText(db.getData(fild.getText()));
            }
        };
        
        tex.setText("");
        but.setOnAction(event);
        fild.setOnAction(event);
    }
}


