package exampleTest;

import example.SearchService;
import example.Valute;
import example.ValuteLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SearchServiceTest {
    private SearchService searchService = new SearchService();
    private List<Valute> loadedValutes;
    @Before
    public void loadValute() throws IOException{
        ValuteLoader loader = new ValuteLoader();
        loadedValutes = loader.loadValute("src/test/resources/currency_test.csv");
    }
    @Test
    public void testSearchByCurrencyCode(){
        String searchedValue = "USD";
        List<Valute> findedValutes = searchService.
                searchValute(loadedValutes, searchedValue, Valute.Column.CURRENCY_CODE);
        long expectedCodes = loadedValutes
                .stream()
                .filter(v -> v.getCurrencyCode().equals("USD"))
                .count();
        Assert.assertNotNull(findedValutes);
        Assert.assertEquals(expectedCodes, findedValutes.size());
        for(Valute valute : findedValutes){
            Assert.assertEquals(searchedValue, valute.getCurrencyCode());
        }
    }
    @Test
    public void testSearchByCurrencyName(){
        String searchedValue = "Армянских драмов";
        List<Valute> findedValutes = searchService
                .searchValute(loadedValutes, searchedValue, Valute.Column.CURRENCY_CODE);
        long expectedCodes = loadedValutes
                .stream()
                .filter(v -> v.getCurrencyCode().equals("Армянских драмов"))
                .count();
        Assert.assertNotNull(findedValutes);
        Assert.assertEquals(expectedCodes, findedValutes.size());
        for(Valute valute : findedValutes){
            Assert.assertEquals(searchedValue, valute.getCurrencyCode());
        }
    }
}
