package example;

import java.util.List;

public class SearchService {
    public List<Valute> searchValute(List<Valute> loadedValutes, String searchedValue, Valute.Column column){
        return loadedValutes
                .stream()
                .filter(v -> {
                    switch (column){
                        case CURRENCY_CODE -> {
                            return v.getCurrencyCode().equals(searchedValue.toUpperCase());
                        }
                        case CURRENCY_NAME -> {
                            return v.getCurrencyName().equals(searchedValue);
                        }
                        default -> throw new IllegalArgumentException();
                    }
                })
                .toList();
    }
}
