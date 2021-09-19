package main;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TranslatorTest {

    @Test
    public void TestUrlBuilderSuccess() throws UnsupportedEncodingException {
        String finalUrl = Translator.urlBuilder("some","some","xd");
        Assert.assertEquals(finalUrl,"https://script.google.com/macros/s/AKfycbwS55pdBBrnicusnRvbfhOY3id4M061B1mcR6xP2R3ebLZ3PLNpKmL7FQkQUqvD9pEq/exec?q=xd&target=some&source=some");
    }

    @Test
    public void TestUrlBuilderFail() throws UnsupportedEncodingException {
        String finalUrl = Translator.urlBuilder("somsse","sss","xd");
        Assert.assertNotEquals(finalUrl,"https://script.google.com/macros/s/AKfycbwS55pdBBrnicusnRvbfhOY3id4M061B1mcR6xP2R3ebLZ3PLNpKmL7FQkQUqvD9pEq/exec?q=xddd&target=some&source=some");
    }

    @Test
    public void TestConnBuilderConnSuccess() throws IOException {
        URL url = new URL("https://someurl.com");
        HttpURLConnection conn = Translator.connectionBuilder(url);
        Assert.assertEquals(conn.getConnectTimeout(), 400);
    }

    @Test
    public void TestConnBuilderUserAgentSuccess() throws IOException {
        URL url = new URL("https://someurl.com");
        HttpURLConnection conn = Translator.connectionBuilder(url);
        Assert.assertEquals(conn.getRequestProperty("User-Agent"), "Mozilla/5.0");
    }


    @Test
    public void TestConnBuilderTranslateSuccess() throws IOException {
        String translate = Translator.translate("es","en","Hola Mundo");
        Assert.assertEquals(translate, "Hello World");
    }


    @Test
    public void TestConnBuilderTranslateFail() throws IOException {
        String translate = Translator.translate("es","en","Hola Mundo");
        Assert.assertNotEquals(translate, "Hola Mundo");
    }

    @Test(expectedExceptions = IOException.class, expectedExceptionsMessageRegExp =  "no lang from given")
    public void TestTranslateFailEmptyFrom() throws IOException {
        String translate = Translator.translate("","en","Hola Mundo");
        Throwable tr = new Throwable("no lang from given");
        Assert.assertEquals(translate, tr.getMessage());
    }

    @Test(expectedExceptions = IOException.class, expectedExceptionsMessageRegExp =  "no lang to given")
    public void TestTranslateFailEmptyTo() throws IOException {
        String translate = Translator.translate("es","","Hola Mundo");
        Throwable tr = new Throwable("no lang to given");
        Assert.assertEquals(translate, tr.getMessage());
    }

    @Test(expectedExceptions = IOException.class, expectedExceptionsMessageRegExp =  "Length capacity exceed or text empty")
    public void TestTranslateFailEmptyText() throws IOException {
        String translate = Translator.translate("es","en","");
        Throwable tr = new Throwable("Length capacity exceed or text empty");
        Assert.assertEquals(translate, tr.getMessage());
    }

    @Test(expectedExceptions = IOException.class, expectedExceptionsMessageRegExp =  "Length capacity exceed or text empty")
    public void TestTranslateFailFullText() throws IOException {
        String text = "";
        for(int i =0; i < 501; i++) {
            text += "a";
        }
        String translate = Translator.translate("es","en",text);
        Throwable tr = new Throwable("Length capacity exceed or text empty");
        Assert.assertEquals(translate, tr.getMessage());
    }

    @Test
    public void MainTest() {
        Main main = new Main();

    }


}