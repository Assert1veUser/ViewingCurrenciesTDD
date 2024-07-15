package exampleTest;

import example.SortService;
import example.Valute;
import example.ValuteLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SortServiceTest {
    private SortService sortService = new SortService();
    private List<Valute> loadedValutes;
    @Test
    public void testSortServiceValuteByDateAscending() throws IOException {
        ValuteLoader loader = new ValuteLoader();
        List<Valute> valuteList = loader.loadValute("src/test/resources/currency_test.csv");
        List<Valute> sortedValuteList = sortService.sortByColumn(valuteList, Valute.Column.DATE, true);
        Assert.assertNotNull(sortedValuteList);
        Assert.assertEquals(valuteList.size(), sortedValuteList.size());
        Assert.assertNotSame(valuteList, sortedValuteList);
        for (int i = 0; i < sortedValuteList.size() - 1; i++) {
            Assert.assertTrue(sortedValuteList.get(i).getDate().getTime() <= sortedValuteList.get(i + 1).getDate().getTime());
        }
    }
}
