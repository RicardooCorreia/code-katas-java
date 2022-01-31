package code.wars.help_the_bookseller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StockListTest {

    @Test
    void stockSummary_whenHasSingleStock_returnValue() {

        // Given
        String[] stock = new String[]{"ABAR 182"};
        String[] request = new String[]{"A"};

        // When
        final String result = StockList.stockSummary(stock, request);

        // Then
        assertThat(result)
                .isEqualTo("(A : 182)");
    }

    @Test
    void stockSummary_whenHasMultipleStock_returnSummedValue() {

        // Given
        String[] stock = new String[]{"ABAR 200", "AHJFS 800"};
        String[] request = new String[]{"A"};

        // When
        final String result = StockList.stockSummary(stock, request);

        // Then
        assertThat(result)
                .isEqualTo("(A : 1000)");
    }

    @Test
    void stockSummary_whenHasNoStock_returnZero() {

        // Given
        String[] stock = new String[]{"CBAR 600"};
        String[] request = new String[]{"A"};

        // When
        final String result = StockList.stockSummary(stock, request);

        // Then
        assertThat(result)
                .isEqualTo("(A : 0)");
    }

    @Test
    void stockSummary_whenStockHasSingleLetter_returnValue() {

        // Given
        String[] stock = new String[]{"C 993"};
        String[] request = new String[]{"C"};

        // When
        final String result = StockList.stockSummary(stock, request);

        // Then
        assertThat(result)
                .isEqualTo("(C : 993)");
    }

    @Test
    void stockSummary_fillsCorrectStock() {

        // Given
        String[] stock = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String[] request = new String[]{"A", "B"};

        // When
        final String result = StockList.stockSummary(stock, request);

        // Then
        assertThat(result)
                .isEqualTo("(A : 200) - (B : 1140)");
    }

    @Test
    void stockSummary_whenStockIsEmpty_returnEmptyString() {

        // Given
        String[] stock = new String[]{};
        String[] request = new String[]{"A", "B"};

        // When
        final String result = StockList.stockSummary(stock, request);

        // Then
        assertThat(result)
                .isEqualTo("");
    }

    @Test
    void stockSummary_whenRequestIsEmpty_returnEmptyString() {

        // Given
        String[] stock = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String[] request = new String[]{};

        // When
        final String result = StockList.stockSummary(stock, request);

        // Then
        assertThat(result)
                .isEqualTo("");
    }
}