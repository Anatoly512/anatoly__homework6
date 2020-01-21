package Snowman;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IntegerConvertor {

    public Integer convertTextToInteger (Stage primaryStage, TextField TextString) {
        Integer integerValue;
        int value = 0;

        String StringToConvert = TextString.getText();

        try {
            value = Integer.parseInt(StringToConvert);
        }
        catch (Exception ex) {
            System.out.println("Вы ввели что-то не то !");
            ExceptionProcessing exeption = new ExceptionProcessing();
            exeption.exceptionWindowShow(primaryStage);
        }

        if (value < 0) {value = -(value);}
        if (value > 300) {value = 300;}

        integerValue = (Integer) (value);

        return integerValue;
    }


}
