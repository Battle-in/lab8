package sample;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Date;

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
        unit_tests(); //запускаю блок с blackBox тестами
        DataBase db = new DataBase();
        //инициализирую отдельно для 2-х отладчиков для мобильности кода
        EventHandler event = new EventHandler() {
            @Override
            public void handle(Event event) {

                String res = reword(tex.getText(), db.getData(fild.getText()));

                //white box test
                if (res.length() <= 86)
                    if (!res.isEmpty())
                        tex.setText(res);
            }
        };
        /*
        ошибочные ситуации в GUI:
        слишком большой размер текста
        а именно больше 86
        (можно было бработать это в SQL
        создав атрибут VARCHAR(86),
        или работать с граф. эллементами,
        но сделаем вид что это не возможно)
         */

        tex.setText("");
        but.setOnAction(event);
        fild.setOnAction(event);
    }

    String reword(String old, String now){
         /*
        алгоритм предназначен для указания
        на повторяющиеся эллементы при запросе
        но сделаем вид что один артикл может содержать
        2 значения, в таком случае работа алгоритма будет не корректна
        (и опять сделаем вид что это не решается при оздании таблицы)
         */

        if (!old.contains(now)) {
            return now;
        }
        String[] a = old.split("]");
        if (a.length == 1)
            now += "]2";
        else
            now += "]" + Integer.toString((Integer.parseInt(a[1]) + 1));
        //сделаем метод возвратным
        //для тестирования через blackbox
        return now;
    }

    boolean unit_tests(){
        boolean allTestCompleted = true;
        long startTime = new Date().getTime();
        System.out.println("start test in " + startTime);
        if (black_box_test("test")){
            var stopTime = new Date().getTime();
            System.out.println("the test was performed at "+stopTime+" final time: "+ (stopTime - startTime));
        } else {
            allTestCompleted = false;
            var stopTime = new Date().getTime();
            System.out.println("test comlited in" + stopTime + " in " + (stopTime - startTime));
        }
        return allTestCompleted;
    }


    boolean black_box_test(String test){
        if (reword(test, test).equals(test + "]2"))
            if (reword(test+"]2", test).equals(test + "]3"))
                return true;
        return false;
    }
}


