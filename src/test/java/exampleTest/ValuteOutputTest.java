package exampleTest;

import example.Valute;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ValuteOutputTest {
    @Test
    public void testValuteToClient(){
        Valute valute = new Valute(
                "1",
                100.00,
                1,
                "Zoloto",
                "OOO",
                new Date()
        );
        String expectedValute = "1 100.00 Рублей = 1 Zoloto (OOO)";
        Assert.assertEquals(expectedValute, valute.toString());

        valute = new Valute();
        expectedValute = "NULL NULL Рублей = NULL NULL (NULL)";
        Assert.assertEquals(expectedValute, valute.toString());
    }
}
