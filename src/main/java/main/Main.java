package main;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    static final String ENGLISH_LANGUAGE = "en";
    static final String SPANISH_LANGUAGE = "es";
    static final Logger CUSTOM_LOGGER = Logger.getLogger(Main.class.getName());

    public void main() throws IOException {
        //Main function
    }


    public static String translate(String textToTranslate) throws IOException {
        return Translator.translate(SPANISH_LANGUAGE, ENGLISH_LANGUAGE, textToTranslate);
    }
}