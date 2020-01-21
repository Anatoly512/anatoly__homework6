package Snowman;

import javafx.scene.control.TextField;

public class IntegerConvertor {

    public static Integer convertTextToInteger (TextField TextString) {
        Integer integerValue;

        String StringToConvert = TextString.getText();

        integerValue = Integer.valueOf(StringToConvert);

        return integerValue;
    }

}
