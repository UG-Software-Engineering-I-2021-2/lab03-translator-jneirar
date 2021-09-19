package main;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainTest  {

    @Test
    public void testToLanguage() {
        String en = Main.ENGLISH_LANGUAGE;
        Assert.assertEquals(en,"en");
    }

    @Test
    public void testFromLanguage() {
        String en = Main.SPANISH_LANGUAGE;
        Assert.assertEquals(en,"es");
    }

    @Test
    public void testTranslate() throws IOException {
        String res = Main.translate("Hola Mundo");
        Assert.assertEquals(res,"Hello World");
    }
}
