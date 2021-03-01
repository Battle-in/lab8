package sample;

import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
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
                String old = tex.getText();
                String now = db.getData(fild.getText());
                if (old.contains(now)) {
                    String[] a = old.split("]");
                    if (a.length == 1)
                        now += "]2";
                    else
                        now += "]" + Integer.toString((Integer.parseInt(a[1]) + 1));
                }
                tex.setText(now);
            }
        };

        tex.setText("");
        but.setOnAction(event);
        fild.setOnAction(event);
    }
}


