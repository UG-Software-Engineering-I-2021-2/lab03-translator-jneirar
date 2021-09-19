package main;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TranslatorParallelTest {

    @Test(threadPoolSize = 20, invocationCount = 80)
    public void TestTranslation() throws IOException {
        long begin = System.currentTimeMillis();
        String translate = Translator.translate("es","en","Hola Mundo");
        long finish = System.currentTimeMillis();
        Assert.assertEquals(translate, "Hello World");


        if(finish-begin > 400000) {
            Assert.fail();
        }
    }
}